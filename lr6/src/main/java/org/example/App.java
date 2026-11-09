package org.example;

import java.util.Scanner;
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите пункт назначения: ");
        String destination = scanner.nextLine();

        System.out.print("Введите номер поезда: ");
        String trainNumber = scanner.nextLine();

        System.out.print("Введите время отправления (HH:mm): ");
        String departureTime = scanner.nextLine();

        Train train = new Train(destination, trainNumber, departureTime);

        System.out.println("\nДо задержки:");
        System.out.println(train);

        train.isDelayed(30);

        System.out.println("\nПосле задержки на 30 минут:");
        System.out.println(train);

        scanner.close();
    }
}
