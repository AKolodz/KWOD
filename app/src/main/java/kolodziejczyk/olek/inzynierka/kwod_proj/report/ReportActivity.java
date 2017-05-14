package kolodziejczyk.olek.inzynierka.kwod_proj.report;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;

/**
 * Created by A. Kołodziejczyk on 2017-05-14.
 */

public class ReportActivity extends AppCompatActivity {

    @BindView(R.id.reason_et)
    EditText reason;

    @BindView(R.id.additional_comments)
    EditText comments;

    @BindView(R.id.additional_injuries)
    EditText injuries;

    @BindView(R.id.medicament_et)
    EditText medicines;

    @BindView(R.id.allergies)
    EditText allergies;

    @BindView(R.id.heart_pause_duration_et)
    EditText heartPauseDuration;

    @BindView(R.id.save)
    Button save;

    @BindView(R.id.load)
    Button load;

    @BindView(R.id.consciousness_cb)
    CheckBox consciousness;

    @BindView(R.id.heart_pause_cb)
    CheckBox heartStop;

    @BindView(R.id.heart_pause_duration_et)
    EditText heartStopDuration;

    private Report report = new Report();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);

        setOnClickListeners();
    }

    private void setOnClickListeners() {
        heartStop.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                heartStopDuration.setVisibility(View.VISIBLE);
                heartStopDuration.setClickable(true);
            }else{
                heartStopDuration.setVisibility(View.INVISIBLE);
                heartStopDuration.setClickable(false);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                report = getReport();
                //to JSON
                //save with SharedPrefs
            }
        });
    }

    private Report getReport() {
        return new Report(reason.getText().toString(), comments.getText().toString(),
                injuries.getText().toString(), medicines.getText().toString(),
                allergies.getText().toString(), consciousness.isChecked(),heartStop.isChecked(),
                Integer.valueOf(heartPauseDuration.getText().toString()));
    }
}
