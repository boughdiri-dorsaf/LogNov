package com.ds.novlag.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ds.novlag.R;
import com.ds.novlag.global.Constant;

public class SplachActivity extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    TextView txtAppName, txtAppDesc;
    ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splach);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        txtAppName = findViewById(R.id.txt_nom_app);
        txtAppDesc = findViewById(R.id.txt_desc_app);
        imgLogo = findViewById(R.id.img_logo);

        imgLogo.setAnimation(topAnim);
        txtAppName.setAnimation(bottomAnim);
        txtAppDesc.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openNextScreen();
            }
        }, Constant.Splash_Screen
        );
    }

    private void openNextScreen(){
        SharedPreferences sharedPref = getSharedPreferences(Constant.MY_PREF, Context.MODE_PRIVATE);
        if (sharedPref.contains(Constant.PREF_IS_CONNECT)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}