package kolodziejczyk.olek.inzynierka.kwod_proj.incidents_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.Incident;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident_slideshow.IncidentSlideshowActivity;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;

public class IncidentsListActivity extends AppCompatActivity {

    @BindView(R.id.recycler_incidents)
    RecyclerView recyclerView;

    private IncidentsListAdapter adapter = new IncidentsListAdapter(new ArrayList<>(), incident -> {
        Intent intent = new Intent(getApplicationContext(), IncidentSlideshowActivity.class);
        //todo: add list with images from chosen incident to intent
        startActivity(intent);
    });
    private List<Incident> incidentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.incidents_list_activity);
        ButterKnife.bind(this);
        fillAdapter();
        setRecyclerView();
    }

    private void fillAdapter() {
        //todo: presenter calls from here
        incidentList.add(new Incident("Podtopienie", R.mipmap.ic_launcher));
        incidentList.add(new Incident("Poparzenie", R.mipmap.ic_launcher_round));
        adapter.setIncidentsList(incidentList);
        adapter.notifyDataSetChanged();
    }

    private void setRecyclerView() {
        //TODO: Spacing with recyclerView.addItemDecoration(decorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}
