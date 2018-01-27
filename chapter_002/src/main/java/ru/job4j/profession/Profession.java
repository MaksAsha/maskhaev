package ru.job4j.profession;

public abstract class Profession extends Person {

    private String profession;

    public Profession(String personName, String profession) {
        super(personName);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }
}
