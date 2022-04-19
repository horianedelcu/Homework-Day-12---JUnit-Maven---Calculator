package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import com.endava.calculator.expert.Expert;
import com.endava.calculator.expert.ExpertOperations;
//import com.endava.extensions.CustomTestExecutionListener;
import com.endava.extensions.TestReporterExtension;
import org.apiguardian.api.API;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.LoggingListener;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import static org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request;

@ExtendWith(TestReporterExtension.class)
public class CalculatorTest {

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
    public void shouldAddNumbersGivenOperand0(int a, int b, long expected) {

        //GIVEN

        //WHEN
        long result = basic.add(a, b);
        //THEN
        assertThat(result, is(expected));
        assertThat(result, notNullValue());
    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(0, 2, 2));
        argumentsList.add(Arguments.of(2, 0, 2));

        return argumentsList;
    }

    @Tags({@Tag("smoke"), @Tag("add")})
    @ParameterizedTest
    @CsvSource({"-2, -4, -6", "-3, -8, -11"})
    public void shouldAddGivenNegativeNumbers(int a, int b, long expected) {

        //GIVEN


        //WHEN
        Long result = basic.add(a, b);

        //THEN
        assertThat(result, is(expected));
        assertThat(result, notNullValue());
    }

    @Tags({@Tag("smoke"), @Tag("api"), @Tag("add")})
    @Test
    public void shouldAddGivenVeryBigNumbers() {

        //WHEN
        Long result = basic.add(Integer.MAX_VALUE, 1);

        //THEN
        assertThat(result, is(2147483648L));
        assertThat(result, greaterThan(0L));
        assertThat(result, notNullValue());
        System.out.println(result);
    }

    @Tag("add")
    @Test
    public void shouldAddNoOperands() {

        //GIVEN


        //WHEN
        Long result = basic.add();

        //THEN
        assertThat(result, is(0L));
        assertTrue(result.equals(0L));
    }

    @Tag("add")
    @Test
    public void shouldAddOneOperand() {

        //GIVEN


        //WHEN
        Long result = basic.add(167);

        //THEN
        assertThat(result, is(167L));
        assertThat(result, notNullValue());
        assertTrue(result.equals(167L));
    }

    @Tag("add")
    @ParameterizedTest
    @CsvFileSource(resources = "numberSource.csv")
    @CsvSource({"1,2,3,6", "2,4,5,11"})
    @DisplayName("Should Add More Than Two Operands")
    public void shouldAddMoreThanTwoOperands(int a, int b, int c, long expected) {

        //GIVEN


        //WHEN
        Long result = basic.add(a, b, c);

        //THEN
        assertThat(result, is(expected));
        assertThat(result, notNullValue());
    }




    // ---------------------- MULTIPLY TESTS ----------------------




    @Tag("multiply")
    @Test
    public void shouldMultiplyNoOperands() {

        //GIVEN

        //WHEN
        Long result = basic.multiply();

        //THEN
        assertThat(result, notNullValue());
    }

    @Tag("multiply")
    @Test
    public void shouldMultiplyOneOperand() {

        //GIVEN

        //WHEN
        Long result = basic.multiply(10);

        //THEN
        assertThat(result, is(10L));
        assertThat(result, notNullValue());
        assertThat(result, greaterThan(0L));
    }

    @Tag("multiply")
    @ParameterizedTest
    @CsvSource({"1,2,3,6", "1,2,-3,-6" ,"-2,-4,5,40"})
    public void shouldMultiplyMoreThanTwoOperands(int a, int b, int c, long expected) {

        //GIVEN

        //WHEN
        Long result = basic.multiply(a, b, c);

        //THEN
        assertThat(result, is(expected));
        assertThat(result, notNullValue());
        assertThat(result, not(0L));

    }

    @Tag("multiply")
    @ParameterizedTest
    @CsvSource({"10,0", "0,10" ,"-2,0", "0,-2"})
    public void shouldMultiplyGivenOneOperandIs0(int a, int b){
        //GIVEN

        //WHEN
        Long result = basic.multiply(a, b);

        //THEN
        assertThat(result, is(0L));
        assertThat(result, notNullValue());
    }

    @Tag("multiply")
    @Test
    public void shouldMultiplyGivenVeryBigNumbers() {

        //GIVEN

        //WHEN
        Long result = basic.multiply(Integer.MAX_VALUE, 2);


        //THEN
        assertThat(result, greaterThan(Long.valueOf(Integer.MAX_VALUE)));
        assertThat(result, not(Long.valueOf(Integer.MAX_VALUE)));
        assertThat(result, is(4294967294L) );
    }

    @Tag("multiply")
    @ParameterizedTest
    @CsvSource({"-2, 4,-8", "4, -2,-8"})
    public void shouldMultiplyGivenOneNegativeOperand(int a, int b, long expected) {

        //GIVEN

        //WHEN
        Long result = basic.multiply(a, b);

        //THEN
        assertThat(result, is(-8L));
        assertThat(result, lessThan(0L));
        assertThat(result, notNullValue());
        assertThat(result, not(0L));
    }

    @Tag("multiply")
    @Test
    public void shouldMultiplyGivenNegativeNumbers() {

        //WHEN
        Long result = basic.multiply(-2, -4);

        //THEN
        assertThat(result, is(8L));
        assertThat(result, not(0L));
        assertThat(result, notNullValue());
    }


    @Tag("multiply")
    @ParameterizedTest
    @CsvSource({"2.2, 4.3, 9.46", "-2.2, 4.3, -9.46", "2.2, -4.3, -9.46", "-2.2, -4.3, 9.46"})
    public void shouldMultiplyGivenFloatingNumbers(double a, double b, double expected) {

        //WHEN
        Double result = basic.multiply(a, b);

        //THEN
        assertThat(result, is(expected));
        assertThat(result, not(0.0));
        assertThat(result, notNullValue());
    }




    // ---------------------- POW TESTS ----------------------




    @Tag("pow")
    @Test
    public void shouldPowGivenNegativeBase() {


        //WHEN
        Double result = expert.pow(-2, 3);

        //THEN
        assertThat(result, is(-8.0));
        assertThat(result, not(0.0));
        assertThat(result, notNullValue());
    }


    @Tag("pow")
    @Test
    public void shouldPowGivenNegativeExponent() {

        //WHEN
        Double result = expert.pow(2, -2);

        //THEN
        assertThat(result, is(0.25));
        assertThat(result, lessThan(1.0));
        assertThat(result, not(0.0));
    }

    @Tag("pow")
    @Test
    public void shouldPowGivenFloatingBase() {

        //WHEN
        Double result = expert.pow(2.2, 3);

        //THEN
        assertThat(result, is(10.648));
        assertThat(result, greaterThan(0.0));
        assertThat(result, notNullValue());
    }

    @Tag("pow")
    @ParameterizedTest
    @CsvSource({"2, 0", "10, 0", "321421, 0"})
    public void shouldPowGivenExponentIsZero(double base, int exponent) {

        //WHEN
        Double result = expert.pow(base, exponent);

        //THEN
        assertThat(result, is(1.0));
        assertThat(result, not(0.0));

    }


    @Tag("pow")
    @Test
    public void shouldPowGivenBaseIsZero() {

        //GIVEN

        //WHEN
        Double result = expert.pow(0, 20);

        //THEN
        assertThat(result, is(0.0));
        assertThat(result, notNullValue());
    }




    // ---------------------- FACTORIAL TESTS ----------------------



    @Tag("factorial")
    @Test
    public void shouldFactorialGivenNIsZero() {

        //GIVEN

        //WHEN
        Long result = expert.factRec(0);

        //THEN
        assertThat(result, is(1L));
        assertThat(result, notNullValue());
    }

    @Tag("factorial")
    @ParameterizedTest
    @CsvSource({"2, 2","8, 40320","20, 2432902008176640000"})
    public void shouldFactorialGivenNIsSmallNaturalNumber(int a, long expected) {

        //GIVEN

        //WHEN
        Long result = expert.factRec(a);

        //THEN
        assertThat(result, is(expected));
        assertThat(result, greaterThan(0L));
        assertThat(result, notNullValue());
    }


    // BUG nr. 1
    @Tag("factorial")
    @Test
    public void shouldFactorialGivenNIsABigNumber() {

        assertThrows(StackOverflowError.class, () -> {

            //WHEN
            Long result = expert.factRec(Integer.MAX_VALUE);

            //THEN
            assertThat(result, greaterThan(Long.valueOf(Integer.MAX_VALUE)));
            assertThat(result, greaterThan(0L));
            assertThat(result, instanceOf(Long.class));
        });
    }


    @Tag("factorial")
    @Test
    public void shouldFactorialGivenNIsANegativeNumber() {

        assertThrows(IllegalArgumentException.class, () -> {

            //WHEN
            Long result = expert.factRec(-3);
        });

    }


}
