package org.example;

public class Artist {
    protected String name;
    protected int age;
    protected String genre;

    public Artist(String name, int age, String genre) {
        this.name = name;
        this.age = age;
        this.genre = genre;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGenre() { return genre; }

    public void perform() {
        System.out.println(name + " выступает на сцене.");
    }

    public void displayInfo() {
        System.out.printf("%-10s | возраст: %2d | жанр: %s%n",
                name, age, genre);
    }

    @Override
    public String toString() {
        return String.format("Artist{name='%s', age=%d, genre='%s'}",
                name, age, genre);
    }
}