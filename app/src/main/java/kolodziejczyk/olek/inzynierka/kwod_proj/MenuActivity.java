package kolodziejczyk.olek.inzynierka.kwod_proj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import kolodziejczyk.olek.inzynierka.kwod_proj.incidents_list.IncidentsListActivity;

public class MenuActivity extends AppCompatActivity {

    @BindView(R.id.app_name)
    TextView appName;

    @BindView(R.id.app_description)
    TextView appDescription;

    @BindView(R.id.incident_list_button)
    Button showList;

    @BindView(R.id.report_button)
    Button prepareReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        setTextViews();
        setOnClickListeners();


    }

    private void setOnClickListeners() {
        showList.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),IncidentsListActivity.class);
            startActivity(intent);
        });

        prepareReport.setOnClickListener(v ->
                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show());


    }

    private void setTextViews() {
        appName.setText(R.string.app_name);
        appDescription.setText(R.string.app_description);
    }
}
