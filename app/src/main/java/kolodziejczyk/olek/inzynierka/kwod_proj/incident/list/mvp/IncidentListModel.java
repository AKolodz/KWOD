package kolodziejczyk.olek.inzynierka.kwod_proj.incident.list.mvp;

import java.util.ArrayList;

import kolodziejczyk.olek.inzynierka.kwod_proj.R;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.Incident;
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
        urlList.add(new Slide("http://static.scholaris.pl/resources/d856818295880620cd32d36c4b1f0e62/999/20130813103111000000/1051.png",
                "Schłódź oparzone miejsce letnią wodą."));
        slidesArray.add(urlList);

        urlList = new ArrayList<>();
        urlList.add(new Slide("http://blogstar.pl/wp-content/uploads/2015/10/udar-objawy.jpg", "1. Poproś osobę, aby się uśmiechęła\n" +
                "2. Poproś, aby osoba wstała lub podniosła obie ręce do góry.\n" +
                "3. Poproś, aby osoba powtórzyła zdanie: Czarna krowa jadła trawę.\n" +
                "4. Zapytaj osobę, czy nie pogorszyło się jej widzenie." +
                "Opadający kącik ust, problemy z koordynacją ruchową, zaburzenia widzenia lub mowy to objawy udar, zadzwoń niezwołczenie po pogotowie."));
        slidesArray.add(urlList);

        urlList = new ArrayList<>();
        urlList.add(new Slide("http://www.kurierdabrowski.pl/wp-content/uploads/omdlenie.jpg",
                "1. Wynieś poszkodowanego z miejsca, w którym omdlał (np. kościół).\n" +
                        "2. Jeśli to niemożliwe zapewnij dostępu świeżego powietrza.\n" +
                        "3. Ułóż poszkodowanego na wznak (na plecach).\n" +
                        "4. Ocena funkcji życiowych - udrożnij drogi oddechowe poprzez odgięcie głowy do tyłu\n" +
                        " a następnie sprawdź oddech przez 10 sekund \n" +
                        "(w tym czasie powinniśmy usłyszeć co najmniej dwa oddechy)." +
                        "5. Unieś nogi poszkodowanego do góry.\n"));
        urlList.add(new Slide("https://blog.bilety24.pl/wp-content/uploads/2016/01/Wykrzyknik-1024x1024.jpg",
                "NIE NALEŻY:\n" +
                        "- szarpać poszkodowanego, klepać po twarzy, zadawać bólu,\n" +
                        "- cucić za pomocą soli trzeźwiących ani innych środków,\n" +
                        "- chlapać wodą, wlewać napojów ani wpychać jedzenia do ust,\n" +
                        "- podawać żadnych leków (!).\n"));
        slidesArray.add(urlList);

        urlList = new ArrayList<>();
        urlList.add(new Slide("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-2.jpg",
                "Połóż poszkodowanego na plecach, odchyl jego głowę do tyłu, aby udrożnić drogi oddechowe."));
        urlList.add(new Slide("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-3.jpg",
                "Sprawdź czy poszkodowany oddycha.\n" +
                        "Prowadz obserwację przez 10 sekund. W tym czasie powinny wystąpić co najmniej dwa oddechy.\n" +
                        "Jeśli poszkodowany nie oddycha niezwłocznie wezwij pomoc i przystąp do resuscytacji krążeniowo-oddechowej.\n" +
                        "Jeśli poszkodowany oddycha ułoż go w pozycji bocznej ustalonej."));
        urlList.add(new Slide("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-4d.jpg",
                "Wykonaj 30 uciśnieć klatki piersiowej."));
        urlList.add(new Slide("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-6.jpg",
                "Wykoanj dwa wdechy.\n" +
                        "Jeśli poszkodowany w dalszym ciągu nie oddycha kontynuuj resuscytację wykonując na zmianę 30 uciśnięć i 2 wdechy.\n" +
                        "Jeśli poszkodowany zaczął oddychać ułoż go w pozycji bocznej ustalonej i kontroluj czy nie ustał oddech.\n" +
                        "Zaczekaj z poszkodowanym do przyjazdu pogotowia."));
        slidesArray.add(urlList);


        addIncident("Ukąszenie żmii", R.drawable.snake_24, slidesArray.get(0));
        addIncident("Poparzenie", R.drawable.fire_element_24, slidesArray.get(1));
        addIncident("Udar", R.drawable.brain_24, slidesArray.get(2));
        addIncident("Utrata przytomności", R.drawable.base_jumping_24, slidesArray.get(3));
        addIncident("Zatrzymanie akcji serca", R.drawable.medical_heart_24, slidesArray.get(4));
        //addIncident("Podtopienie", R.drawable.ic_pool_black_24dp, slidesArray.get(5));
        //addIncident("Złamanie", R.drawable.triangular_bandage_24, slidesArray.get(6));
        return incidents;
    }

    private void addIncident(String name, int iconRes, ArrayList<Slide> slides) {
        Incident tempIncident = new Incident(name, iconRes, slides);
        incidents.add(tempIncident);
    }
}
