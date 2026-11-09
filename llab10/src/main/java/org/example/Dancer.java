package org.example;

import java.util.Arrays;

public class Dancer implements Performer, Awardable {
    private final String name;
    private final String style;

    private final String[] awards;
    private int awardsCount;

    private static final int MAX_AWARDS = 10;

    public Dancer(String name, String style) {
        this.name = name;
        this.style = style;
        this.awards = new String[MAX_AWARDS];
        this.awardsCount = 0;
    }

    @Override
    public void perform() {
        System.out.println("Танцор " + name + " танцует в стиле " + style);
    }

    @Override
    public String getGenre() {
        return style;
    }

    @Override
    public String[] getAwards() {
        return Arrays.copyOf(awards, awardsCount);
    }

    @Override
    public void addAward(String award) {
        if (awardsCount < MAX_AWARDS) {
            awards[awardsCount++] = award;
            System.out.println("Танцору " + name + " вручена награда: " + award);
        } else {
            System.out.println("У танцора " + name + " уже максимум наград.");
        }
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Dancer{name='" + name + "', style='" + style
                + "', awards=" + Arrays.toString(getAwards()) + "}";
    }
}