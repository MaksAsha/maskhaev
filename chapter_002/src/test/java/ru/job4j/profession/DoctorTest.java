package ru.job4j.profession;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoctorTest {

    Doctor doctor;
    Person patient;
    Diagnose expected;

    @Before
    public void setUp() {
        doctor = new Doctor("Maksim", "Allergolog", "MedClinic");
        patient = new Person("Leonid");
        expected = new Diagnose("Hospital MedClinic, Allergolog Maksim inspected" +
                " patient Leonid and found out Allergy diagnose");
        String ss = expected.toString();
    }

    @Test
    public void doWork() throws Exception {
        Diagnose result = doctor.doWork(patient);
        Assert.assertThat(result, Matchers.is(expected));
    }
}