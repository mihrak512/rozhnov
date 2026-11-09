package org.example;

public class Employee {
    private String name;
    private Education education;

    public Employee(String name, Education education) {
        this.name = name;
        this.education = education;
    }

    public String getName() { return name; }
    public Education getEducation() { return education; }

    @Override
    public String toString() {
        return name + " (" + education + ")";
    }
}