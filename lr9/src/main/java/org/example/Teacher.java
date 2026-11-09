package org.example;

public class Teacher extends Professional {
    private int students;

    public Teacher(String name, int id, int experience, int students) {
        super(name, id, experience);
        this.students = students;
    }

    public int getStudents() { return students; }

    public String toString() {
        return "Teacher{name='" + getName() + "', id=" + getId()
                + ", experience=" + getExperience()
                + ", students=" + students + "}";
    }
}
