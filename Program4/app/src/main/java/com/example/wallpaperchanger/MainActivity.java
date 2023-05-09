package com.example.wallpaperchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button wallpaper;
    Timer mytimer;
    int interval=30000;
    Drawable drawable;
    WallpaperManager wpm;
    int prev=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytimer=new Timer();
        wpm=WallpaperManager.getInstance(this);

        wallpaper = (Button)findViewById(R.id.button);
        wallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_wallpaper();
            }
        });

    }

    private void set_wallpaper()
    {
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {

                if(prev==1){
                    drawable = getResources().getDrawable(R.drawable.two);
                    prev=2;
                }
                else if(prev==2){
                    drawable = getResources().getDrawable(R.drawable.three);
                    prev=3;
                }
                else{
                    drawable = getResources().getDrawable(R.drawable.one);
                    prev=1;
                }


                Bitmap wallpaper=((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(wallpaper);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        },0, interval);
    }
}