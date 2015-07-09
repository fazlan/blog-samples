package org.fazlan.blogger.sample;

import java.util.Arrays;

public class SimpleCalculator implements Calculator {
    @Override
    public double add(double... numbers) {
        return Arrays.stream(numbers).sum();
    }

    @Override
    public double multiply(double... numbers) {
        return Arrays.stream(numbers).reduce(1, (n1, n2) -> n1 * n2);
    }
}
