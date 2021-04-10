package com.example.calculator_dup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Stack;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


class InfixEvaluation {
    public int evaluate(String expression) {
//Stack for Numbers
        Stack<Integer> numbers = new Stack<>();
//Stack for operators
        Stack<Character> operations = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
//check if it is number
            if (Character.isDigit(c)) {
//Entry is Digit, it could be greater than one digit number
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < expression.length())
                        c = expression.charAt(i);
                    else
                        break;
                }
                i--;
//push it into stack
                numbers.push(num);
            } else if (c == '(') {
//push it to operators stack
                operations.push(c);
            }
//Closed brace, evaluate the entire brace
            else if (c == ')') {
                while (operations.peek() != '(') {
                    int output = performOperation(numbers, operations);
//push it back to stack
                    numbers.push(output);
                }
                operations.pop();
            }
// current character is operator
            else if (isOperator(c)) {
//1. If current operator has higher precedence than operator on top of the stack,
//the current operator can be placed in stack
// 2. else keep popping operator from stack and perform the operation in numbers stack till
//either stack is not empty or current operator has higher precedence than operator on top of the stack
                while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
                    int output = performOperation(numbers, operations);
//push it back to stack
                    numbers.push(output);
                }
//now push the current operator to stack
                operations.push(c);
            }
        }
//If here means entire expression has been processed,
//Perform the remaining operations in stack to the numbers stack
        while (!operations.isEmpty()) {
            int output = performOperation(numbers, operations);
//push it back to stack
            numbers.push(output);
        }
        return numbers.pop();
    }

    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public int performOperation(Stack<Integer> numbers, Stack<Character> operations) {
        int a = numbers.pop();
        int b = numbers.pop();
        char operation = operations.pop();
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return b / a;
        }
        return 0;
    }

    public boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
    }
}

public class MainActivity extends AppCompatActivity {


    private EditText display;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
    }
    private void updateText(String stringToAdd){
        String oldstr = display.getText().toString();
        int cursorpos = display.getSelectionStart();
        String leftstr = oldstr.substring(0, cursorpos);
        String rightstr = oldstr.substring(cursorpos);
        display.setText(String.format("%s%s%s", leftstr, stringToAdd, rightstr));
        display.setSelection(cursorpos+1);

    }
    public void zeroB(View view){
        updateText("0");
    }
    public void oneB(View view){
        updateText("1");
    }
    public void twoB(View view){
        updateText("2");
    }
    public void threeB(View view){
        updateText("3");
    }
    public void fourB(View view){
        updateText("4");
    }
    public void fiveB(View view){
        updateText("5");
    }
    public void sixB(View view){
        updateText("6");
    }
    public void sevenB(View view){
        updateText("7");
    }
    public void eightB(View view){
        updateText("8");
    }
    public void nineB(View view){
        updateText("9");
    }
    public void B(View view){
        updateText("0");
    }
    public void plusminusB(View view){
        updateText("-");
    }
    public void plusB(View view){
        updateText("+");
    }
    public void minusB(View view){
        updateText("-");
    }
    public void multiplyB(View view){
        updateText("×");
    }
    public void divideB(View view){
        updateText("÷");
    }
    public void bracketsB(View view){
        int cursorPos = display.getSelectionStart();
        int openPar =0;
        int closedPar = 0;
        int textlen = display.getText().length();
        for(int i=0;i<cursorPos;i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openPar+=1;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")){
                closedPar+=1;
            }
        }
        if (openPar == closedPar || display.getText().toString().substring(textlen-1,textlen).equals("(")){
            updateText("(");
            display.setSelection(cursorPos+1);
        }
        else if (closedPar < openPar && !display.getText().toString().substring(textlen-1,textlen).equals("(")){
            updateText(")");
            display.setSelection(cursorPos+1);
        }
    }

    public void clearB(View view){

        int cursorpos = display.getSelectionStart();
        int textlen = display.getText().length();
        if(cursorpos!=0 && textlen!=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorpos-1,cursorpos,"");
            display.setText(selection);
            display.setSelection(cursorpos-1);
        }


    }
    public void cleareverythingB(View view){
        display.setText("");
    }
    public void equalsB(View view){
        String result = display.getText().toString();
        result = result.replace("×","*");
        result = result.replace("÷","/");
        InfixEvaluation i = new InfixEvaluation();
        try {
            int text = i.evaluate(result);
            display.setText(Integer.toString(text));

            int count = 0;
            while (text != 0) {
                text /= 10;
                ++count;
            }
            display.setSelection(count);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Error :/ ughhh Somethings missing.",Toast.LENGTH_SHORT).show();
        }



    }
    public void dotB(View view){
        updateText(".");
    }

}