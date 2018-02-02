package ru.job4j.tracker.start;

public enum MenuEnum {
    ADD,
    REPLACE,
    DELETE,
    SHOW,
    FIND_BY_ID,
    FIND_BY_NAME,
    EXIT;

    private int[] range = new int[]{1, 2, 3, 4, 5, 6, 7};

    public static int getOrderValue(MenuEnum itemEnum) {
        return itemEnum.ordinal() + 1;
    }

    public static int[] getMenuItems() {
        return new int[]{1, 2, 3, 4, 5, 6, 7};
    }

}
