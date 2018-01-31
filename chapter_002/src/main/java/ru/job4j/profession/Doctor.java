package ru.job4j.profession;

public class Doctor extends Profession {

    private String hospital;

    public Diagnose doWork(Person person) {
        return new Diagnose("Hospital " + getHospital() + ", " + getProfession() + " "
                + getPersonName() + " inspected patient " + person.getPersonName()
                + " and found out Allergy diagnose");
    }

    public Doctor(String personName, String profession, String hospital) {
        super(personName, profession);
        this.hospital = hospital;
    }

    public String getHospital() {
        return hospital;
    }


}
