package christmas.enums;

import static christmas.enums.MenuCategory.*;

public enum Menu {
    MUSHROOM_SOUP(6000, APPETIZER),
    TAPAS(5500, APPETIZER),
    CAESAR_SALAD(8000, APPETIZER),
    T_BONE_STEAK(55000, MAIN),
    BBQ_RIBS(54000, MAIN),
    SEAFOOD_PASTA(35000, MAIN),
    CHRISTMAS_PASTA(25000, MAIN),
    CHOCOLATE_CAKE(15000, DESSERT),
    ICE_CREAM(5000, DESSERT),
    ZERO_COKE(3000, DRINK),
    RED_WINE(60000, DRINK),
    CHAMPAGNE(25000, DRINK);

    private int price;
    private MenuCategory type;

    Menu(int price, MenuCategory type) {
        this.price = price;
        this.type = type;
    }
}
