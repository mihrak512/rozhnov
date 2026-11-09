package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clinic {
    private final List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public Doctor findDoctorByName(String name) throws DoctorNotFoundException {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        throw new DoctorNotFoundException(name);
    }

    public void makeAppointment(String doctorName, String patient)
            throws DoctorNotFoundException, AppointmentException {

        Doctor doctor = findDoctorByName(doctorName);
        doctor.makeAppointment(patient);
    }

    public void updateRating(String doctorName, int newRating)
            throws DoctorNotFoundException, InvalidDoctorDataException {

        Doctor doctor = findDoctorByName(doctorName);
        doctor.updateRating(newRating);
    }

    public List<Doctor> getDoctors() {
        return Collections.unmodifiableList(doctors);
    }
}
