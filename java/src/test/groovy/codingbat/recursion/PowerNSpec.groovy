package codingbat.recursion

import spock.lang.Unroll
import test.BaseSpec

final class PowerNSpec extends BaseSpec {
    @Unroll def "powerN(#a, #b) == '#c'"() {
        expect:
        PowerN.powerN(a, b) == c

        where:
        a | b || c
        1 | 1 || 1
        3 | 1 || 3
        3 | 2 || 9
        3 | 3 || 27
    }
}
