package ru.job4j.tracker.start;

public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, int[] range) {

        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.valueOf(super.ask(question, range));
                invalid = false;
            } catch (NumberFormatException ep) {
                System.out.println("Please, enter validate menu item value");
            } catch (MenuOutException ep) {
                System.out.println("Please, enter validate menu item value");
            }
        } while (invalid);

        return value;
    }
}
