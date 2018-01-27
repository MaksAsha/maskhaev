package ru.job4j.profession;

public class Diagnose {

    private String diagnose;

    public Diagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    @Override
    public String toString() {
        return diagnose;
    }
}
