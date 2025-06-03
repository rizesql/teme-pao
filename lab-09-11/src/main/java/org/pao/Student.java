package org.pao;

public class Student {
    private final String nume;
    private final float medie;

    public Student(String nume, float medie) {
        this.nume = nume;
        this.medie = medie;
    }

    public String nume() {
        return nume;
    }

    public float medie() {
        return medie;
    }
}
