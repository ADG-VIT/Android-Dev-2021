package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnplus;
    Button btnminus,btnX,btndivide,btnpercent,btndel,btnAC,btnequals,btndot;
    TextView t1,t2;
    float Res1,Res2,Res;
    boolean Add,Sub,Mul,Div;
    static boolean isInteger(float N)
    {

        // Convert float value
        // of N to integer
        int X = (int)N;
        double temp2 = N - X;

        // If N is not equivalent
        // to any integer
        if (temp2 > 0)
        {
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        btn0=(Button)findViewById(R.id.button0);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);
        btn7=(Button)findViewById(R.id.button7);
        btn8=(Button)findViewById(R.id.button8);
        btn9=(Button)findViewById(R.id.button9);
        btnplus=(Button)findViewById(R.id.buttonplus);
        btnminus=(Button)findViewById(R.id.buttonminus);
        btnX=(Button)findViewById(R.id.buttonX);
        btndivide=(Button)findViewById(R.id.buttondivide);
        btnpercent=(Button)findViewById(R.id.buttonpercent);
        btndel=(Button)findViewById(R.id.buttondel);
        btnAC=(Button)findViewById(R.id.buttonAC);
        btnequals=(Button)findViewById(R.id.buttonequals);
        btndot=(Button)findViewById(R.id.buttondot);
        t1=(TextView)findViewById(R.id.textView2);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+"9");
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(t1.getText()+".");
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1.getText().length()==0){
                    t1.setText("");
                }
                else{
                    Res1=Float.parseFloat(t1.getText()+"");
                    Add=true;
                    t1.setText(null);
                }
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1.getText().length()==0){
                    t1.setText("");
                }
                else{
                    Res1=Float.parseFloat(t1.getText()+"");
                    Sub=true;
                    t1.setText(null);
                }
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1.getText().length()==0){
                    t1.setText("");
                }
                else{
                    Res1=Float.parseFloat(t1.getText()+"");
                    Mul=true;
                    t1.setText(null);
                }
            }
        });
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1.getText().length()==0){
                    t1.setText("");
                }
                else{
                    Res1=Float.parseFloat(t1.getText()+"");
                    Div=true;
                    t1.setText(null);
                }
            }
        });
        btnpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1.getText().length()==0){
                    t1.setText("");
                }
                else{
                    Res1=Float.parseFloat(t1.getText()+"");
                    Res=Res1/100;
                    t1.setText(Res+"");
                }
            }
        });
        btnequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1.getText().length()==0){
                    t1.setText("");
                }
                else{
                    Res2=Float.parseFloat(t1.getText()+"");
                    if(Add==true) {
                        Res=Res1 + Res2;
                        if(isInteger(Res))
                        {
                            t1.setText((int)Res + "");
                        }
                        else {
                            t1.setText(Res + "");
                        }
                        Add=false;
                    }
                    else if(Sub==true) {
                        Res=Res1 - Res2;
                        if(isInteger(Res))
                        {
                            t1.setText((int)Res + "");
                        }
                        else {
                            t1.setText(Res + "");
                        }
                        Sub=false;
                    }
                    else if(Mul==true) {
                        Res=Res1 * Res2;
                        if(isInteger(Res))
                        {
                            t1.setText((int)Res + "");
                        }
                        else {
                            t1.setText(Res + "");
                        }
                        Mul=false;
                    }
                    else if(Div==true) {
                        Res=Res1 / Res2;
                        if(isInteger(Res))
                        {
                            t1.setText((int)Res + "");
                        }
                        else {
                            t1.setText(Res + "");
                        }
                        Div=false;
                    }
                }
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t1.setText("");
            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(t1.getText().length()==0){
                    t1.setText("");
                }
                else {
                    String s = (String) t1.getText();
                    t1.setText(s.substring(0, s.length() - 1));
                }
            }
        });
    }
}