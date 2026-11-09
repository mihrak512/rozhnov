package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Clinic clinic = new Clinic();

        System.out.println("=== Создание врачей ===");
        try {
            Doctor doctor1 = new Doctor(
                    "Иванов Иван Иванович",
                    "Терапевт",
                    10,
                    4
            );

            Doctor doctor2 = new Doctor(
                    "Петрова Анна Сергеевна",
                    "Кардиолог",
                    5,
                    5
            );

            clinic.addDoctor(doctor1);
            clinic.addDoctor(doctor2);

            System.out.println("Врачи успешно добавлены.");
        } catch (InvalidDoctorDataException e) {
            System.out.println("Ошибка создания врача: " + e.getMessage());
        }

        System.out.println("\n=== Список врачей ===");
        for (Doctor doctor : clinic.getDoctors()) {
            System.out.println(doctor);
        }

        System.out.println("\n=== Запись пациента ===");
        try {
            clinic.makeAppointment("Иванов Иван Иванович", "Сидоров Пётр");
            System.out.println("Пациент успешно записан.");
        } catch (DoctorNotFoundException | AppointmentException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        System.out.println("\n=== Повторная запись того же пациента ===");
        try {
            clinic.makeAppointment("Иванов Иван Иванович", "Сидоров Пётр");
        } catch (DoctorNotFoundException | AppointmentException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        System.out.println("\n=== Обновление рейтинга ===");
        try {
            clinic.updateRating("Петрова Анна Сергеевна", 5);
            System.out.println("Рейтинг обновлён.");
        } catch (DoctorNotFoundException | InvalidDoctorDataException e) {
            System.out.println("Ошибка обновления рейтинга: " + e.getMessage());
        }

        System.out.println("\n=== Поиск несуществующего врача ===");
        try {
            clinic.findDoctorByName("Неизвестный Врач");
        } catch (DoctorNotFoundException e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        System.out.println("\n=== Некорректный рейтинг ===");
        try {
            clinic.updateRating("Петрова Анна Сергеевна", 7);
        } catch (DoctorNotFoundException | InvalidDoctorDataException e) {
            System.out.println("Ошибка обновления рейтинга: " + e.getMessage());
        }

        System.out.println("\n=== Некорректные данные при создании врача ===");
        try {
            new Doctor("", "Хирург", 3, 4);
        } catch (InvalidDoctorDataException e) {
            System.out.println("Ошибка создания врача: " + e.getMessage());
        }

        System.out.println("\n=== Итоговый список врачей ===");
        for (Doctor doctor : clinic.getDoctors()) {
            System.out.println(doctor);
        }
    }
    }

