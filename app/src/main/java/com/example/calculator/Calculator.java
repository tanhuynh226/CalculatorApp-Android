package com.example.calculator;

import android.widget.TextView;
import java.text.DecimalFormat;

public class Calculator {
    // Instance Variables
    private double lastNum;
    private double result;
    private int operator;

    // Format result into decimal form without trailing zeroes
    DecimalFormat df = new DecimalFormat("0.#######");

    // Constructor
    public Calculator(){
        result = 0;
        lastNum = 0;
        operator = 0;
    }

    // Set new value as lastNum (useful for storing previous result)
    public void setLastNum(double num){
        lastNum = num;
    }

    // Operator setter function
    public void setOperator(int op){
        operator = op;
    }

    // Operator getter function
    public int getOperator(){
        return operator;
    }

    // Resets instance variables
    public void clear(){
        result = 0;
        lastNum = 0;
        operator = 0;
    }

    // Addition
    public void add(double currStr){
        result = lastNum + currStr;
        lastNum = result;
    }

    // Subtraction
    public void subtract(double currStr){
        result = lastNum - currStr;
        lastNum = result;
    }

    // Multiplication
    public void multiply(double currStr){
        result = lastNum * currStr;
        lastNum = result;
    }

    // Division
    public void divide(double currStr){
        result = lastNum / currStr;
        lastNum = result;
    }

    // Plus/Minus
    public void plusMinus(String currStr){
        if (currStr.contains("-"))
            currStr = currStr.substring(1);
        else if (!currStr.equals("0"))
            currStr = "-" + currStr;
        result = Double.parseDouble(currStr);
        lastNum = result;
    }

    // Squaring
    public void square(double currStr){
        result = Math.pow(currStr, 2);
        lastNum = result;
    }

    // Exponentiation
    public void power(double currStr){
        result = Math.pow(lastNum, currStr);
        lastNum = result;
    }

    // Square root
    public void root(double currStr){
        result = Math.sqrt(currStr);
        lastNum = result;
    }

    // ln
    public void naturalLog(double currStr){
        result = Math.log(currStr);
        lastNum = result;
    }

    // Convert to percent
    public void percent(double currStr){
        result = currStr / 100;
        lastNum = result;
    }

    // Return result
    public String getResult(){
        return df.format(result);
    }
}
