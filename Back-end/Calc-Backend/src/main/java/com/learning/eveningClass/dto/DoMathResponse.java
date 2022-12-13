package com.learning.eveningClass.dto;

public class DoMathResponse {


    private double result;


    public DoMathResponse() {
        // default constructor
    }

    public DoMathResponse( double result) {
        this.result = result;

    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
