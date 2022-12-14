package onboarding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem1Test {
    @ParameterizedTest
    @CsvSource(value = {"3:3", "9:9", "19:10", "33:6", "50:5", "378:18", "400:4"}, delimiter = ':')
    void 각_자리수_합_테스트(int page, int result) {
        assertThat(Problem1.addEachDigitOfPage(page)).isEqualTo(result);
    }
}
