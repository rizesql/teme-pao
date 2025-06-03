package org.pao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Catalog extends TreeMap<Integer, List<Student>> {
    public Catalog(Comparator<Integer> comparator) {
        super(comparator);
    }

    public void add(Student student) {
        if (student.medie() < 0 || student.medie() > 10) {
            throw new IllegalStateException("Media trebuie sa fie intre 0 si 10");
        }

        this.computeIfAbsent(round(student.medie()), ArrayList::new)
                .add(student);
    }

    private static int round(float num) {
        return (int) (num + 0.5f);
    }
}
