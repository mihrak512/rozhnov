package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
        Map<String, Professional> map = new HashMap<String, Professional>();

        map.put("Иванов", new Doctor("Иванов", 1, 15, "Кардиология"));
        map.put("Петрова", new Doctor("Петрова", 2, 8, "Неврология"));
        map.put("Сидоров", new Doctor("Сидоров", 3, 20, "Хирургия"));

        map.put("Кузнецов", new Lawyer("Кузнецов", 4, 12, 45));
        map.put("Смирнова", new Lawyer("Смирнова", 5, 7, 23));
        map.put("Волков", new Lawyer("Волков", 6, 18, 60));

        map.put("Морозова", new Teacher("Морозова", 7, 10, 120));
        map.put("Никитин", new Teacher("Никитин", 8, 25, 200));

        System.out.println("=== Задание 1. Все специалисты ===");
        for (Map.Entry<String, Professional> entry : map.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + " -> Значение: " + entry.getValue());
        }
    }

    public static void task2() {
        List<Club> clubs = new ArrayList<Club>();
        clubs.add(new Club(1, "Динамо", "Футбол", 1, Arrays.asList(4, 5, 3)));
        clubs.add(new Club(2, "Шахтёр", "Футбол", 1, Arrays.asList(2, 2, 3)));
        clubs.add(new Club(3, "Цмоки", "Баскетбол", 2, Arrays.asList(5, 5, 4)));
        clubs.add(new Club(4, "Берёза", "Волейбол", 2, Arrays.asList(3, 3, 3)));
        clubs.add(new Club(5, "Юность", "Хоккей", 3, Arrays.asList(2, 1, 2)));
        clubs.add(new Club(6, "Неман", "Хоккей", 3, Arrays.asList(4, 4, 5)));
        clubs.add(new Club(7, "Атлант", "Футбол", 1, Arrays.asList(5, 4, 4)));


        Iterator<Club> it = clubs.iterator();
        while (it.hasNext()) {
            Club c = it.next();
            if (c.getAverageRating() < 3) {
                it.remove();
            }
        }


        for (int i = 0; i < clubs.size(); i++) {
            Club c = clubs.get(i);
            if (c.getAverageRating() >= 4) {
                c.setDivision(c.getDivision() + 1);
            }
        }


        System.out.println("=== Задание 2. Клубы в дивизионе 2 ===");
        printClubs(clubs, 2);


        Collections.sort(clubs, new Comparator<Club>() {
            public int compare(Club a, Club b) {
                if (a.getAverageRating() > b.getAverageRating()) return -1;
                if (a.getAverageRating() < b.getAverageRating()) return 1;
                return a.getName().compareTo(b.getName());
            }
        });

        System.out.println();
        System.out.println("=== Задание 2. Отсортированный список (ID, название, средний рейтинг) ===");
        for (int i = 0; i < clubs.size(); i++) {
            Club c = clubs.get(i);
            System.out.println("ID=" + c.getId()
                    + ", название=" + c.getName()
                    + ", средний рейтинг=" + c.getAverageRating());
        }
    }


    public static void printClubs(List<Club> clubs, int division) {
        boolean found = false;
        for (int i = 0; i < clubs.size(); i++) {
            Club c = clubs.get(i);
            if (c.getDivision() == division) {
                System.out.println(c);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Клубов в дивизионе " + division + " нет.");
        }
    }
}


