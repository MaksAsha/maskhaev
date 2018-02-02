package ru.job4j.tracker.start;

public class StubInput implements Input {

    private final String[] value;
    private int position = 0;

    public StubInput(String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[position++];
    }

    @Override
    public int ask(String question, int[] range) {
        return -1;
    }
}
