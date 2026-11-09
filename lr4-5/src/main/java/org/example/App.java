package org.example;

public class App 
{
    public static void main( String[] args )
    {

        System.out.println(" Задание 1. Круглый стол ");
        RoundTable table = new RoundTable(1.2, "Дуб");
        System.out.println(table);
        System.out.printf("Площадь стола: %.4f м²%n%n", table.area());

        System.out.println("Задание 2. Планеты ");
        Planet[] planets = {
                new Planet("Меркурий", 4879,   57.9),
                new Planet("Венера",   12104,  108.2),
                new Planet("Земля",    12742,  149.6),
                new Planet("Марс",     6779,   227.9),
                new Planet("Юпитер",   139820, 778.6),
                new Planet("Сатурн",   116460, 1433.5)
        };

        Planet maxDiameter = planets[0];
        Planet maxDistance = planets[0];

        for (Planet p : planets) {
            if (p.getDiameter() > maxDiameter.getDiameter()) {
                maxDiameter = p;
            }
            if (p.getDistanceFromSun() > maxDistance.getDistanceFromSun()) {
                maxDistance = p;
            }
        }

        System.out.println("Планета с максимальным диаметром:     " + maxDiameter);
        System.out.println("Планета с максимальным расстоянием:    " + maxDistance);
        System.out.println();

        System.out.println("Задание 3. Сотрудники с PHD ");
        Employee[] employees = {
                new Employee("Иван Иванов",   Education.BACHELOR),
                new Employee("Пётр Петров",   Education.PHD),
                new Employee("Анна Сидорова", Education.MASTER),
                new Employee("Олег Смирнов",  Education.PHD),
                new Employee("Мария Кузнецова", Education.SCHOOL)
        };

        for (Employee e : employees) {
            if (e.getEducation() == Education.PHD) {
                System.out.println(e);
            }
        }
    }
}

