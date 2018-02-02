package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

class ReplaceItem extends BaseAction {

    public ReplaceItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id задачи:");
        String name = input.ask("Введите наименование задачи:");
        String desc = input.ask("Введите описание задачи:");
        tracker.replace(id, new Item(name, desc, 1L));
    }
}

class FindByName extends BaseAction {

    public FindByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String taskname = input.ask("Введите наименование задачи, которую необходимо найти:");
        System.out.println("Список задач:");
        for (Item item : tracker.findByName(taskname)) {
            System.out.println(item);
        }
    }
}

public class MenuTracker {

    private Tracker tracker;
    private Input input;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    public void fillActions() {
        this.actions[0] = new AddItem(MenuEnum.getOrderValue(MenuEnum.ADD), "Add a new item");
        this.actions[1] = new ReplaceItem(MenuEnum.getOrderValue(MenuEnum.REPLACE), "Replace item");
        this.actions[2] = new DeleteItem(MenuEnum.getOrderValue(MenuEnum.DELETE), "Delete item");
        this.actions[3] = new ShowItems(MenuEnum.getOrderValue(MenuEnum.SHOW), "Show all items");
        this.actions[4] = new FindById(MenuEnum.getOrderValue(MenuEnum.FIND_BY_ID), "Find item by id");
        this.actions[5] = new FindByName(MenuEnum.getOrderValue(MenuEnum.FIND_BY_NAME), "Find item by name");
        this.actions[6] = new Exit(MenuEnum.getOrderValue(MenuEnum.EXIT), "Exit");
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

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите наименование задачи:");
            String desc = input.ask("Введите описание задачи:");
            tracker.add(new Item(name, desc, 1L));
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id задачи, которую необходимо удалить:");
            tracker.delete(id);
        }
    }

    private static class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(item);
            }
        }
    }

    private static class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id задачи, которую необходимо найти:");
            System.out.println(tracker.findById(id));
        }
    }

    private static class Exit extends BaseAction {

        public Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }
}

