package org.pao;

import org.pao.exceptions.MaxWordNotFound;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public class Pb2 {
    public static void main(String[] args) {
        System.out.println("Cel mai lung cuvant: " + longestWord(Path.of("src/test/resources/max-word.txt")));

        writeTo(Path.of("src/main/java/org/pao/Pb2.java"), Path.of("src/test/resources/average.txt"));
        System.out.println(Arrays.toString(writeTo(Path.of("src/main/java/org/pao/Client.java"))));
    }

    private static String longestWord(Path file) {
        try (var reader = Files.newBufferedReader(file)) {
            return reader.lines()
                    .flatMap(l -> Arrays.stream(l.strip().split(" ")))
                    .max(Comparator.comparingInt(String::length))
                    .orElseThrow(MaxWordNotFound::new);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeTo(Path src, Path file) {
        try (var reader = Files.newBufferedReader(src); var writer = Files.newBufferedWriter(file)) {
            reader.lines().forEach(l -> {
                try {
                    writer.write(l + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] writeTo(Path src) {
        try (var reader = Files.newBufferedReader(src)) {
            return reader.lines()
                    .filter(l -> !l.isBlank())
                    .toArray(String[]::new);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
