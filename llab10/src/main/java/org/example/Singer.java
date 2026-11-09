package org.example;

import java.util.Arrays;

public class Singer implements Performer, Awardable {
    private final String name;
    private final String genre;

    // награды храним в массиве фиксированной ёмкости + счётчик
    private final String[] awards;
    private int awardsCount;

    private static final int MAX_AWARDS = 10;

    public Singer(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.awards = new String[MAX_AWARDS];
        this.awardsCount = 0;
    }

    @Override
    public void perform() {
        System.out.println("Певец " + name + " исполняет песню в жанре " + genre);
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public String[] getAwards() {
        // возвращаем «обрезанный» массив реальных наград
        return Arrays.copyOf(awards, awardsCount);
    }

    @Override
    public void addAward(String award) {
        if (awardsCount < MAX_AWARDS) {
            awards[awardsCount++] = award;
            System.out.println("Певцу " + name + " вручена награда: " + award);
        } else {
            System.out.println("У певца " + name + " уже максимум наград.");
        }
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Singer{name='" + name + "', genre='" + genre
                + "', awards=" + Arrays.toString(getAwards()) + "}";
    }
}