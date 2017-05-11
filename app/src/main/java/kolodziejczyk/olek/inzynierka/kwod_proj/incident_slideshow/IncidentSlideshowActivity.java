package kolodziejczyk.olek.inzynierka.kwod_proj.incident_slideshow;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;

/**
 * Created by A. Kołodziejczyk on 2017-05-11.
 */

public class IncidentSlideshowActivity extends AppCompatActivity{

    @BindView(R.id.pager)
    ViewPager viewPager;

    private int[] slides={
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher_round
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slideshow_activity);
        ButterKnife.bind(this);
        setSlides();
        setViewPager();

    }

    private void setViewPager() {
        viewPager.setAdapter(new CustomPagerAdapter(this,slides));
    }

    public void setSlides() {
        //todo: get slides from intent
        //if not possible try replace it with list
    }
}
