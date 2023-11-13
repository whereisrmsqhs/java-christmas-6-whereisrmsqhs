package christmas.domain;

import java.util.EnumMap;
import java.util.Map;

import static christmas.constant.NumbersOrSymbols.*;
import static christmas.domain.Menu.findMyMenu;

public class MyOrder {

    private static final Map<Menu, Integer> myAllOrderedMenus = new EnumMap<>(Menu.class);

    public MyOrder(String myOrderedMenus) {
        saveMyOrders(myOrderedMenus);
    }

    private void saveMyOrders(String myOrderedMenus) {
        String[] eachFoodOrder = myOrderedMenus.split(DIVIDE_EACH_ORDERED_MENU);
        for (String eachOrder : eachFoodOrder) {
            int dashIndex = eachOrder.indexOf(DIVIDE_FOOD_NUMBER);
            Menu myOrderedFood = findMyMenu(eachOrder.substring(0, dashIndex));
            Integer myOrderFoodNumber = Integer.valueOf(eachOrder.substring(dashIndex+1));

            myAllOrderedMenus.put(myOrderedFood, myOrderFoodNumber);
        }
    }

    public Price calculateTotalAmountBeforeDiscount() {
        Integer totalAmount = 0;
        for (Menu menu : myAllOrderedMenus.keySet()) {
            totalAmount += menu.calculateEachMenuAmount(myAllOrderedMenus.get(menu));
        }
        return new Price(totalAmount);
    }

}
