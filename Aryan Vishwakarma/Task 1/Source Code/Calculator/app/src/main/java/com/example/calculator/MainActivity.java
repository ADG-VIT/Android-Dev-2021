package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.calculator.R.id.input;
import static com.example.calculator.R.id.up;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private TextView ans;
    private String answ="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setCursorVisible(true);
        ans=findViewById(R.id.answer);
    }

    private void updateText(String str){
        String oldstr = display.getText().toString();
        int curPos= display.getSelectionStart();
        String leftstr=oldstr.substring(0,curPos);
        String rghtstr=oldstr.substring(curPos);
        display.setText(String.format("%s%s%s",leftstr,str,rghtstr));
        display.setSelection(curPos+1);
    }
    public void  zerobtn(View view){
        updateText("0");
    }
    public void onebtn(View view){
        updateText("1");
    }
    public void twobtn(View view){
        updateText("2");
    }
    public void threebtn(View view){
        updateText("3");
    }
    public void fourbtn(View view){
        updateText("4");
    }
    public void fivebtn(View view){
        updateText("5");
    }
    public void sixbtn(View view){
        updateText("6");
    }
    public void sevenbtn(View view){
        updateText("7");
    }
    public void eightbtn(View view){
        updateText("8");
    }
    public void ninebtn(View view){
        updateText("9");
    }
    public void pointbtn(View view){
        updateText(".");
    }
    public void plusbtn(View view){
        updateText("+");
    }
    public void minusbtn(View view){
        updateText("-");
    }
    public void multiplybtn(View view){
        updateText("×");
    }
    public void dividebtn(View view){
        updateText("/");
    }
    public void braces(View view){
        updateText("()");
    }
    public void Cbtn(View view){
        int l=display.getText().toString().length();
        if(l==0)
            ans.setText("");
        else
            display.setText("");
    }
    public void left(View view){
        int curPos=display.getSelectionStart();
        if(curPos>0)
            display.setSelection(curPos-1);
    }
    public void right(View view){
        int curPos=display.getSelectionStart();
        int l= display.getText().length();
        if(curPos<l)
            display.setSelection(curPos+1);
    }
    public void backspacebtn(View view){
        int curPos=display.getSelectionStart();
        int len=display.getText().length();
        if(curPos!=0&&len!=0){
            SpannableStringBuilder selection= (SpannableStringBuilder) display.getText();
            selection.replace(curPos-1,curPos,"");
            display.setText(selection);
            display.setSelection(curPos-1);
        }
    }
    public void ansbtn(View view){
        String dis=display.getText().toString();
        int disL=dis.length();
        if(disL>0) {
            char last = dis.charAt(disL - 1);
            if (Character.isDigit(last))
                updateText("×");
        }
        updateText("(");
        updateText(answ);
        int curPos = display.getSelectionStart();
        display.setSelection(curPos + answ.length() - 1);
        updateText(")");
    }
    public void equalbtn(View view){
        String exp=display.getText().toString();
        exp=exp.replaceAll("×","*");
        Expression ex=new Expression(exp);
        String result = String.valueOf(ex.calculate());
        int l=result.length();
        if(result.substring(l-2).equals(".0"))
            ans.setText(result.substring(0,l-2));
        else
            ans.setText(result);
        answ=ans.getText().toString();
    }
}