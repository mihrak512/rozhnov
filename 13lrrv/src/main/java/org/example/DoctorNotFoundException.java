package org.example;


public class DoctorNotFoundException extends Exception {
    private final String doctorName;

    public DoctorNotFoundException(String doctorName) {
        super("Врач не найден: " + doctorName);
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }
}
