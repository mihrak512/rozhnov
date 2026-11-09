package org.example;

public class Singer extends Artist {
    private String voiceType;

    public Singer(String name, int age, String genre, String voiceType) {
        super(name, age, genre);
        this.voiceType = voiceType;
    }

    public String getVoiceType() { return voiceType; }

    @Override
    public void perform() {
        System.out.println(name + " (" + voiceType + ") поет песню.");
    }

    public void singSong() {
        System.out.println(name + " исполняет песню в жанре " + genre + ".");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("           тип голоса: " + voiceType);
    }
}