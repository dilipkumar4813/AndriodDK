package iamdilipkumar.com.andrioddk.ui.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import app.num.numandroidpagecurleffect.PageCurlView;
import iamdilipkumar.com.andrioddk.R;

public class FlipPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_page);

        PageCurlView pageCurlView = (PageCurlView) findViewById(R.id.pagecurl_view);

        List<Integer> pages_id = new ArrayList<>();
        pages_id.add(R.drawable.star_wars_3);
        pages_id.add(R.drawable.star_wars_2);

        pageCurlView.setCurlView(pages_id);
        pageCurlView.setCurlSpeed(65);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragment);
        fragmentTransaction.commit();
    }
}
