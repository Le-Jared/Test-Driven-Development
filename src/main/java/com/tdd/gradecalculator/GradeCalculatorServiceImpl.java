package com.tdd.gradecalculator;

public class GradeCalculatorServiceImpl implements GradeCalculatorService {
    @Override
    public String getClassification(double mark) {
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("Mark must be between 0 and 100 inclusive.");
        }

        if (mark >= 0 && mark < 75) {
            return "fail";
        } else if (mark >= 75 && mark < 80) {
            return "pass";
        } else if (mark >= 80 && mark < 90) {
            return "merit";
        } else {
            return "distinction";
        }
    }
}
