package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
import com.endava.extensions.TestReporterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(TestReporterExtension.class)
public class CalculatorTestIT {

    private BasicOperations basic;
    private ExpertOperations expert;

    @BeforeAll
    public static void setUpAllTests() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTests() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTest() {
        System.out.println("Before Each");
        basic = new Basic();
        expert = new Expert();
    }

    @AfterEach
    public void setUpAfterEach() {
        System.out.println("After Each\n\n");
    }



    // ---------------------- ADD TESTS ----------------------




    @Tags({@Tag("smoke"), @Tag("ui"), @Tag("add")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumbersGivenOperand0(int a, int b) {

        //GIVEN

        //WHEN
        long result = basic.add(a, b);
        //THEN
        System.out.println(result);
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2));
        argumentsList.add(Arguments.of(2, 0));

        return argumentsList;
    }

    @Tags({@Tag("smoke"), @Tag("add")})
    @Test
    public void shouldAddGivenNegativeNumbers() {

        //GIVEN


        //WHEN
        Long result = basic.add(-2, -4);

        //THEN
        System.out.println(result);
    }

    @Tags({@Tag("smoke"), @Tag("api"), @Tag("add")})
    @Test
    public void shouldAddGivenVeryBigNumbers() {

        //GIVEN


        //WHEN
        Long result = basic.add(Integer.MAX_VALUE, 1);

        //THEN
        System.out.println(result);
    }

    @Tag("add")
    @Test
    public void shouldAddNoOperands() {

        //GIVEN


        //WHEN
        Long result = basic.add();

        //THEN
        System.out.println(result);
    }

    @Tag("add")
    @Test
    public void shouldAddOneOperand() {

        //GIVEN


        //WHEN
        Long result = basic.add(167);

        //THEN
        System.out.println(result);
    }

    @Tag("add")
    @ParameterizedTest
    @CsvFileSource(resources = "numberSource.csv")
    @CsvSource({"1,2,3", "2,4,5"})
    public void shouldAddMoreThanTwoOperands(int a, int b, int c) {

        //GIVEN


        //WHEN
        Long result = basic.add(a, b, c);

        //THEN
        System.out.println(result);
    }




    // ---------------------- MULTIPLY TESTS ----------------------




    @Tag("multiply")
    @Test
    public void shouldMultiplyNoOperands() {

        //GIVEN

        //WHEN
        Long result = basic.multiply();

        //THEN
        System.out.println(result);
    }

    @Tag("multiply")
    @Test
    public void shouldMultiplyOneOperand() {

        //GIVEN

        //WHEN
        Long result = basic.multiply(10);

        //THEN
        System.out.println(result);
    }

    @Tag("multiply")
    @ParameterizedTest
    @CsvSource({"1,2,3", "1,2,-3" ,"-2,-4,5"})
    public void shouldMultiplyMoreThanTwoOperands(int a, int b, int c) {

        //GIVEN

        //WHEN
        Long result = basic.multiply(a, b, c);

        //THEN
        System.out.println(result);
    }

    @Tag("multiply")
    @ParameterizedTest
    @CsvSource({"10,0", "0,10" ,"-2,0", "0,-2"})
    public void shouldMultiplyGivenOneOperandIs0(int a, int b){
        //GIVEN

        //WHEN
        Long result = basic.multiply(a, b);

        //THEN
        System.out.println(result);
    }

    @Tag("multiply")
    @Test
    public void shouldMultiplyGivenVeryBigNumbers() {

        //GIVEN

        //WHEN
        Long result = basic.multiply(Integer.MAX_VALUE, 2);

        //THEN
        System.out.println(result);
    }

    @Tag("multiply")
    @Test
    public void shouldMultiplyGivenOneNegativeOperand() {

        //GIVEN

        //WHEN
        Long result = basic.multiply(-2, 4);

        //THEN
        System.out.println(result);
    }

    @Tag("multiply")
    @Test
    public void shouldMultiplyGivenNegativeNumbers() {

        //GIVEN

        //WHEN
        Long result = basic.multiply(-2, -4);

        //THEN
        System.out.println(result);
    }


    @Tag("multiply")
    @Test
    public void shouldMultiplyGivenFloatingNumbers() {

        //GIVEN

        //WHEN
        Double result = basic.multiply(-2.2, -4.3);

        //THEN
        System.out.println(result);
    }




    // ---------------------- POW TESTS ----------------------




    @Tag("pow")
    @Test
    public void shouldPowGivenNegativeBase() {

        //GIVEN

        //WHEN
        Double result = expert.pow(-2, 3);

        //THEN
        System.out.println(result);
    }


    @Tag("pow")
    @Test
    public void shouldPowGivenNegativeExponent() {

        //GIVEN

        //WHEN
        Double result = expert.pow(2, -2);

        //THEN
        System.out.println(result);
    }

    @Tag("pow")
    @Test
    public void shouldPowGivenFloatingBase() {

        //GIVEN

        //WHEN
        Double result = expert.pow(2.2, 3);

        //THEN
        System.out.println(result);
    }

    @Tag("pow")
    @Test
    public void shouldPowGivenExponentIsZero() {

        //GIVEN

        //WHEN
        Double result = expert.pow(2, 0);

        //THEN
        System.out.println(result);
    }


    @Tag("pow")
    @Test
    public void shouldPowGivenBaseIsZero() {

        //GIVEN

        //WHEN
        Double result = expert.pow(0, 20);

        //THEN
        System.out.println(result);
    }




    // ---------------------- FACTORIAL TESTS ----------------------



    @Tag("factorial")
    @Test
    public void shouldFactorialGivenNIsZero() {

        //GIVEN

        //WHEN
        Long result = expert.factRec(0);

        //THEN
        System.out.println(result);
    }

    @Tag("factorial")
    @ParameterizedTest
    @CsvSource({"2","8","20"})
    public void shouldFactorialGivenNIsSmallNaturalNumber(int a) {

        //GIVEN

        //WHEN
        Long result = expert.factRec(a);

        //THEN
        System.out.println(result);
    }

//    @Tag("factorial")
//    @Test
//    public void shouldFactorialGivenNIsABigNumber() {
//
//        //GIVEN
//
//        //WHEN
//        Long result = expert.factRec(Integer.MAX_VALUE);
//
//        //THEN
//        System.out.println(result);
//    }



//    @Tag("factorial")
//    @Test
//    public void shouldFactorialGivenNIsANegativeNumber() {
//
//        //GIVEN
//
//        //WHEN
//        Long result = expert.factRec(-3);
//
//        //THEN
//        System.out.println(result);
//    }


}
