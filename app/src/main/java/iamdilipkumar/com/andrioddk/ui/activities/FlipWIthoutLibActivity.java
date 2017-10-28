package iamdilipkumar.com.andrioddk.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import iamdilipkumar.com.andrioddk.R;

/**
 * Activity to demonstrate flip without library
 *
 * @author dilipkumar4813
 * @version 1.0
 * @since 28/10/17
 */

public class FlipWIthoutLibActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        ButterKnife.bind(this);
    }
}
