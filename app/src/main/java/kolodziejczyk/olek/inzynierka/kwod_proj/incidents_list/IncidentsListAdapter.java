package kolodziejczyk.olek.inzynierka.kwod_proj.incidents_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kolodziejczyk.olek.inzynierka.kwod_proj.Incident;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by A. Kołodziejczyk on 2017-05-10.
 */
@Setter
@NoArgsConstructor
public class IncidentsListAdapter extends RecyclerView.Adapter<IncidentsListViewHolder> {

    private List<Incident> incidentsList = new ArrayList<Incident>();
    private OnIncidentItemClickListener onIncidentItemClickListener;

    public IncidentsListAdapter(ArrayList<Incident> incidentsList, OnIncidentItemClickListener onIncidentItemClickListener) {
        this.incidentsList = incidentsList;
        this.onIncidentItemClickListener = onIncidentItemClickListener;
    }

    @Override
    public IncidentsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.incident_item, parent, false);
        return new IncidentsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IncidentsListViewHolder holder, int position) {
        Incident incident = incidentsList.get(position);

        holder.icon.setImageResource(incident.getIconResource());
        holder.name.setText(incident.getName());
        holder.bind(incident, onIncidentItemClickListener);
    }

    @Override
    public int getItemCount() {
        return incidentsList.size();
    }
}
