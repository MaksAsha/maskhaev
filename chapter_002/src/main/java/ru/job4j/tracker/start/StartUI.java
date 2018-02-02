package ru.job4j.tracker.start;

public class StartUI {

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {

        MenuTracker menuTracker = new MenuTracker(tracker, input);
        menuTracker.fillActions();
        int key;
        do {
            menuTracker.show();
            key = Integer.valueOf(input.ask("Select:", MenuEnum.getMenuItems()));
            menuTracker.select(key);
        } while (key != MenuEnum.getOrderValue(MenuEnum.EXIT));

    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
