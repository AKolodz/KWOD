package kolodziejczyk.olek.inzynierka.kwod_proj.incident.slideshow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.Slide;

/**
 * Created by A. Kołodziejczyk on 2017-05-11.
 */


public class CustomPagerAdapter extends PagerAdapter {

    @BindView(R.id.slide_image_view)
    ImageView slideImage;

    @BindView(R.id.image_description)
    TextView slideDescription;

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Slide> slides;

    public CustomPagerAdapter(Context context, ArrayList<Slide> slides) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.slides = slides;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = inflater.inflate(R.layout.slideshow_item, container, false);
        ButterKnife.bind(this, itemView);
        setDataInsideCard(position);

        container.addView(itemView);

        return itemView;
    }

    private void setDataInsideCard(int position) {
        Picasso.with(context).load(slides.get(position).getUrl()).into(slideImage);
        slideDescription.setText(slides.get(position).getDescription());
    }


    @Override
    public int getCount() {
        return slides.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object); //todo: check if casting is necessary
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
