package org.example;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Train {
    private String destination;
    private String trainNumber;
    private String departureTime;

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("HH:mm");

    public Train(String destination, String trainNumber, String departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Сдвигает время отправления на указанное число минут.
     * @param minutes количество минут задержки (может быть отрицательным)
     */
    public void isDelayed(int minutes) {
        try {
            LocalTime time = LocalTime.parse(departureTime, TIME_FORMAT);
            time = time.plusMinutes(minutes);
            this.departureTime = time.format(TIME_FORMAT);
        } catch (DateTimeParseException e) {
            System.err.println("Некорректный формат времени: " + departureTime);
        }
    }

    @Override
    public String toString() {
        return String.format("Поезд №%s до станции «%s», отправление: %s",
                trainNumber, destination, departureTime);
    }
}