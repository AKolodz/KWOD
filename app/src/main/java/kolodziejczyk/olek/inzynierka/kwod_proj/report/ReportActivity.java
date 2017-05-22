package kolodziejczyk.olek.inzynierka.kwod_proj.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;

/**
 * Created by A. Kołodziejczyk on 2017-05-14.
 */

public class ReportActivity extends AppCompatActivity {

    public static final String REPORT_KEY = "Report key";
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


    private Report report = new Report();
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor sharedEditor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);
        sharedPrefsInit();
        setOnClickListeners();
    }

    private void sharedPrefsInit() {
        sharedPref = getPreferences(Context.MODE_PRIVATE);
        sharedEditor = sharedPref.edit();
    }

    private void setOnClickListeners() {
        heartStop.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                heartPauseDuration.setVisibility(View.VISIBLE);
                heartPauseDuration.setClickable(true);
            } else {
                heartPauseDuration.setVisibility(View.INVISIBLE);
                heartPauseDuration.setClickable(false);
            }
        });

        save.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton("Potwierdź", (dialog, which) -> {
                        Toast.makeText(this,"Zapisano", Toast.LENGTH_SHORT).show();
                        saveReport(getReportData());})
                    .setNegativeButton("Zrezygnuj", (dialog, which) -> {})
                    .setTitle("Zapisać raport w obecnej postaci?")
                    .setMessage("Spowoduje to usunięcie poprzednio zapisanego raportu");
            builder.create().show();
        });

        load.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton("Potwierdź", (dialog, which) -> {
                        setReportData(loadReport());
                        Toast.makeText(this, "Wczytano", Toast.LENGTH_SHORT).show();})
                    .setNegativeButton("Zrezygnuj", (dialog, which) ->{})
                    .setTitle("Wczytać ostatni raport?")
                    .setMessage("Spowoduje to nadpisanie obecnie widocznego raportu");
            builder.create().show();
        });
    }

    private void setReportData(Report report) {
        reason.setText(report.getPossibleReason());
        comments.setText(report.getAdditionalComments());
        medicines.setText(report.getMedicines());
        injuries.setText(report.getAdditionalInjuries());
        allergies.setText(report.getAllergies());
        heartPauseDuration.setText(report.getHeartRatePauseLength());
        heartStop.setChecked(report.isHeartRatePause());
        consciousness.setChecked(report.isLostOfConsciousness());
    }

    private Report loadReport() {
        Gson gson = new Gson();
        String jsonReport = sharedPref.getString(REPORT_KEY, " ");
        return report = gson.fromJson(jsonReport, Report.class);
    }

    private void saveReport(Report report) {
        Gson gson = new Gson();
        String jsonReport = gson.toJson(report);
        sharedEditor.putString(REPORT_KEY, jsonReport);
        sharedEditor.commit();
    }

    private Report getReportData() {
        return new Report(reason.getText().toString(), comments.getText().toString(),
                injuries.getText().toString(), medicines.getText().toString(),
                allergies.getText().toString(), consciousness.isChecked(), heartStop.isChecked(),
                heartPauseDuration.getText().toString());
    }
}
