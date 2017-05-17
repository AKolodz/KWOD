package kolodziejczyk.olek.inzynierka.kwod_proj.fabs;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.support.design.widget.FloatingActionButton;
import android.view.animation.LinearInterpolator;

/**
 * Created by A. Kołodziejczyk on 2017-05-17.
 */

public class FabAnimator {

    public static AnimatorSet animateAppearance(FloatingActionButton animatedFab, float xStartPosition, float yStartPosition, float xEndPosition, float yEndPosition, int duration) {
        ValueAnimator verticalAnimator = ValueAnimator.ofFloat(yStartPosition, yEndPosition);
        verticalAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            animatedFab.setTranslationY(value);
        });
        verticalAnimator.setInterpolator(new LinearInterpolator());
        verticalAnimator.setDuration(duration);

        ValueAnimator horizontalAnimator = ValueAnimator.ofFloat(xStartPosition, xEndPosition);
        horizontalAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            animatedFab.setTranslationX(value);
        });
        horizontalAnimator.setInterpolator(new LinearInterpolator());
        horizontalAnimator.setDuration(duration);

        AnimatorSet displacementAnimator = new AnimatorSet();
        displacementAnimator.play(verticalAnimator).with(horizontalAnimator);
        return displacementAnimator;
    }

    public static AnimatorSet animateHiding(FloatingActionButton animatedFab, float xStartPosition, float yStartPosition, float xEndPosition, float yEndPosition, int duration) {
        ValueAnimator verticalAnimator = ValueAnimator.ofFloat(yStartPosition, yEndPosition);
        verticalAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            animatedFab.setTranslationY(value);
        });
        verticalAnimator.setInterpolator(new LinearInterpolator());
        verticalAnimator.setDuration(duration);

        ValueAnimator horizontalAnimator = ValueAnimator.ofFloat(xStartPosition, xEndPosition);
        horizontalAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            animatedFab.setTranslationX(value);
        });
        horizontalAnimator.setInterpolator(new LinearInterpolator());
        horizontalAnimator.setDuration(duration);

        AnimatorSet displacementAnimator = new AnimatorSet();
        displacementAnimator.play(verticalAnimator).with(horizontalAnimator);
        return displacementAnimator;
    }
}
