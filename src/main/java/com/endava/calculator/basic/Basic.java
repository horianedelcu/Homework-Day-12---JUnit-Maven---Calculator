package com.endava.calculator.basic;

public class Basic implements BasicOperations {

    protected int numberOfDecimals;

    public Basic (){
        numberOfDecimals = 10;
    }

    public Basic(int numberOfDecimals){
        this.numberOfDecimals = numberOfDecimals;
    }
    @Override
    public long add(int... no) {
        long sum = 0;
        for(int n : no) {
            sum = sum + n;
        }
        return sum;
    }

    @Override
    public long add(long... no) {
        long sum = 0;
        for(long n : no) {
            sum = sum + n;
        }
        return sum;
    }

    @Override
    public double add(double... no) {
        double sum = 0;
        for(double n : no) {
            sum = sum + n;
        }
        return formatNumber(sum);
    }

    @Override
    public int substract(int... no) {
        int dif = no[0];
        for(int i = 1; i<no.length; i++) {
            dif = dif - no[i];
        }
        return dif;
    }

    @Override
    public long substract(long... no) {
        long dif = no[0];
        for(int i = 1; i<no.length; i++) {
            dif = dif - no[i];
        }
        return dif;
    }

    @Override
    public double substract(double... no) {
        double dif = no[0];
        for(int i = 1; i<no.length; i++) {
            dif = dif - no[i];
        }
        return formatNumber(dif);
    }

    @Override
    public long multiply(int... no) {
        long result = 1;
        for(long n:no){
            result = result*n;
        }
        return result;
    }

    @Override
    public long multiply(long... no) {
        long result = 1;
        for(long n:no){
            result = result*n;
        }
        return result;
    }

    @Override
    public double multiply(double... no) {
        double result = 1;
        for(double n:no){
            result = result*n;
        }
        return formatNumber(result);
    }

    @Override
    public double divide(int... no) {
        double result = no[0];
        for(int i = 1; i<no.length; i++) {
             result = result / no[i];
        }
        return formatNumber(result);
    }

    @Override
    public double divide(long... no) {
        double result = no[0];
        for(int i = 1; i<no.length; i++) {
            result = result / no[i];
        }

        return formatNumber(result);
    }

    @Override
    public double divide(double... no) {
        double result = no[0];
        for(int i = 1; i<no.length; i++) {
            result = result / no[i];
        }
        return formatNumber(result);
    }

    protected double formatNumber(double n){
        String s = String.format("%." + numberOfDecimals + "f", n);
        return Double.parseDouble(s);
    }
}
