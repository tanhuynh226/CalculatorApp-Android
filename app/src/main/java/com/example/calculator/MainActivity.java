package com.example.calculator;

import android.os.Build;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // Instance variables
    private TextView display;
    private String currStr;
    private int i = 0, j = 0;

    // Calculator object declaration
    Calculator calc = new Calculator();

    // On launch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
    }

    // Overwrites initial number zero with the first entry
    private void firstEntry(){
        if (i == 0){
            display.setText("");
            i++;
        }
    }

    // Appends to the TextView when user presses a number
    private void update(String newStr){
        String oldStr = display.getText().toString();
        currStr = oldStr + newStr;
        // Overflow error handling
        if (display.getText().toString().length() > 13){
            display.setText("ERROR: Overflow");
            return;
        }
        display.setText(currStr);
        if (j == 0)
            calc.setLastNum(Double.parseDouble(currStr)); // first input becomes the latest input stored in the calculator object
    }

    // Resets calculator
    public void clearButton(View view){
        display.setText("0");
        calc.clear();
        i = 0;
        j = 0;
    }

    // Addition function
    public void addButton(View view){
        calc.setOperator(1);
        if (j > 0) {
            calc.add(Double.parseDouble(currStr));
            display.setText(calc.getResult());
            calc.setLastNum(Double.parseDouble(calc.getResult()));
        }
        i = 0;              // i = 0 resets TextView to allow user to write over it
        j++;
    }

    // Subtraction function
    public void subtractButton(View view){
        calc.setOperator(2);
        if (j > 0) {
            calc.subtract(Double.parseDouble(currStr));
            display.setText(calc.getResult());
            calc.setLastNum(Double.parseDouble(calc.getResult()));
        }
        i = 0;
        j++;
    }

    // Multiplication function
    public void multiplyButton(View view){
        calc.setOperator(3);
        if (j > 0) {
            calc.multiply(Double.parseDouble(currStr));
            display.setText(calc.getResult());
            calc.setLastNum(Double.parseDouble(calc.getResult()));
        }
        i = 0;
        j++;
    }

    // Division function
    public void divideButton(View view){
        calc.setOperator(4);

        // Divide by zero error handling
        if (currStr.equals("0")) {
            display.setText("ERROR: Divide by Zero");
            return;
        }

        if (j > 0) {
            calc.divide(Double.parseDouble(currStr));
            display.setText(calc.getResult());
            calc.setLastNum(Double.parseDouble(calc.getResult()));
        }
        i = 0;
        j++;
    }

    // Equals Function
    public void equalsButton(View view){
        if (j > 0) {
            switch (calc.getOperator()) {
                case 1:
                    calc.add(Double.parseDouble(currStr));
                    break;
                case 2:
                    calc.subtract(Double.parseDouble(currStr));
                    break;
                case 3:
                    calc.multiply(Double.parseDouble(currStr));
                    break;
                case 4:
                    calc.divide(Double.parseDouble(currStr));
                    break;
                case 5:
                    calc.power(Double.parseDouble(currStr));
                    break;
            }
        }

        // Divide by zero error handling
        if (calc.getOperator() == 4 && currStr.equals("0")){
            display.setText("ERROR: Divide by Zero");
            return;
        }
        // Overflow error handling
        else if (display.getText().toString().length() > 13){
            display.setText("ERROR: Overflow");
            return;
        }
        // No operations performed on initial value
        else if (calc.getOperator() == 0)
            return;

        calc.setOperator(0);    // Pressing = again won't perform the operation again
        display.setText(calc.getResult());

        i = 0;
        j = 0;
    }

    // Plus/Minus function
    public void plusMinusButton(View view){
        currStr = display.getText().toString();
        calc.plusMinus(currStr);
        currStr = calc.getResult();
        display.setText(currStr);
    }

    // Square function
    public void squareButton(View view){
        currStr = display.getText().toString();
        calc.square(Double.parseDouble(currStr));
        currStr = calc.getResult();
        display.setText(currStr);
        i = 0;
        j = 0;
    }

    // Power function
    public void powerButton(View view){
        calc.setOperator(5);
        if (j > 0) {
            calc.power(Double.parseDouble(currStr));
            display.setText(calc.getResult());
            calc.setLastNum(Double.parseDouble(calc.getResult()));
        }
        i = 0;
        j++;
    }

    // Root function
    public void rootButton(View view){
        currStr = display.getText().toString();
        if (currStr.contains("-")) {
            display.setText("ERROR: Root of Negatives");
            return;
        }
        calc.root(Double.parseDouble(currStr));
        currStr = calc.getResult();
        display.setText(currStr);
        i = 0;
        j = 0;
    }

    // Natural log function
    public void naturalLogButton(View view){
        currStr = display.getText().toString();
        calc.naturalLog(Double.parseDouble(currStr));
        currStr = calc.getResult();
        display.setText(currStr);
        i = 0;
        j = 0;
    }

    // Convert to percent function
    public void percentButton(View view){
        currStr = display.getText().toString();
        calc.percent(Double.parseDouble(currStr));
        currStr = calc.getResult();
        display.setText(currStr);
        i = 0;
        j = 0;
    }

    // Append decimal
    public void pointButton(View view){
        firstEntry();
        update(".");
    }

    // Append numbers
    public void zeroButton(View view){
        firstEntry();
        update("0");
    }

    public void oneButton(View view){
        firstEntry();
        update("1");
    }

    public void twoButton(View view){
        firstEntry();
        update("2");
    }

    public void threeButton(View view){
        firstEntry();
        update("3");
    }

    public void fourButton(View view){
        firstEntry();
        update("4");
    }

    public void fiveButton(View view){
        firstEntry();
        update("5");
    }

    public void sixButton(View view){
        firstEntry();
        update("6");
    }

    public void sevenButton(View view){
        firstEntry();
        update("7");
    }

    public void eightButton(View view){
        firstEntry();
        update("8");
    }

    public void nineButton(View view){
        firstEntry();
        update("9");
    }
}