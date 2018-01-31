package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.Date;

public class StartUI {
    private static final String ADD = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String SHOW = "4";
    private static final String FIND = "5";
    private static final String EXIT = "6";

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init(){
        boolean exit = false;

        while(!exit){

            showmenu();
            String command1 = input.ask("Введите номер команды:");
            if (ADD.equals(command1)){
                String taskname = input.ask("Введите название задачи:");
                String taskdescr = input.ask("Введите описание задачи:");
                if (!taskname.equals("")){
                    tracker.add(new Item(taskname, taskdescr, System.currentTimeMillis()));
                }
            } else if (REPLACE.equals(command1)) {
                String tasknameold = input.ask("Введите наименование задачи, которую нужно заменить:");
                String taskname = input.ask("Введите наименование задачи:");
                String taskdescr = input.ask("Введите описание задачи:");
                tracker.replace();

            } else if (EXIT.equals(command1)){
                exit = true;
            }

        }
    }

    private void showmenu(){
        System.out.println("Меню:");
        System.out.println("Нажмите 1 - добавить задачу");
        System.out.println("Нажмите 2 - изменить задачу");
        System.out.println("Нажмите 3 - удалить задачу");
        System.out.println("Нажмите 4 - просмотр всех задач");
        System.out.println("Нажмите 5 - поиск задачи по имени");
        System.out.println("Нажмите 6 - выйти из программы");
    }


    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
