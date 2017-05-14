package kolodziejczyk.olek.inzynierka.kwod_proj.incident.list.mvp;

import java.util.ArrayList;

import kolodziejczyk.olek.inzynierka.kwod_proj.incident.Incident;

/**
 * Created by A. Kołodziejczyk on 2017-05-13.
 */

public class IncidentListPresenter implements IncidentListMVP.Presenter {

    private IncidentListMVP.Model model;
    private IncidentListMVP.View view;
    private ArrayList<Incident> incidents;

    public IncidentListPresenter(IncidentListMVP.Model model, IncidentListMVP.View view) {
        this.model = model;
        this.view = view;
        this.incidents = new ArrayList<>();
    }

    @Override
    public void getIncidentsList() {
        incidents=model.getIncidentsList();
        view.showIncidents(incidents);
    }
}
