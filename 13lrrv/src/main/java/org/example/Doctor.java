package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doctor {
    private final String name;
    private final String specialization;
    private final int experience;
    private int rating;
    private final List<String> patients = new ArrayList<>();

    public Doctor(String name, String specialization, int experience, int rating)
            throws InvalidDoctorDataException {

        if (name == null || name.isBlank()) {
            throw new InvalidDoctorDataException("Имя врача не может быть пустым");
        }
        if (specialization == null || specialization.isBlank()) {
            throw new InvalidDoctorDataException("Специализация не может быть пустой");
        }
        if (experience < 0) {
            throw new InvalidDoctorDataException("Опыт работы не может быть отрицательным");
        }
        if (rating < 1 || rating > 5) {
            throw new InvalidDoctorDataException("Рейтинг должен быть в диапазоне от 1 до 5");
        }

        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.rating = rating;
    }

    public void makeAppointment(String patient) throws AppointmentException {
        if (patient == null || patient.isBlank()) {
            throw new AppointmentException("Имя пациента не может быть пустым");
        }
        if (patients.contains(patient)) {
            throw new AppointmentException(
                    "Пациент '" + patient + "' уже записан к врачу " + name
            );
        }
        patients.add(patient);
    }

    public void updateRating(int newRating) throws InvalidDoctorDataException {
        if (newRating < 1 || newRating > 5) {
            throw new InvalidDoctorDataException("Рейтинг должен быть в диапазоне от 1 до 5");
        }
        this.rating = newRating;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }

    public int getRating() {
        return rating;
    }

    public List<String> getPatients() {
        return Collections.unmodifiableList(patients);
    }

    @Override
    public String toString() {
        return String.format(
                "Врач: %s | Специализация: %s | Опыт: %d лет | Рейтинг: %d | Пациенты: %s",
                name, specialization, experience, rating, patients
        );
    }
}
