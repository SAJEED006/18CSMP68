package com.example.countervalue;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView time;
    Button start_button, stop_button;
    int count = 0;
    Boolean stop_loop;

    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = (TextView) findViewById(R.id.timer);

        start_button = (Button) findViewById(R.id.startbut);
        stop_button = (Button) findViewById(R.id.stopbut);
        start_button.setOnClickListener(this);
        stop_button.setOnClickListener(this);

        handler = new Handler(getApplicationContext().getMainLooper());
    }


    @Override
    public void onClick(View v) {
       switch (v.getId())
       {
           case R.id.startbut:
               stop_loop = true;
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       while (stop_loop)
                       {
                           try {
                               Thread.sleep(1000);
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                           handler.post(new Runnable() {
                               @Override
                               public void run() {
                                    time.setText(Integer.toString(count));
                                    count++;
                               }
                           });
                       }
                   }
               }).start();
               break;

           case R.id.stopbut:
               stop_loop = false;
               time.setText(null);
               count=0;
               break;
       }
    }
}