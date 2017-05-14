package kolodziejczyk.olek.inzynierka.kwod_proj.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by A. Kołodziejczyk on 2017-05-14.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    String possibleReason;
    String additionalComments;
    String additionalInjuries;
    String medicines;
    String allergies;
    boolean lostOfConsciousness;
    boolean heartRatePause;
    int heartRatePauseLength;
}
