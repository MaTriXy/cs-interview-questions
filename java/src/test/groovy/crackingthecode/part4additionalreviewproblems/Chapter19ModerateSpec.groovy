package crackingthecode.part4additionalreviewproblems

import api.Pair
import crackingthecode.Chapter19Moderate
import spock.lang.Unroll
import test.BaseSpec

final class Chapter19ModerateSpec extends BaseSpec {
    def sut = new Chapter19Moderate()

    def "swapVar"() {
        given:
        def a = 1
        def b = 2

        when:
        //        sut.swapVar(a, b)
        sut.swapVar2(a, b)
        a ^= b
        b ^= a
        a ^= b

        then:
        a == 2
        b == 1
    }

    @Unroll def "19.2 - checkTicTacToe(#a) == '#b'"() {
        expect:
        sut.checkTicTacToe(a as int[][]) == b

        where:
        a           || b
        null        || -1
        [[0, 0, 0],
         [0, 1, 0],
         [0, 1, 0]] || -1
        [[0, 1, 0],
         [0, 1, 0],
         [0, 1, 0]] || 1
        [[0, 0, 0],
         [2, 2, 2],
         [0, 0, 0]] || 2
        [[0, 0, 1],
         [0, 1, 0],
         [1, 0, 0]] || 1
        [[2, 0, 0],
         [0, 2, 0],
         [0, 0, 2]] || 2
    }

    @Unroll def "19.3 - numZeros(#a) == '#b'"() {
        expect:
        sut.numZeros(a) == b

        // 26! = 403291461126605635584000000
        where:
        a  || b
        -1 || 0
        10 || 2
        26 || 6
    }

    @Unroll def "19.4 - getMax(#a, #b) == '#c'"() {
        expect:
        sut.getMax(a as long, b as long) == c
        sut.getMax2(a as long, b as long) == c

        where:
        a   | b   || c
        -1  | -1  || -1 // same val
        10  | 0   || 10 // 0 val
        100 | 50  || 100
        213 | 321 || 321
    }

    @Unroll def "getMin(#a, #b) == '#c'"() {
        expect:
        sut.getMin(a as long, b as long) == c

        where:
        a   | b   || c
        -1  | -1  || -1 // same val
        10  | 0   || 0 // 0 val
        100 | 50  || 50
        213 | 321 || 213
    }

    @Unroll def "19.5 - getPseudoHits(#a, #b) == '#c'"() {
        expect:
        sut.getPseudoHits(a, b) == c

        where:
        a      | b      || c
        null   | null   || null
        "RGGB" | null   || null
        null   | "RGGB" || null
        "123"  | "1324" || null
        "RGGB" | "RGGB" || new Pair<>(4, 0)
        "RGGB" | "YRGB" || new Pair<>(2, 1)
    }

    @Unroll def "19.7 - getMaxSum(#a) == '#b'"() {
        expect:
        sut.getMaxSum(a as int[]) == b

        where:
        a                               || b
        null                            || 0
        [2, -8, 3, -2, 4, -10]          || 5
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] || 6
    }

    @Unroll def "19.8 - getWordOccurrence(#a, #b) == '#c'"() {
        expect:
        sut.getWordOccurrence(a as String[], b) == c

        where:
        a                     | b      || c
        null                  | null   || -1
        null                  | "test" || -1
        ["test"]              | null   || -1
        ["the", "the", "the"] | "the"  || 3
        ["the", null, "the"]  | "the"  || 2
        ["the", null, "the"]  | "hat"  || 0
        ["the", null, "the"]  | "hat"  || 0
        ["the", "", "the"]    | "hat"  || 0
    }

    def "19.10 - rand7"() {
        expect:
        sut.rand5() in 1..5
        sut.rand7() in 1..7
        sut.rand72() in 1..7
    }

    @Unroll def "19.11 - getPairSum(#a, #b) == '#c'"() {
        expect:
        sut.getPairSum(a as int[], b) == c as Map<Integer, Integer>

        where:
        a                  | b || c
        [1, 1]             | 2 || [1: 1]
        [1, 5, 3, 6, 3, 8] | 9 || [6: 3, 8: 1]
    }
}
