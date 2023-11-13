package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static christmas.domain.DateOfTheWeek.MONDAY;
import static christmas.domain.DateOfTheWeek.SUNDAY;
import static org.junit.jupiter.api.Assertions.*;

class DateOfTheWeekTest {

    @ParameterizedTest
    @MethodSource("generateDateOfTheWeekAndDays")
    @DisplayName("일요일 혹은 25일 당일은 특별 할인이 적용돠는 날이다.")
    void setSpecialDay(DateOfTheWeek dateOfTheWeek, Integer day, boolean expectedResult) {
        // given
        DateOfTheWeek date = dateOfTheWeek;

        // when
        boolean isItSpecialDay = date.isSpecialDay(day);

        // then
        Assertions.assertThat(isItSpecialDay).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> generateDateOfTheWeekAndDays() {
        return Stream.of(
                Arguments.of(SUNDAY, 3, true),
                Arguments.of(MONDAY, 4, false),
                Arguments.of(MONDAY, 25, true)
        );
    }

}