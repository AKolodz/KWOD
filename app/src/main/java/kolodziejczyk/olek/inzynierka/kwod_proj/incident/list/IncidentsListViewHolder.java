package kolodziejczyk.olek.inzynierka.kwod_proj.incident.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.Incident;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by A. Kołodziejczyk on 2017-05-10.
 */
@Getter
@Setter
public class IncidentsListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.incident_icon)
    ImageView icon;

    @BindView(R.id.incident_name)
    TextView name;

    public IncidentsListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Incident incident, OnIncidentItemClickListener onIncidentItemClickListener) {
        itemView.setOnClickListener(v -> onIncidentItemClickListener.onIncidentClick(incident));
    }
}
