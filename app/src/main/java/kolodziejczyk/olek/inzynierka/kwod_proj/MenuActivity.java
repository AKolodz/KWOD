package kolodziejczyk.olek.inzynierka.kwod_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.fabs.CallFabView;
import kolodziejczyk.olek.inzynierka.kwod_proj.incident.list.IncidentsListActivity;
import kolodziejczyk.olek.inzynierka.kwod_proj.report.ReportActivity;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.app_name)
    TextView appName;

    @BindView(R.id.app_description)
    TextView appDescription;

    @BindView(R.id.incident_list_button)
    Button showList;

    @BindView(R.id.report_button)
    Button prepareReport;

    @BindView(R.id.views_container)
    FrameLayout viewsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        setTextViews();
        setOnClickListeners();

        viewsContainer.addView(new CallFabView(this));
    }

    private void setOnClickListeners() {
        showList.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), IncidentsListActivity.class)));
        prepareReport.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), ReportActivity.class)));
    }

    private void setTextViews() {
        appName.setText(R.string.app_name);
        appDescription.setText(R.string.app_description);
    }
}
