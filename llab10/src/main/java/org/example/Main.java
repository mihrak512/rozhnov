package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Performer.announce();

        // 3 певца
        Singer s1 = new Singer("Иван Петров", "поп");
        Singer s2 = new Singer("Мария Иванова", "рок");
        Singer s3 = new Singer("Алексей Смирнов", "джаз");

        // 2 танцора
        Dancer d1 = new Dancer("Ольга Кузнецова", "балет");
        Dancer d2 = new Dancer("Дмитрий Соколов", "хип-хоп");

        // Массив интерфейсного типа
        Performer[] performers = { s1, s2, s3, d1, d2 };

        System.out.println("\n--- Выступления ---");
        for (Performer p : performers) {
            p.perform();
            System.out.println("  Жанр: " + p.getGenre());
        }

        System.out.println("\n--- Награждение ---");
        s1.addAward("Грэмми 2024");
        s2.addAward("Лучший рок-альбом");
        s3.addAward("Золотой микрофон");
        d1.addAward("Золотая пуанта");
        d2.addAward("Лучший хип-хоп баттл");

        System.out.println("\n--- Список наград ---");
        for (Performer p : performers) {
            if (p instanceof Awardable) {
                Awardable a = (Awardable) p;
                // Выводим имя и массив наград через Arrays.toString
                System.out.println(p.getClass().getSimpleName() + " (" + p.getGenre() + "): "
                        + Arrays.toString(a.getAwards()));
            }
        }
    }
}