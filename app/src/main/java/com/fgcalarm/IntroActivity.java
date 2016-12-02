package com.fgcalarm;

import android.*;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro2 {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        Fragment instantiate1 = slide1.newInstance("", "");
        Fragment instantiate2 = slide2.newInstance("", "");
        Fragment instantiate3 = slide3.newInstance("", "");
        Fragment instantiate4 = slide4.newInstance("", "");
        Fragment instantiate5 = slide5.newInstance("", "");
        addSlide(instantiate1);
        addSlide(instantiate2);
        addSlide(instantiate3);
        addSlide(instantiate4);
        addSlide(instantiate5);
        /*
        addSlide(firstFragment);
        addSlide(secondFragment);
        addSlide(thirdFragment);
        addSlide(fourthFragment);

         */

        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        //addSlide(AppIntroFragment.newInstance(title, description, image, backgroundColor));

        // OPTIONAL METHODS
        // Override bar/separator color.
        //addSlide(Slide1Fragment.newInstance("", ""));
        //addSlide(AppIntroFragment.newInstance("Benvinguts","a partir d'ara podrà gaudir del viatge",R.drawable.iconneg,getColor(R.color.colorFGCTar)));
        //addSlide(AppIntroFragment.newInstance("SegonaSlide","text2",R.drawable.r50,000000));

        //setSeparatorColor(Color.parseColor("#ffffff"));

        //setFadeAnimation();

        // Hide Skip/Done button.

        showSkipButton(false);


        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);
        ActivityCompat.requestPermissions(this,
                new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}