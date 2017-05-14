package kolodziejczyk.olek.inzynierka.kwod_proj.incident.list.mvp;

import java.util.ArrayList;

import kolodziejczyk.olek.inzynierka.kwod_proj.incident.Incident;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.Slide;
import lombok.NoArgsConstructor;

/**
 * Created by A. Kołodziejczyk on 2017-05-13.
 */
@NoArgsConstructor
public class IncidentListModel implements IncidentListMVP.Model {

    ArrayList<Incident> incidents = new ArrayList<>();
    ArrayList<ArrayList<Slide>> slidesArray = new ArrayList<>();
    ArrayList<Slide> urlList = new ArrayList<>();

    @Override
    public ArrayList<Incident> getIncidentsList() {
        //TODO: make it more clear, add rest of incidents here
        urlList.add(new Slide("http://pobierak.jeja.pl/images/5/f/a/143031_wonsz.jpg", "Wonsz wiolinowy"));
        urlList.add(new Slide("http://pobierak.jeja.pl/images/5/6/2/154429_wonsz.jpg", "Wonsz do morza"));
        urlList.add(new Slide("http://pobierak.jeja.pl/images/0/1/e/126850_olej-szkole.jpg", "Wonsz LamAlpaka"));
        slidesArray.add(urlList);

        urlList = new ArrayList<>();
        //kolejne slajdy
        slidesArray.add(urlList);

        addIncident("Ukąszenie żmiji", R.drawable.snake_24, slidesArray.get(0));
        addIncident("Poparzenie", R.drawable.fire_element_24, slidesArray.get(1));
        addIncident("Udar", R.drawable.brain_24, slidesArray.get(2));
        addIncident("Utrata przytomności", R.drawable.base_jumping_24, slidesArray.get(3));
        addIncident("Podtopienie", R.drawable.ic_pool_black_24dp, slidesArray.get(4));
        addIncident("Złamanie", R.drawable.triangular_bandage_24, slidesArray.get(5));
        return incidents;
    }

    private void addIncident(String name, int iconRes, ArrayList<Slide> slides) {
        Incident tempIncident = new Incident(name, iconRes, slides);
        incidents.add(tempIncident);
    }
}
