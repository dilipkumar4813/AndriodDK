package iamdilipkumar.com.andrioddk.ui.activities;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import iamdilipkumar.com.andrioddk.R;
import iamdilipkumar.com.andrioddk.ui.fragments.FirstFragment;
import iamdilipkumar.com.andrioddk.ui.fragments.FourthFragment;
import iamdilipkumar.com.andrioddk.ui.fragments.SecondFragment;
import iamdilipkumar.com.andrioddk.ui.fragments.ThirdFragment;

/**
 * Activity to demonstrate flip without library
 *
 * @author dilipkumar4813
 * @version 1.0
 * @since 28/10/17
 */

public class FlipWIthoutLibActivity extends AppCompatActivity {

    private float x1;

    private AnimatorSet frontCardAnimation = null;
    private AnimatorSet backCardAnimation = null;
    private int c = 0;

    @BindView(R.id.first_container)
    FrameLayout firstContainer;

    @BindView(R.id.second_container)
    FrameLayout secondContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_without_lib);
        ButterKnife.bind(this);

        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.hide();
        }
        setupUI();
    }

    private void setupUI() {

        setupFragments();

        AnimatorSet flipCardRightIn = (AnimatorSet) AnimatorInflater
                .loadAnimator(this, R.animator.card_flip_right_in);
        AnimatorSet flipCardRightOut = (AnimatorSet) AnimatorInflater
                .loadAnimator(this, R.animator.card_flip_right_out);

        flipCardRightIn.setTarget(secondContainer);
        flipCardRightOut.setTarget(firstContainer);

        frontCardAnimation = new AnimatorSet();
        frontCardAnimation.playTogether(flipCardRightIn, flipCardRightOut);

        AnimatorSet flipCardLeftIn = (AnimatorSet) AnimatorInflater
                .loadAnimator(this, R.animator.card_flip_left_in);
        AnimatorSet flipCardLeftOut = (AnimatorSet) AnimatorInflater
                .loadAnimator(this, R.animator.card_flip_left_out);

        flipCardLeftIn.setTarget(firstContainer);
        flipCardLeftOut.setTarget(secondContainer);

        backCardAnimation = new AnimatorSet();
        backCardAnimation.playTogether(flipCardLeftIn, flipCardLeftOut);
    }

    private void loadFlipAnimationForFrontCard() {
        if (frontCardAnimation == null) {
            return;
        }

        Display display = this.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        ObjectAnimator animX = ObjectAnimator.ofFloat(firstContainer, "x", size.x);

        animX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                firstContainer.setVisibility(View.GONE);
                secondContainer.setVisibility(View.VISIBLE);
                // changeFragment(c);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        frontCardAnimation.play(animX);
        frontCardAnimation.start();
    }

    /**
     * Try to display back of card.
     */
    private void loadFlipAnimationForBackCard() {
        if (backCardAnimation == null) {
            return;
        }

        ObjectAnimator animX = ObjectAnimator.ofFloat(firstContainer, "x", 0f);

        animX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                firstContainer.setVisibility(View.VISIBLE);
                secondContainer.setVisibility(View.GONE);
                //changeFragment(c);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        backCardAnimation.play(animX);
        backCardAnimation.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float x2 = event.getX();
                if (x1 > x2) { // Show first, right swipe
                    if (c != 3) {
                        c++;
                        Log.d("count", "" + c);
                    }
                    loadFlipAnimationForBackCard();
                } else if (x2 > x1) { // Show next, left swipe
                    if (c != 0) {
                        c--;
                        Log.d("count", "" + c);
                    }
                    loadFlipAnimationForFrontCard();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private void setupFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.first_container, new FirstFragment());
        fragmentTransaction.replace(R.id.second_container, new SecondFragment());
        fragmentTransaction.commit();
    }

    private void changeFragment(int count) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        switch (count) {
            case 0:
                fragmentTransaction.replace(R.id.first_container, new FirstFragment());
                firstContainer.setVisibility(View.VISIBLE);
                secondContainer.setVisibility(View.GONE);
                break;
            case 1:
                fragmentTransaction.replace(R.id.first_container, new SecondFragment());
                firstContainer.setVisibility(View.VISIBLE);
                secondContainer.setVisibility(View.GONE);
                break;
            case 2:
                fragmentTransaction.replace(R.id.second_container, new ThirdFragment());
                break;
            case 3:
                fragmentTransaction.replace(R.id.second_container, new FourthFragment());
                break;
        }
        fragmentTransaction.commit();
    }
}
