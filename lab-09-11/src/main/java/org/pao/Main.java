package org.pao;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        var catalog = new Catalog(Comparator.reverseOrder());

        catalog.add(new Student("Ana", 9.4f));
        catalog.add(new Student("Bogdan", 7.8f));
        catalog.add(new Student("Cristina", 8.6f));
        catalog.add(new Student("Daniel", 6.2f));
        catalog.add(new Student("Elena", 9.7f));
        catalog.add(new Student("Florin", 5.5f));
        catalog.add(new Student("Gabriela", 10.0f));
        catalog.add(new Student("Horatiu", 3.3f));
        catalog.add(new Student("Irina", 7.5f));
        catalog.add(new Student("Ioan", 8.1f));

        for (var category : catalog.entrySet()) {
            System.out.println("Medie: " + category.getKey());

            category.getValue().stream().sorted(Comparator.comparing(Student::nume)).forEach(s -> System.out.println("\t - " + s.nume()));
        }
    }
}