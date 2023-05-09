package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button loginsign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.usr);
        password = (EditText) findViewById(R.id.psw);

        loginsign = (Button) findViewById(R.id.butsgnlog);
        loginsign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usr_name = username.getText().toString();
        String usr_password = password.getText().toString();
        if(v.equals(loginsign))
        {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            Toast.makeText(getBaseContext(), "User Registered Successfully!", Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();
            bundle.putString("username", usr_name);
            bundle.putString("password", usr_password);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
