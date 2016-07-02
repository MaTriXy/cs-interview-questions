package codingbat.recursion

import test.BaseSpec

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
class FibonacciSpec extends BaseSpec {

    def "fibonacci"() {
        expect:
        Fibonacci.fibonacci(a) == b

        where:
        a  | b
        -5 | -5
        -1 | -1
        0  | 0
        1  | 1
        2  | 1
        3  | 2
        4  | 3
        5  | 5
        6  | 8
        7  | 13
        8  | 21
    }
}
