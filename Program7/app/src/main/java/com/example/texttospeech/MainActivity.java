package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText textSpeak;
    Button buttonSpeak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSpeak = (Button)findViewById(R.id.btn);
        buttonSpeak.setOnClickListener(this::onClick);
        
        textSpeak = (EditText)findViewById(R.id.txt);
        textToSpeech = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                {
                    Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_LONG).show();
                }
            }
        });
        textToSpeech.setLanguage(Locale.US);
    }

    public void onClick(View v)
    {
        String text = textSpeak.getText().toString();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        Toast.makeText(getBaseContext(), text, Toast.LENGTH_LONG).show();
    }
}