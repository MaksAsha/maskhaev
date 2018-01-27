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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnose)) return false;

        Diagnose diagnose1 = (Diagnose) o;

        return diagnose != null ? diagnose.equals(diagnose1.diagnose) : diagnose1.diagnose == null;
    }

    @Override
    public int hashCode() {
        return diagnose != null ? diagnose.hashCode() : 0;
    }

}
