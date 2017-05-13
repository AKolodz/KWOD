package kolodziejczyk.olek.inzynierka.kwod_proj;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by A. Kołodziejczyk on 2017-05-13.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Slide implements Serializable {
    private String url;
    private String description;
}
