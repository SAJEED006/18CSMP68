package com.example.phonedialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button one, two, three, four, five, six, seven, eight, nine, zero, call, save, delete, star, hash;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button)findViewById(R.id.btn_one);
        one.setOnClickListener(this);

        two = (Button)findViewById(R.id.btn_two);
        two.setOnClickListener(this);

        three = (Button)findViewById(R.id.btn_three);
        three.setOnClickListener(this);

        four = (Button)findViewById(R.id.btn_four);
        four.setOnClickListener(this);

        five = (Button)findViewById(R.id.btn_five);
        five.setOnClickListener(this);

        six = (Button)findViewById(R.id.btn_six);
        six.setOnClickListener(this);

        seven = (Button)findViewById(R.id.btn_seven);
        seven.setOnClickListener(this);

        eight = (Button)findViewById(R.id.btn_eight);
        eight.setOnClickListener(this);

        nine = (Button)findViewById(R.id.btn_nine);
        nine.setOnClickListener(this);

        zero = (Button)findViewById(R.id.btn_zero);
        zero.setOnClickListener(this);

        call = (Button)findViewById(R.id.btn_call);
        call.setOnClickListener(this);

        save = (Button)findViewById(R.id.btn_save);
        save.setOnClickListener(this);

        delete = (Button)findViewById(R.id.btn_del);
        delete.setOnClickListener(this);

        star = (Button)findViewById(R.id.btn_star);
        star.setOnClickListener(this);

        hash = (Button)findViewById(R.id.btn_hash);
        hash.setOnClickListener(this);

        phoneNumber = (EditText)findViewById(R.id.txt_phonenumber);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(one))
        {
            phoneNumber.append("1");
        }
        else if(v.equals(two))
        {
            phoneNumber.append("2");
        }
        else if(v.equals(three))
        {
            phoneNumber.append("3");
        }
        else if(v.equals(four))
        {
            phoneNumber.append("4");
        }
        else if(v.equals(five))
        {
            phoneNumber.append("5");
        }
        else if(v.equals(six))
        {
            phoneNumber.append("6");
        }
        else if(v.equals(seven))
        {
            phoneNumber.append("7");
        }
        else if(v.equals(eight))
        {
            phoneNumber.append("8");
        }
        else if(v.equals(nine))
        {
            phoneNumber.append("9");
        }
        else if(v.equals(zero))
        {
            phoneNumber.append("0");
        }
        else if(v.equals(star))
        {
            phoneNumber.append("*");
        }
        else if(v.equals(hash))
        {
            phoneNumber.append("#");
        }
        else if(v.equals(delete))
        {
            String data = phoneNumber.getText().toString();
            if(data.length()>0)
            {
                phoneNumber.setText(data.substring(0,data.length()-1));
            }
            else
            {
                phoneNumber.setText("");
            }
        }
        else if(v.equals(save))
        {
            Intent contactIntent= new Intent(ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,"");
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber.getText().toString());
            startActivity(contactIntent);
        }
        else if(v.equals(call))
        {
            String data = phoneNumber.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+ data));
            startActivity(intent);
        }
    }
}