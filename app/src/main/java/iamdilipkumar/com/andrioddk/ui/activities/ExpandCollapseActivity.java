package iamdilipkumar.com.andrioddk.ui.activities;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import iamdilipkumar.com.andrioddk.R;
import iamdilipkumar.com.andrioddk.ui.fragments.FifthFragment;
import iamdilipkumar.com.andrioddk.ui.fragments.SecondFragment;

/**
 * Activity to demonstrate expand and collapse
 *
 * @author dilipkumar4813
 * @version 1.0
 * @since 29/10/17
 */

public class ExpandCollapseActivity extends AppCompatActivity {

    private boolean expanded = true;

    @BindView(R.id.expand_collapse)
    FrameLayout expandLayout;

    @BindView(R.id.fl_back)
    FrameLayout backFrame;

    @OnClick(R.id.btn_expand_collapse)
    void onExpandCollapse() {
        if (!expanded) {
            expanded = true;
            expand(expandLayout, 800, backFrame.getHeight());
        } else {
            expanded = false;
            collapse(expandLayout, 800, 0);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_collapse);
        ButterKnife.bind(this);

        setupFragments();
    }

    private void setupFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.expand_collapse, new SecondFragment());
        fragmentTransaction.replace(R.id.fl_back, new FifthFragment());
        fragmentTransaction.commit();
    }

    public void expand(final View v, int duration, int targetHeight) {

        int prevHeight = v.getHeight();

        v.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }

    public void collapse(final View v, int duration, int targetHeight) {
        int prevHeight = v.getHeight();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                v.getLayoutParams().height = (int) animation.getAnimatedValue();
                v.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }
}
