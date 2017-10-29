package iamdilipkumar.com.andrioddk.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import iamdilipkumar.com.andrioddk.R;

public class OptionsActivity extends AppCompatActivity {

    @OnClick(R.id.btn_page_flip_library)
    void onPageFlipLibraryClicked() {
        startActivity(new Intent(this, FlipPageActivity.class));
    }

    @OnClick(R.id.btn_page_flip_without_library)
    void onPageFlipWithoutLibraryClicked() {
        startActivity(new Intent(this, FlipWIthoutLibActivity.class));
    }

    @OnClick(R.id.btn_expand_collapse)
    void onExpandCollapseClicked() {
        startActivity(new Intent(this, ExpandCollapseActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        ButterKnife.bind(this);
    }
}
