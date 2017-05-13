package kolodziejczyk.olek.inzynierka.kwod_proj.incidents_list.mvp;

import java.util.ArrayList;

import kolodziejczyk.olek.inzynierka.kwod_proj.Incident;

/**
 * Created by A. Kołodziejczyk on 2017-05-13.
 */

public interface IncidentListMVP {

    interface Model{
        ArrayList<Incident> getIncidentsList();
    }

    interface Presenter{
        void getIncidentsList();
    }

    interface View{
        void showIncidents(ArrayList<Incident> incidents);
    }
}
