package kolodziejczyk.olek.inzynierka.kwod_proj.incident;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
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

        callingFab.setOnClickListener(v -> {
            Log.i("TAG", "Clicked");
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
        });

    }
}
