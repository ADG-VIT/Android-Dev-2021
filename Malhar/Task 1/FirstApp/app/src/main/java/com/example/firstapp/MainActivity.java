package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button zero, one, two, three, four, five, six, seven, eight, nine, add, sub, mul, div, ac, eql;

    float v1 = 0 , v2 = 0, sum = 0;
    boolean plus;
    boolean minus;
    boolean multiply;
    boolean divide;
    TextView disp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disp = findViewById(R.id.disp);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        ac = findViewById(R.id.ac);
        eql = findViewById(R.id.eql);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disp.setText(disp.getText() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(disp.getText().toString().isEmpty())
                    disp.setText("");
                else{
                    if(v2 != 0)
                    {
                        equal();
                        v1 = Float.parseFloat(disp.getText() + "");
                        plus = true;
                    }
                    else
                    {
                        v1 = Float.parseFloat(show.getText() + "");
                        plus = true;
                        v2 = 1;
                    }
                    disp.setText(null);
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(disp.getText().toString().isEmpty())
                    disp.setText("");
                else{
                    if(v2 != 0)
                    {
                        equal();
                        v1 = Float.parseFloat(disp.getText() + "");
                        minus = true;
                    }
                    else
                    {
                        v1 = Float.parseFloat(show.getText() + "");
                        minus = true;
                        v2 = 1;
                    }
                    disp.setText(null);
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(disp.getText().toString().isEmpty())
                    disp.setText("");
                else{
                    if(v2 != 0)
                    {
                        equal();
                        v1 = Float.parseFloat(disp.getText() + "");
                        divide = true;
                    }
                    else
                    {
                        v1 = Float.parseFloat(show.getText() + "");
                        divide = true;
                        v2 = 1;
                    }
                    disp.setText(null);
                }disp.setText(disp.getText() + "/");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(disp.getText().toString().isEmpty())
                    disp.setText("");
                else{
                    if(v2 != 0)
                    {
                        equal();
                        v1 = Float.parseFloat(disp.getText() + "");
                        multiply = true;
                    }
                    else
                    {
                        v1 = Float.parseFloat(show.getText() + "");
                        multiply = true;
                        v2 = 1;
                    }
                    disp.setText(null);
                }
            }
        });

        eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(disp.getText().toString().isEmpty()){

                    disp.setText("");
                }
                else{

                    if(sum==0){
                        v2 = Float.parseFloat(disp.getText() + "");
                        if(plus==true){
                            sum = v1 + v2;
                            disp.setText(sum + "");
                        }
                        if(minus == true){
                            sum = v - v2;
                            disp.setText(sum + "");
                        }
                        if(divide == true){
                            sum = v1 / v2;
                            disp.setText(sum + "");
                        }
                        if(multiply == true){
                            sum = v1 * v2;
                            disp.setText(sum + "");
                        }

                    }
                    else{
                        v1=Float.parseFloat(disp.getText() + "");
                        if(plus == true){
                            sum = sum+v1;
                            disp.setText(sum + "");
                        }
                        if(minus == true){
                            sum = sum - v1;
                            disp.setText(sum + "");
                        }
                        if(divide == true){
                            sum = sum / v1;
                            disp.setText(sum + "");
                        }
                        if(multiply == true){
                            sum = v1 * sum;
                            disp.setText(sum + "");
                        }
                    }


                    plus = false;
                    minus = false;
                    divide = false;
                    multiply = false;

                }
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disp.setText(null);
                v1 = 0;
                v2 = 0;
                sum = 0;
            }
        });
    }

    public void equal(){
        if(sum==0){
            v2 = Float.parseFloat(disp.getText() + "");
            if(plus == true){
                sum = v1 + v2;
                disp.setText(sum + "");
            }
            if(minus == true){
                sum = v1 - v2;
                disp.setText(sum + "");
            }
            if(divide == true){
                sum = v1 / v2;
                disp.setText(sum + "");
            }
            if(multiply == true){
                sum = v1 * v2;
                disp.setText(sum + "");
            }

        }
        else{
            v1 = Float.parseFloat(disp.getText() + "");
            if(plus == true){
                sum = sum + v1;
                disp.setText(sum + "");
            }
            if(minus == true){
                sum = sum - v1;
                disp.setText(sum + "");
            }
            if(divide == true){
                sum = sum / v1;
                disp.setText(sum + "");
            }
            if(multiply == true){
                sum = v1 * sum;
                disp.setText(sum + "");
            }
        }


        plus = false;
        minus = false;
        divide = false;
        multiply = false;
    }
}