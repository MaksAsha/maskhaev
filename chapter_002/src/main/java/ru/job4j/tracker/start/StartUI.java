package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

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
            key = Integer.valueOf(input.ask("Select:"));
            menuTracker.select(key);
        } while (key!=7);

    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
