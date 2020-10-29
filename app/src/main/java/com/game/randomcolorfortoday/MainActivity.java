package com.game.randomcolorfortoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout root;
    Random rnd = new Random();
    Button play;
    Button restart;
    Button cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        play = findViewById(R.id.play);
        restart = findViewById(R.id.restart);
        cross = findViewById(R.id.cross);
        root = findViewById(R.id.root);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeColor();
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartColor(view);
            }
        });

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crossExit();
            }
        });

    }

    public void takeColor() {
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        root.setBackgroundColor(color);
    }

    public void restartColor(View view) {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    public void crossExit() {
        finish();
    }
}