package kolodziejczyk.olek.inzynierka.kwod_proj.incident.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.Incident;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.list.mvp.IncidentListMVP;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.list.mvp.IncidentListModel;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.list.mvp.IncidentListPresenter;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.slideshow.IncidentSlideshowActivity;

public class IncidentsListActivity extends AppCompatActivity implements IncidentListMVP.View {

    public static final String SLIDES = "EXTRA_SLIDES";

    @BindView(R.id.recycler_incidents)
    RecyclerView recyclerView;

    private IncidentListPresenter presenter;

    private IncidentsListAdapter adapter = new IncidentsListAdapter(new ArrayList<>(), incident -> {
        Intent intent = new Intent(getApplicationContext(), IncidentSlideshowActivity.class);
        intent.putExtra(SLIDES, incident.getSlides());
        startActivity(intent);
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.incidents_list_activity);
        ButterKnife.bind(this);

        presenter = new IncidentListPresenter(new IncidentListModel(), this);
        presenter.getIncidentsList();

        setRecyclerView();
    }

    private void setRecyclerView() {
        //TODO: Spacing with recyclerView.addItemDecoration(decorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showIncidents(ArrayList<Incident> incidents) {
        adapter.setIncidentsList(incidents);
        adapter.notifyDataSetChanged();
    }
}
