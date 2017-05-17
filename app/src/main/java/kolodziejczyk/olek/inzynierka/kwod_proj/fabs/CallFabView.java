package kolodziejczyk.olek.inzynierka.kwod_proj.fabs;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;

/**
 * Created by A. Kołodziejczyk on 2017-05-16.
 */

public class CallFabView extends FrameLayout {

    @BindView(R.id.calling_fab)
    FloatingActionButton callingFab;

    @BindView(R.id.ambulance_fab)
    FloatingActionButton callAmbulance;

    @BindView(R.id.firefighters_fab)
    FloatingActionButton callFirefighters;

    @BindView(R.id.police_fab)
    FloatingActionButton callPolice;

    @BindView(R.id.police_number)
    TextView policeNumber;

    @BindView(R.id.ambulance_number)
    TextView ambulanceNumber;

    @BindView(R.id.firefighters_number)
    TextView firefightersNumber;


    private boolean isClicked = false;
    private AnimatorSet callPoliceAnimationManager, callAmbulanceAnimationManager, callFirefightersAnimationManager;

    public CallFabView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public CallFabView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CallFabView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(21)
    public CallFabView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        if (isInEditMode())
            return;
        LayoutInflater.from(context).inflate(R.layout.fab_view, this, true);
        ButterKnife.bind(this);
        initOnClickListeners(context);
    }

    private void initOnClickListeners(Context context) {
        callingFab.setOnClickListener(v -> {
            if (!isClicked)
                showFabs(context);
            else
                hideFabs(context);
        });
        callPolice.setOnClickListener(v -> makeCall(context, "721320884"));
        callAmbulance.setOnClickListener(v -> makeCall(context, "885486003"));
        callFirefighters.setOnClickListener(v -> Toast.makeText(context, "Dzwonię po straż", Toast.LENGTH_SHORT).show());
    }

    private void makeCall(Context context, String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        context.startActivity(callIntent);
    }

    private void hideFabs(Context context) {
        callAmbulanceAnimationManager = FabAnimator.animateAppearance(callAmbulance, 0, -convertDpToPixel(176, context), 0, 0, 200);
        callFirefightersAnimationManager = FabAnimator.animateAppearance(callFirefighters, 0, -convertDpToPixel(120, context), 0, 0, 200);
        callPoliceAnimationManager = FabAnimator.animateAppearance(callPolice, 0, -convertDpToPixel(64, context), 0, 0, 200);

        callFirefightersAnimationManager.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                callPolice.setClickable(false);
                callAmbulance.setClickable(false);
                callFirefighters.setClickable(false);
                policeNumber.setVisibility(INVISIBLE);
                ambulanceNumber.setVisibility(INVISIBLE);
                firefightersNumber.setVisibility(INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                callPolice.setVisibility(INVISIBLE);
                callAmbulance.setVisibility(INVISIBLE);
                callFirefighters.setVisibility(INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        callPoliceAnimationManager.start();
        callAmbulanceAnimationManager.start();
        callFirefightersAnimationManager.start();
        isClicked = false;
    }

    private void showFabs(Context context) {
        callAmbulanceAnimationManager = FabAnimator.animateAppearance(callAmbulance, 0, 0, 0, -convertDpToPixel(176, context), 200);
        callFirefightersAnimationManager = FabAnimator.animateAppearance(callFirefighters, 0, 0, 0, -convertDpToPixel(120, context), 200);
        callPoliceAnimationManager = FabAnimator.animateAppearance(callPolice, 0, 0, 0, -convertDpToPixel(64, context), 200);

        callFirefightersAnimationManager.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                callPolice.setVisibility(VISIBLE);
                callAmbulance.setVisibility(VISIBLE);
                callFirefighters.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                callPolice.setClickable(true);
                callAmbulance.setClickable(true);
                callFirefighters.setClickable(true);
                policeNumber.setVisibility(VISIBLE);
                ambulanceNumber.setVisibility(VISIBLE);
                firefightersNumber.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        callPoliceAnimationManager.start();
        callAmbulanceAnimationManager.start();
        callFirefightersAnimationManager.start();
        isClicked = true;
    }

    private int convertDpToPixel(int dpValue, Context context) {
        float scale = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
