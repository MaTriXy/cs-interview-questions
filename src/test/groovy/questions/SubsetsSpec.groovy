package questions

import spock.lang.Specification

class SubsetsSpec extends Specification {

    def "Test [Correct Values]"() {
        expect:
        Subsets.subsets(a) == b
        Subsets.subsets(a as int[]) == b

        where:
        a         || b
        null      || null
        []        || [[]]
        [1]       || [[], [1]]
        [1, 2]    || [[], [1], [2], [1, 2]]
        [1, 2, 3] || [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
        [3, 1, 2] || [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
    }

}
