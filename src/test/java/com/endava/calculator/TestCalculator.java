package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;

public class TestCalculator {
    public static void main(String[] args) {

        BasicOperations b = new Basic(3);
        ExpertOperations e = new Expert(4);

//        System.out.println(b.add(2,3,4,5));
//        System.out.println(b.substract(2, -3));
//        System.out.println(b.multiply(2,6,2));
//        System.out.println(b.divide(1,2,2));
//        System.out.println(b.divide(10,3));
//        System.out.println(b.multiply(3.5,2.3));
//        System.out.println(e.pow(2,3));
//        System.out.println(e.pow(2,0));
//        System.out.println(e.pow(2,-1));
//        System.out.println(e.root(4));
//        System.out.println(e.fact(3));
//        System.out.println(b.divide(3,1.5));
//        System.out.println(e.root(10));

//        System.out.println(e.calculate("20.50 + 30.25 + 2"));
//        System.out.println(e.calculate("3*2"));
//        System.out.println((e.calculate("-3-5*3")));
//        System.out.println(e.calculate("2*(3+2)/5"));
//
//        System.out.println(e.calculate("(3+2)/5"));
//        System.out.println(e.calculate("2*(3+2)"));
//        System.out.println(e.calculate("-3+2"));
//        System.out.println(e.calculate(("2*(-3+2)")));
//        System.out.println(e.calculate("-3-5*3"));
//        System.out.println(e.calculate("(-3-5)/2"));
//        System.out.println(e.calculate("-3-5*3"));
//        System.out.println(e.calculate("2+(-3-5)"));
//        System.out.println((e.calculate("(3+2)/5*5-(8/2)")));
//        System.out.println(e.calculate("2^3"));
//        System.out.println(e.calculate("(-3+1)^5"));
//        System.out.println(e.calculate("2.3^3"));
//        System.out.println(e.calculate("(-3-5)^-2"));
//        System.out.println(e.calculate("-2^-2"));
        //System.out.println(e.calculate("2.3^3.2"));

        System.out.println(b.multiply(-2.2,4.3));
        System.out.println(e.factRec(-3));


    }
}
