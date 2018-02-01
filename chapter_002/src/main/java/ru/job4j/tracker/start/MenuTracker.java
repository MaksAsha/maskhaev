package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

class ReplaceItem implements UserAction {

    private static final int REPLACE = 2;

    @Override
    public int key() {
        return REPLACE;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id задачи:");
        String name = input.ask("Введите наименование задачи:");
        String desc = input.ask("Введите описание задачи:");
        tracker.replace(id, new Item(name, desc, 1L));
    }

    @Override
    public String info() {
        return String.format("%s. %s ", this.key(), "Edit item");
    }
}

class FindByName implements UserAction {

    private static final int FIND_BY_NAME = 6;

    @Override
    public int key() {
        return FIND_BY_NAME;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String taskname = input.ask("Введите наименование задачи, которую необходимо найти:");
        System.out.println("Список задач:");
        for (Item item : tracker.findByName(taskname)) {
            System.out.println(item);
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s ", this.key(), "Find item by name");
    }
}


public class MenuTracker {

    private static final int ADD = 1;
    private static final int DELETE = 3;
    private static final int SHOW = 4;
    private static final int FIND_BY_ID = 5;
    private static final int EXIT = 7;

    private Tracker tracker;
    private Input input;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ReplaceItem();
        this.actions[2] = new DeleteItem();
        this.actions[3] = new ShowItems();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new Exit();
    }

    public void select(int key) {
        if (key >= 1 && key <= 6) {
            actions[key - 1].execute(this.input, this.tracker);
        }
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) System.out.println(action.info());
        }
    }

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return ADD;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите наименование задачи:");
            String desc = input.ask("Введите описание задачи:");
            tracker.add(new Item(name, desc, 1L));
        }

        @Override
        public String info() {
            return String.format("%s. %s ", this.key(), "Add a new item");
        }
    }

    private class DeleteItem implements UserAction {

        @Override
        public int key() {
            return DELETE;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id задачи, которую необходимо удалить:");
            tracker.delete(id);
        }

        @Override
        public String info() {
            return String.format("%s. %s ", this.key(), "Delete item");
        }
    }

    private static class ShowItems implements UserAction {

        @Override
        public int key() {
            return SHOW;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(item);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s ", this.key(), "Show all items");
        }
    }

    private static class FindById implements UserAction {

        @Override
        public int key() {
            return FIND_BY_ID;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id задачи, которую необходимо найти:");
            System.out.println(tracker.findById(id));
        }

        @Override
        public String info() {
            return String.format("%s. %s ", this.key(), "Find item by id");
        }
    }

    private static class Exit implements UserAction {

        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return String.format("%s. %s ", this.key(), "Exit");
        }
    }


}

