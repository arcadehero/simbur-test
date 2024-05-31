package com.simbirsoft.testtask.util;

import java.time.LocalDate;

public class FibonacciNumberGenerator {

    public static int getRequiredNumberForTest() {
        return LocalDate.now().getDayOfMonth() + 1;
    }

    public static int calculateFibonacciBasedOnCurrentMonth(int number) {
        if (number <= 1) {
            return number;
        }
        return calculateFibonacciBasedOnCurrentMonth(number - 1) + calculateFibonacciBasedOnCurrentMonth(number - 2);
    }
}
