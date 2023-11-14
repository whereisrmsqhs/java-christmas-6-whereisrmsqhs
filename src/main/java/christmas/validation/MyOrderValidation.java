package christmas.validation;

import christmas.domain.Menu;

import java.util.Map;
import java.util.regex.Pattern;

import static christmas.constant.ErrorMessage.ERROR;
import static christmas.constant.ErrorMessage.INVALID_INPUT;

public class MyOrderValidation {
    public static void validateOrderInfo(String myOrderedFoods) {
        String pattern = "([가-힣]+-\\d+)(,([가-힣]+-\\d+))*";
        boolean isMatch = Pattern.matches(pattern, myOrderedFoods);
        if (isMatch == false)
            throw new IllegalArgumentException(ERROR + INVALID_INPUT);
    }

    public static void validateFood(Menu myOrderedFood, Map<Menu, Integer> myAllOrderedMenus) {
        if (myOrderedFood.equals(null)) throw new IllegalArgumentException(ERROR + INVALID_INPUT);
        if (!myAllOrderedMenus.get(myOrderedFood).equals(null))
            throw new IllegalArgumentException(ERROR + INVALID_INPUT);
    }

    public static void validateOrderNumber(Integer myOrderFoodNumber) {
        if (myOrderFoodNumber < 1)
            throw new IllegalArgumentException(ERROR + INVALID_INPUT);
    }
}
