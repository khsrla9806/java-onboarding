package onboarding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    @ParameterizedTest
    @CsvSource(value = {"3:3", "9:9", "19:10", "33:6", "50:5", "378:18", "400:4"}, delimiter = ':')
    void 각_자리수_합_테스트(int page, int result) {
        assertThat(Problem1.addEachDigitOfPage(page)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:3", "9:9", "19:9", "33:9", "50:0", "378:168", "400:0"}, delimiter = ':')
    void 각_자리수_곱_테스트(int page, int result) {
        assertThat(Problem1.multiplyEachDigitOfPage(page)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("getMaxValue")
    void 가장_큰수_구하는_테스트(int result, List<Integer> inputData) {
        assertThat(Problem1.getBiggestValue(inputData)).isEqualTo(result);
    }

    private static Stream<Arguments> getMaxValue() {
        return Stream.of(
                Arguments.of(23, List.of(1, 4, 6, 23)),
                Arguments.of(30, List.of(2, 5, 13, 30)),
                Arguments.of(60, List.of(18, 42, 60, 23)),
                Arguments.of(100, List.of(100, 42, 64, 23))
        );
    }
}
