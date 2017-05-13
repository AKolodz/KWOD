package kolodziejczyk.olek.inzynierka.kwod_proj.incident_slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;
import kolodziejczyk.olek.inzynierka.kwod_proj.Slide;
import kolodziejczyk.olek.inzynierka.kwod_proj.incidents_list.IncidentsListActivity;

/**
 * Created by A. Kołodziejczyk on 2017-05-11.
 */

public class IncidentSlideshowActivity extends AppCompatActivity {

    @BindView(R.id.pager)
    ViewPager viewPager;

    private ArrayList<Slide> slides = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slideshow_activity);
        ButterKnife.bind(this);
        slides = (ArrayList<Slide>) getIntent().getSerializableExtra(IncidentsListActivity.SLIDES);
        setViewPager();

    }

    private void setViewPager() {
        viewPager.setAdapter(new CustomPagerAdapter(this, slides));
    }
}
