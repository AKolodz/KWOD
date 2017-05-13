package kolodziejczyk.olek.inzynierka.kwod_proj.report;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import kolodziejczyk.olek.inzynierka.kwod_proj.R;

/**
 * Created by A. Kołodziejczyk on 2017-05-14.
 */

public class ReportActivity extends AppCompatActivity {

    @BindView(R.id.save_button)
    Button save;

    @BindView(R.id.load_button)
    Button load;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }
}
