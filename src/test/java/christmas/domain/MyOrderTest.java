package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MyOrderTest {

    @ParameterizedTest
    @CsvSource(value = {"티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1:142,000"}, delimiter = ':')
    @DisplayName("주문한 메뉴 정보가 주어졌을 때 할인전 총 금액을 계산하는 기능")
    void calculateTotalAmountBeforeDiscount(String textOrder, String expectedResult) {
        MyOrder myOrder = new MyOrder(textOrder);
        Price totalAmountBeforeDiscount = myOrder.calculateTotalAmountBeforeDiscount();

        Assertions.assertThat(totalAmountBeforeDiscount.convertToOutputType()).isEqualTo(expectedResult);

    }

}