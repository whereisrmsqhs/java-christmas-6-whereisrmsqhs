package christmas.domain;

import java.util.Map;

public class MyMenu {

    private final Map<Menu, Integer> myOrderedMenus;

    public MyMenu(Map<Menu, Integer> myOrderedMenus) {
        this.myOrderedMenus = myOrderedMenus;
    }
}
