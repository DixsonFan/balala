package com.dixson.sharedparking;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dixson.sharedparking.sharedparking.testActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        View target = findViewById(R.id.iv_bg);
        //执行什么动画，propertyName动画名字,scaleX缩放
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(target,"scaleX",0.0f,1.0f);
        objectAnimator.setDuration(3000);
        objectAnimator.start();


        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(LauncherActivity.this,MainActivity.class));
                finish();
            }

        });

    }
}
