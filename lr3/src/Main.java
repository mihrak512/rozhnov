import java.util.*;
import java.util.regex.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку для trim: ");
        String strTrim = scanner.nextLine();
        System.out.println("Результат trim: '" + strTrim.trim() + "'");


        System.out.print("\nВведите строку для поиска позиций 'a': ");
        String strA = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) == 'a') {
                count++;
            }
        }
        int[] positions = new int[count];
        int index = 0;
        for (int i = 0; i < strA.length(); i++) {
            if (strA.charAt(i) == 'a') {
                positions[index] = i;
                index++;
            }
        }

        System.out.println("Позиции символа 'a': " + Arrays.toString(positions));


            System.out.println("\n Отчёт о зарплатах");
            Employee[] employees = {
                    new Employee("Иванов И.И.", 45000.5),
                    new Employee("Петров П.П.", 52000.756),
                    new Employee("Сидоров С.С.", 38500.0)
            };
            Report.generateReport(employees);

            System.out.print("\nВведите строку для поиска слов (шаблон ap?le): ");
            String strPattern = scanner.nextLine();
            Matcher matcher = Pattern.compile("\\bap[^\\s]{1,3}le\\b").matcher(strPattern);
            System.out.println("Найденные слова:");
            boolean found = false;
            while (matcher.find()) {
                System.out.println("  " + matcher.group());
                found = true;
            }
            if (!found) {
                System.out.println("  (ничего не найдено)");
            }

            scanner.close();
        }
    }