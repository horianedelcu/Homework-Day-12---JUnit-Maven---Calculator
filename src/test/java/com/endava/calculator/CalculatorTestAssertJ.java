package com.endava.calculator;

import com.endava.calculator.basic.Basic;
import com.endava.calculator.basic.BasicOperations;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTestAssertJ {

    private BasicOperations basic = new Basic();

    @Tag("add")
    @Test
    public void shouldAddOneOperand() {

        //WHEN
        Long result = basic.add(167);

        //THEN
        assertThat(result).isEqualTo(167L)
                .isBetween(100L ,200L)
                .isGreaterThan(150L)
                .isNotNegative()
                .isNotNull();
    }
}
