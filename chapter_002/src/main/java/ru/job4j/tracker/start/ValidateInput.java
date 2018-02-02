package ru.job4j.tracker.start;

public class ValidateInput implements Input {

    final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {

        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.valueOf(input.ask(question, range));
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
