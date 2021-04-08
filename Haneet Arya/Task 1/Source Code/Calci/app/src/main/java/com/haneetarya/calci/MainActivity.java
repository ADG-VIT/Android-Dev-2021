package com.haneetarya.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button one,two,three,four,five,six,seven,eight,nine,add,sub,mul,div,clear,eql,zero;
    float r1=0, r2=0,sum=0;
    boolean ad;
    boolean minus;
    boolean pro;
    boolean divi;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show=findViewById(R.id.show);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        eql = findViewById(R.id.eql);
        clear = findViewById(R.id.clear);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(show.getText() + "0");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText().toString().isEmpty()){
                    show.setText("");

                }

                else{
                    if(r2!=0) {
                        equal();
                        r1 = Float.parseFloat(show.getText() + "");
                        ad=true;
                    }
                    else{
                        r1 = Float.parseFloat(show.getText() + "");
                        ad=true;
                        r2=1;
                    }
                    show.setText(null);

                }

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText().toString().isEmpty()){
                    show.setText("");

                }

                else{
                    if(r2!=0) {
                        equal();
                        r1 = Float.parseFloat(show.getText() + "");
                        pro=true;
                    }
                    else{
                        r1 = Float.parseFloat(show.getText() + "");
                        pro=true;
                        r2=1;
                    }
                    show.setText(null);

                }

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText().toString().isEmpty()){
                    show.setText("");

                }

                else{
                    if(r2!=0) {
                        equal();
                        r1 = Float.parseFloat(show.getText() + "");
                        minus=true;
                    }
                    else{
                        r1 = Float.parseFloat(show.getText() + "");
                        minus=true;
                        r2=1;
                    }
                    show.setText(null);

                }

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText().toString().isEmpty()){
                    show.setText("");

                }

                else{
                    if(r2!=0) {
                        equal();
                        r1 = Float.parseFloat(show.getText() + "");
                        divi=true;
                    }
                    else{
                        r1 = Float.parseFloat(show.getText() + "");
                        divi=true;
                        r2=1;
                    }
                    show.setText(null);

                }

            }
        });
        eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText().toString().isEmpty()){

                    show.setText("");
                }
                else{

                    if(sum==0){
                        r2 = Float.parseFloat(show.getText() + "");
                        if(ad==true){
                            sum = r1+r2;
                            show.setText(sum + "");
                        }
                        if(minus == true){
                            sum = r1-r2;
                            show.setText(sum + "");
                        }
                        if(divi == true){
                            sum = r1/r2;
                            show.setText(sum + "");
                        }
                        if(pro==true){
                            sum = r1*r2;
                            show.setText(sum + "");
                        }

                    }
                    else{
                        r1=Float.parseFloat(show.getText() + "");
                        if(ad==true){
                            sum = sum+r1;
                            show.setText(sum + "");
                        }
                        if(minus == true){
                            sum = sum-r1;
                            show.setText(sum + "");
                        }
                        if(divi == true){
                            sum = sum/r1;
                            show.setText(sum + "");
                        }
                        if(pro==true){
                            sum = r1*sum;
                            show.setText(sum + "");
                        }
                    }


                    ad=false;
                    minus = false;
                    divi = false;
                    pro=false;

                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                show.setText(null);
                r1=0;
                r2=0;
                sum=0;
            }
        });


        

    }
    public void equal(){
        if(sum==0){
            r2 = Float.parseFloat(show.getText() + "");
            if(ad==true){
                sum = r1+r2;
                show.setText(sum + "");
            }
            if(minus == true){
                sum = r1-r2;
                show.setText(sum + "");
            }
            if(divi == true){
                sum = r1/r2;
                show.setText(sum + "");
            }
            if(pro==true){
                sum = r1*r2;
                show.setText(sum + "");
            }

        }
        else{
            r1=Float.parseFloat(show.getText() + "");
            if(ad==true){
                sum = sum+r1;
                show.setText(sum + "");
            }
            if(minus == true){
                sum = sum-r1;
                show.setText(sum + "");
            }
            if(divi == true){
                sum = sum/r1;
                show.setText(sum + "");
            }
            if(pro==true){
                sum = r1*sum;
                show.setText(sum + "");
            }
        }


        ad=false;
        minus = false;
        divi = false;
        pro=false;
    }

}