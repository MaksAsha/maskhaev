package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

public class StartUI {
    private static final String ADD = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String SHOW = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String FIND_BY_ID = "6";
    private static final String EXIT = "7";

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;

        while (!exit) {

            showmenu();
            String command = input.ask("Введите номер команды:");
            if (ADD.equals(command)) {
                String taskname = input.ask("Введите наименование задачи:");
                String taskdescr = input.ask("Введите описание задачи:");
                if (!taskname.equals("")) {
                    System.out.println(
                            "Задача:"
                                    + tracker.add(new Item(taskname, taskdescr, System.currentTimeMillis()))
                                    + " добавлена"
                    );
                }
            } else if (REPLACE.equals(command)) {
                String id = input.ask("Введите id задачи, которую нужно заменить:");
                String taskname = input.ask("Введите наименование задачи:");
                String taskdescr = input.ask("Введите описание задачи:");
                tracker.replace(id, new Item(taskname, taskdescr, System.currentTimeMillis()));
            } else if (DELETE.equals(command)) {
                String id = input.ask("Введите id задачи, которую необходимо удалить:");
                tracker.delete(id);
            } else if (SHOW.equals(command)) {
                System.out.println("Список задач:");
                for (Item item : tracker.findAll()) {
                    System.out.println(item);
                }
            } else if (FIND_BY_NAME.equals(command)) {
                String taskname = input.ask("Введите наименование задачи, которую необходимо найти:");
                System.out.println("Список задач:");
                for (Item item : tracker.findByName(taskname)) {
                    System.out.println(item);
                }
            } else if (FIND_BY_ID.equals(command)) {
                String id = input.ask("Введите наименование задачи, которую необходимо найти:");
                System.out.println(tracker.findById(id));
            } else if (EXIT.equals(command)) {
                exit = true;
            }
        }
    }

    private void showmenu() {
        System.out.println("");
        System.out.println("Меню:");
        System.out.println("Нажмите 1 - добавить задачу");
        System.out.println("Нажмите 2 - изменить задачу");
        System.out.println("Нажмите 3 - удалить задачу");
        System.out.println("Нажмите 4 - просмотр всех задач");
        System.out.println("Нажмите 5 - поиск задачи по имени");
        System.out.println("Нажмите 6 - поиск задачи по id");
        System.out.println("Нажмите 7 - выйти из программы");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
