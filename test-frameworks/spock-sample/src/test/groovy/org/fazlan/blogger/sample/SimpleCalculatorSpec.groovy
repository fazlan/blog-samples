package org.fazlan.blogger.sample

import spock.lang.Specification


class SimpleCalculatorSpec extends Specification {

    Calculator calculator

    def setup() {
        calculator = new SimpleCalculator()
    }

    def "adds numbers and returns the sum of the numbers"() {

        when:
        def result = calculator.add(* numbers)

        then:
        result == expected_result

        where:
        numbers    | expected_result
        [0]        | 0
        [1]        | 1
        [1.4, 2.5] | 3.9
    }

    def "multiplies given numbers and returns the multiplication result"() {

        when:
        def result = calculator.multiply(* numbers)

        then:
        result == expected_result

        where:
        numbers  | expected_result
        [0]      | 0
        [1]      | 1
        [1, 0]   | 0
        [1.5, 2] | 3
    }
}
