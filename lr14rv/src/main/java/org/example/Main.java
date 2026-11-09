package org.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("========== Задание 1. Питомец ==========");
            task1PetFile();

            System.out.println("\n========== Задание 2. 10 целых чисел ==========");
            task2Integers(scanner);

            System.out.println("\n========== Задание 3. Случайные числа ==========");
            task3RandomNumbers();

            System.out.println("\n========== Задание 4. Частота ==========");
            task4Frequency(scanner);

            System.out.println("\n========== Задание 5. Числа больше 100 ==========");
            task5GreaterThan100();

        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println("Ошибка: введено значение неверного типа.");
        } finally {
            scanner.close();
        }
    }


    private static void task1PetFile() throws IOException {
        Path petFile = Paths.get("pet.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(petFile, StandardCharsets.UTF_8)) {
            writer.write("Кличка: Барсик");
            writer.newLine();
            writer.write("Вид: кот");
            writer.newLine();
            writer.write("Возраст: 3 года");
            writer.newLine();
            writer.write("Вес: 4.5 кг");
            writer.newLine();
        }

        System.out.println("Данные о файле:");
        System.out.println("Имя файла: " + petFile.getFileName());
        System.out.println("Размер: " + Files.size(petFile) + " байт");
        System.out.println("Последнее изменение: " + Files.getLastModifiedTime(petFile));
        System.out.println("Абсолютный путь: " + petFile.toAbsolutePath());
        System.out.println("Существует: " + Files.exists(petFile));
        System.out.println("Читаемый: " + Files.isReadable(petFile));
        System.out.println("Записываемый: " + Files.isWritable(petFile));
        System.out.println("Это каталог: " + Files.isDirectory(petFile));
        System.out.println("Это обычный файл: " + Files.isRegularFile(petFile));

        System.out.println("\nСодержимое файла:");
        try (BufferedReader reader = Files.newBufferedReader(petFile, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }


    private static void task2Integers(Scanner scanner) throws IOException {
        Path f = Paths.get("f_task2.txt");

        System.out.println("Введите 10 целых чисел:");
        try (BufferedWriter writer = Files.newBufferedWriter(f, StandardCharsets.UTF_8)) {
            for (int i = 1; i <= 10; i++) {
                System.out.print("Число " + i + ": ");
                int number = scanner.nextInt();
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        }

        int perfectSquaresCount = 0;

        System.out.println("\nЧисла из файла:");
        try (BufferedReader reader = Files.newBufferedReader(f, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                System.out.println(number);

                if (isPerfectSquare(number)) {
                    perfectSquaresCount++;
                }
            }
        }

        System.out.println("Количество чисел, являющихся полными квадратами: "
                + perfectSquaresCount);
    }

    private static boolean isPerfectSquare(int number) {
        if (number < 0) {
            return false;
        }
        int root = (int) Math.round(Math.sqrt(number));
        return root * root == number;
    }

    private static void task3RandomNumbers() throws IOException {
        Path f = Paths.get("f_task3.txt");
        Path g = Paths.get("g_task3.txt");
        Path h = Paths.get("h_task3.txt");

        Random random = new Random();

        try (BufferedWriter writer = Files.newBufferedWriter(f, StandardCharsets.UTF_8)) {
            for (int i = 0; i < 20; i++) {
                int number = random.nextInt(2001) - 1000; // от -1000 до 1000
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        }

        int countG = 0;
        int countH = 0;

        try (BufferedReader reader = Files.newBufferedReader(f, StandardCharsets.UTF_8);
             BufferedWriter writerG = Files.newBufferedWriter(g, StandardCharsets.UTF_8);
             BufferedWriter writerH = Files.newBufferedWriter(h, StandardCharsets.UTF_8)) {

            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                int lastDigit = Math.abs(number) % 10;

                if (lastDigit % 2 == 0) {
                    writerG.write(Integer.toString(number));
                    writerG.newLine();
                    countG++;
                } else {
                    writerH.write(Integer.toString(number));
                    writerH.newLine();
                    countH++;
                }
            }
        }

        System.out.println("Числа, оканчивающиеся на чётную цифру, записаны в g_task3.txt: " + countG);
        System.out.println("Остальные числа записаны в h_task3.txt: " + countH);
    }

    private static void task4Frequency(Scanner scanner) throws IOException {
        Path f = Paths.get("f_task4.txt");

        System.out.println("Введите 15 вещественных значений частоты:");
        try (BufferedWriter writer = Files.newBufferedWriter(f, StandardCharsets.UTF_8)) {
            for (int i = 1; i <= 15; i++) {
                System.out.print("Значение " + i + ": ");
                double value = scanner.nextDouble();
                writer.write(Double.toString(value));
                writer.newLine();
            }
        }

        double sum = 0;
        int count = 0;

        System.out.println("\nЗначения из файла:");
        try (BufferedReader reader = Files.newBufferedReader(f, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                double value = Double.parseDouble(line.trim());
                System.out.println(value);
                sum += value;
                count++;
            }
        }

        double average = count == 0 ? 0 : sum / count;
        System.out.println("Средняя частота: " + average);
    }


    private static void task5GreaterThan100() throws IOException {
        Path f = Paths.get("f_task5.txt");
        Random random = new Random();

        try (BufferedWriter writer = Files.newBufferedWriter(f, StandardCharsets.UTF_8)) {
            for (int i = 0; i < 10; i++) {
                int number = random.nextInt(201); // от 0 до 200
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        }

        int countGreaterThan100 = 0;

        System.out.println("Числа из файла:");
        try (BufferedReader reader = Files.newBufferedReader(f, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                System.out.println(number);

                if (number > 100) {
                    countGreaterThan100++;
                }
            }
        }

        System.out.println("Количество чисел, больших 100: " + countGreaterThan100);
    }
    }

