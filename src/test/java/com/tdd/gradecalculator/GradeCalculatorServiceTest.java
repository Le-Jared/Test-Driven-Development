package com.tdd.gradecalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeCalculatorServiceTest {
    private GradeCalculatorService gradeCalculator;

    @BeforeEach
    public void setUp() {
        gradeCalculator = new GradeCalculatorServiceImpl();
    }

    @Test
    public void testGetClassificationReturnsFailWhenMarkIsLessThan75() {
        assertEquals("fail", gradeCalculator.getClassification(74.9));
    }

    @Test
    public void testGetClassificationReturnsPassWhenMarkIsGreaterThanOrEqualTo75AndLessThan80() {
        assertEquals("pass", gradeCalculator.getClassification(75));
        assertEquals("pass", gradeCalculator.getClassification(79.9));
    }

    @Test
    public void testGetClassificationReturnsMeritWhenMarkIsGreaterThanOrEqualTo80AndLessThan90() {
        assertEquals("merit", gradeCalculator.getClassification(80));
        assertEquals("merit", gradeCalculator.getClassification(89.9));
    }

    @Test
    public void testGetClassificationReturnsDistinctionWhenMarkIsGreaterThanOrEqualTo90AndLessThanOrEqualTo100() {
        assertEquals("distinction", gradeCalculator.getClassification(90));
        assertEquals("distinction", gradeCalculator.getClassification(100));
    }
    @Test
    public void testGetClassificationReturnsFailWhenMarkIsZero() {
        assertEquals("fail", gradeCalculator.getClassification(0));
    }

    @Test
    public void testGetClassificationThrowsExceptionWhenMarkIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> gradeCalculator.getClassification(-1));
    }

    @Test
    public void testGetClassificationThrowsExceptionWhenMarkIsAbove100() {
        assertThrows(IllegalArgumentException.class, () -> gradeCalculator.getClassification(101));
    }
}
