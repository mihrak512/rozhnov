package org.example;

public class Dancer extends Artist {
    private String danceStyle;

    public Dancer(String name, int age, String genre, String danceStyle) {
        super(name, age, genre);
        this.danceStyle = danceStyle;
    }

    public String getDanceStyle() { return danceStyle; }

    @Override
    public void perform() {
        System.out.println(name + " (" + danceStyle + ") исполняет танец.");
    }

    public void choreograph() {
        System.out.println(name + " ставит хореографию в стиле " + danceStyle + ".");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("           стиль танца: " + danceStyle);
    }
}