package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDiscountPolicyTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1,000", "25:3,400", "26:0"}, delimiter = ':')
    @DisplayName("날짜 Integer가 주어졌을 때 해당 날짜 크리스마스 할인 금액 계산")
    void calculateChristmasDiscount(Integer date, String expected) {
        December december = December.getInstance();
        ChristmasDiscountPolicy policy = new ChristmasDiscountPolicy();
        MyOrder myOrder = new MyOrder("티본스테이크-1");
        Price discount = policy.discount(myOrder, date, december);

        Assertions.assertThat(discount.convertToOutputType()).isEqualTo(expected);
    }

}