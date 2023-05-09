package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    String user, pass;
    Button loginsign;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.usr);
        password = (EditText) findViewById(R.id.psw);

        loginsign = (Button) findViewById(R.id.butsgnlog);
        loginsign.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        user = bundle.getString("username");
        pass = bundle.getString("password");
    }

    @Override
    public void onClick(View v) {

        String usr_name = username.getText().toString();
        String usr_password = password.getText().toString();

        if(v.equals(loginsign))
        {
            if((user.equals(usr_name)) && (pass.equals(usr_password)))
            {
                Toast.makeText(getBaseContext(), "Successful Login!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, Successfullogin.class);
                startActivity(intent);
            }
            else if (usr_name.equals("") || usr_password.equals(""))
            {
                Toast.makeText(getBaseContext(), "Please fill Username or Password!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                count += 1;
                if (count==1) {
                    Toast.makeText(getBaseContext(), "Last attempt remaining!!!", Toast.LENGTH_SHORT).show();
                }
                if(count==2)
                {
                    Toast.makeText(getBaseContext(), "Failed Login Attempts!", Toast.LENGTH_SHORT).show();
                    loginsign.setEnabled(false);
                }
            }
        }
    }
}

