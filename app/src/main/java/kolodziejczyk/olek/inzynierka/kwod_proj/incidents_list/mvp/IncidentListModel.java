package kolodziejczyk.olek.inzynierka.kwod_proj.incidents_list.mvp;

import java.util.ArrayList;

import kolodziejczyk.olek.inzynierka.kwod_proj.Incident;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;
import lombok.NoArgsConstructor;

/**
 * Created by A. Kołodziejczyk on 2017-05-13.
 */
@NoArgsConstructor
public class IncidentListModel implements IncidentListMVP.Model {

    ArrayList<Incident> incidents = new ArrayList<>();
    ArrayList<ArrayList<String>> slidesArray = new ArrayList<>();
    ArrayList<String> urlList = new ArrayList<>();

    @Override
    public ArrayList<Incident> getIncidentsList() {
        //TODO: make it more clear, add rest of incidents here
        urlList.add("http://pobierak.jeja.pl/images/5/f/a/143031_wonsz.jpg");
        urlList.add("http://pobierak.jeja.pl/images/5/6/2/154429_wonsz.jpg");
        urlList.add("http://pobierak.jeja.pl/images/0/1/e/126850_olej-szkole.jpg");
        slidesArray.add(urlList);

        urlList = new ArrayList<>();
        //kolejne slajdy
        slidesArray.add(urlList);

        addIncident("Ukąszenie żmiji", R.mipmap.ic_launcher, slidesArray.get(0));
        addIncident("Poparzenie", R.mipmap.ic_launcher_round, slidesArray.get(1));
        return incidents;
    }

    private void addIncident(String name, int iconRes, ArrayList<String> slides) {
        Incident tempIncident = new Incident(name, iconRes, slides);
        incidents.add(tempIncident);
    }
}
