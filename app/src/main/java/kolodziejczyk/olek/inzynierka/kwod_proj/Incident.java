package kolodziejczyk.olek.inzynierka.kwod_proj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by A. Kołodziejczyk on 2017-05-11.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Incident {
    private String name;
    private int iconResource;
    //private int[] slides; todo: implement this or check if we can use list of ints here
}
