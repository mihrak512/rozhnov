package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Singer singer = new Singer("Анна", 28, "Поп", "Сопрано");
        Dancer dancer = new Dancer("Игорь", 24, "Современный", "Хип-хоп");

        System.out.println("=== Информация об артистах ===");
        singer.displayInfo();
        System.out.println();
        dancer.displayInfo();
        System.out.println();

        System.out.println("=== Выступления (полиморфизм) ===");
        Artist[] artists = { singer, dancer };
        for (Artist a : artists) {
            a.perform();
        }
        System.out.println();

        System.out.println("=== Уникальные методы ===");
        singer.singSong();
        dancer.choreograph();
    }
}
