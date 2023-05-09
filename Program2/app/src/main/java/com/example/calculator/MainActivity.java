package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button but_add, but_sub, but_mul, but_div;
    EditText txt_num1, txt_num2;
    TextView txt_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_num1 = (EditText) findViewById(R.id.NUM1);
        txt_num2 = (EditText) findViewById(R.id.NUM2);
        txt_res = (TextView) findViewById(R.id.TV);

        but_add = (Button) findViewById(R.id.ADD);
        but_sub = (Button) findViewById(R.id.SUB);
        but_mul = (Button) findViewById(R.id.MUL);
        but_div = (Button) findViewById(R.id.DIV);

        but_add.setOnClickListener(this);
        but_sub.setOnClickListener(this);
        but_mul.setOnClickListener(this);
        but_div.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double op1 = Double.parseDouble(txt_num1.getText().toString());
        double op2 = Double.parseDouble(txt_num2.getText().toString());
        double res;

        if(v.equals(but_add))
            res = op1+op2;
        else if (v.equals(but_sub))
            res = op1-op2;
        else if (v.equals(but_mul))
            res = op1*op2;
        else if (v.equals(but_div))
            if (op2!=0)
                res = op1/op2;
            else
                res = Double.POSITIVE_INFINITY;
        else
            res = 0;

        txt_res.setText(String.valueOf(res));
    }
}