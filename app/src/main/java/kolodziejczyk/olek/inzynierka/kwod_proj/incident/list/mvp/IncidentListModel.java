package kolodziejczyk.olek.inzynierka.kwod_proj.incident.list.mvp;

import java.util.ArrayList;

import kolodziejczyk.olek.inzynierka.kwod_proj.R;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.Incident;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.Slide;
import kolodziejczyk.olek.inzynierka.kwod_proj.utils.Strings;
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
        urlList.add(new Slide("https://st.depositphotos.com/2131499/3730/v/950/depositphotos_37307521-stock-illustration-fire-flame.jpg",
                Strings.oparzenia1));
        urlList.add(new Slide("http://osp.bestwina.pl/wp-content/uploads/2017/03/karetka.jpg", Strings.oparzenie2));
        urlList.add(new Slide("http://www.sklepbhpippoz.pl/galerie/z/znak-zakaz-noszenia-bizu_3371.jpg", Strings.oparzenie3));
        urlList.add(new Slide("http://static.scholaris.pl/resources/d856818295880620cd32d36c4b1f0e62/999/20130813103111000000/1051.png", Strings.oparzenie4));
        urlList.add(new Slide("http://www.nabrozszkola.republika.pl/11.6.1.jpg", Strings.oparzenie5));
        urlList.add(new Slide("https://www.wykop.pl/cdn/c3201142/comment_zlB2UnSMXna3Mc4oaIbQlCWCMoU4fPUU,w400.jpg", Strings.oparzenie6));
        slidesArray.add(urlList);

        urlList = new ArrayList<>();
        urlList.add(new Slide("http://twasul.info/wp-content/uploads/2017/03/709px-Bells_palsy_diagram-1024x756.jpg", Strings.udar1));
        urlList.add(new Slide("https://www.fairview.org/fv/groups/public/documents/images/104444.jpg", Strings.udar2));
        urlList.add(new Slide("http://betexperts.com.pl/wp-content/uploads/Zaburzenia%20mowy.jpg", Strings.udar3));
        urlList.add(new Slide("http://dooktor.pl/wp-content/uploads/2014/03/wzrokk.jpg", Strings.udar4));
        urlList.add(new Slide("http://blogstar.pl/wp-content/uploads/2015/10/udar-objawy.jpg", Strings.udar5));
        slidesArray.add(urlList);

        urlList = new ArrayList<>();
        urlList.add(new Slide("http://4.bp.blogspot.com/--YvNw_Q91XQ/VMluWHa0eHI/AAAAAAAAErg/zi39xEec9iQ/s1600/ALERTA.jpg", Strings.omdlenie1));
        urlList.add(new Slide("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-2.jpg",
                Strings.omdlenie2));
        urlList.add(new Slide ("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-3.jpg",
                Strings.omdlenie3));
        urlList.add(new Slide("http://www.kurierdabrowski.pl/wp-content/uploads/omdlenie.jpg", Strings.omdlenie4));
        urlList.add(new Slide("https://blog.bilety24.pl/wp-content/uploads/2016/01/Wykrzyknik-1024x1024.jpg", Strings.omdlenie5));
        slidesArray.add(urlList);

        urlList = new ArrayList<>();
        urlList.add(new Slide("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-2.jpg",
                Strings.rko1));
        urlList.add(new Slide("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-3.jpg",
                Strings.rko2));
        urlList.add(new Slide("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-4d.jpg",
                Strings.rko3));
        urlList.add(new Slide("http://kobietamag.pl/wp-content/uploads/2012/01/pierwsza-pomoc-ratowanie-zycia-6.jpg",
                Strings.rko4));
        slidesArray.add(urlList);

        urlList= new ArrayList<>();
        urlList.add(new Slide("http://4.bp.blogspot.com/-J1PTNsTf4HA/VobcWnjPlfI/AAAAAAAAAIA/EqhQnTFDVO8/s320/1.png",
                Strings.boczna1));
        urlList.add(new Slide("http://3.bp.blogspot.com/-c8V6wJprdZE/VobckgmNF7I/AAAAAAAAAII/gIjvdn8_334/s320/2.png",
                Strings.boczna2));
        urlList.add(new Slide("http://4.bp.blogspot.com/-xKtVcq3hqNA/Vobcp6fL4SI/AAAAAAAAAIQ/lc-MtvJvJOU/s320/3.png",
                Strings.boczna3));
        urlList.add(new Slide("http://2.bp.blogspot.com/-EKiVq6dDHXc/VobctDZ8F7I/AAAAAAAAAIY/XkhGL2HtrvQ/s320/4.png",
                Strings.boczna4));
        slidesArray.add(urlList);

        urlList=new ArrayList<>();
        urlList.add(new Slide("http://olmamc.pl/wp-content/uploads/2015/04/Czerwony_znak_zapytania.png", Strings.zlamanie1));
        urlList.add(new Slide("https://www.akademiaparp.gov.pl/pills/JPPPZ/JPPPZ_thumb.jpg", Strings.zlamanie2));
        urlList.add(new Slide("http://stridestrong.com/wp-content/uploads/2016/04/Skeletal-diagram-of-a-rib-fracture.jpg", Strings.zlamanie3));
        urlList.add(new Slide("http://www.iskra65.republika.pl/grafiki/chusta.jpg", Strings.zlamanie4));
        urlList.add(new Slide("http://www.asrpedia.ir/wp-content/uploads/2016/11/1081-600x330.jpg", Strings.zlamanie5));
        urlList.add(new Slide("https://blog.bilety24.pl/wp-content/uploads/2016/01/Wykrzyknik-1024x1024.jpg",Strings.zlamanie6));
        slidesArray.add(urlList);





        addIncident("Ukąszenie żmii", R.drawable.snake_24, slidesArray.get(0));
        addIncident("Poparzenie", R.drawable.fire_element_24, slidesArray.get(1));
        addIncident("Udar", R.drawable.brain_24, slidesArray.get(2));
        addIncident("Utrata przytomności", R.drawable.base_jumping_24, slidesArray.get(3));
        addIncident("Zatrzymanie akcji serca", R.drawable.medical_heart_24, slidesArray.get(4));
        addIncident("Ułożenie w pozycji bocznej ustalonej", R.drawable.physical_therapy_24, slidesArray.get(5));
        addIncident("Złamanie zamknięte", R.drawable.triangular_bandage_24, slidesArray.get(6));
        //addIncident("Podtopienie", R.drawable.ic_pool_black_24dp, slidesArray.get(5));

        return incidents;
    }

    private void addIncident(String name, int iconRes, ArrayList<Slide> slides) {
        Incident tempIncident = new Incident(name, iconRes, slides);
        incidents.add(tempIncident);
    }
}
