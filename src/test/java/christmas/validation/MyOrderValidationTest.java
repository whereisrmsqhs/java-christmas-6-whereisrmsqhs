package christmas.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyOrderValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"여기 해산물파스타 하나요~", "해산물파스타-하나"})
    @DisplayName("음식 주문 입력값은 특정한 형태를 유지 하면 안되면 에러를 리턴한다.")
    void validateFoodOrderFormat(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MyOrderValidation.validateOrderInfo(input);
        });
    }
}