package org.example;

public interface Performer {
    void perform();
    String getGenre();

    static void announce() {
        System.out.println("=== Начинаем концерт! ===");
    }
}
