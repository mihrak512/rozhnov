package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Bookstore s1 = new Bookstore("Читай-город",   12000, 15);
        Bookstore s2 = new Bookstore("Буквоед",        8500, 10);
        Bookstore s3 = new Bookstore("Дом книги",     15300, 20);
        Bookstore s4 = new Bookstore("Москва",         6400,  8);

        System.out.println("=== Список магазинов ===");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        System.out.println("\n=== Общая статистика ===");
        System.out.println("Всего магазинов:        " + Bookstore.getTotalStores());
        System.out.println("Всего книг:             " + Bookstore.getTotalBooks());
        System.out.printf("Среднее книг на магазин: %.2f%n", Bookstore.getAverageBooks());
    }
}
