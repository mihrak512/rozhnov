package org.example;

import java.util.ArrayList;
import java.util.List;

public class Club {
    private int id;
    private String name;
    private String sport;
    private int division;
    private List<Integer> matchRatings;

    public Club(int id, String name, String sport, int division, List<Integer> matchRatings) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.division = division;
        this.matchRatings = new ArrayList<Integer>(matchRatings);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSport() { return sport; }
    public int getDivision() { return division; }
    public void setDivision(int division) { this.division = division; }
    public List<Integer> getMatchRatings() { return matchRatings; }

    public double getAverageRating() {
        if (matchRatings.size() == 0) return 0.0;
        int sum = 0;
        for (int i = 0; i < matchRatings.size(); i++) {
            sum = sum + matchRatings.get(i);
        }
        return (double) sum / matchRatings.size();
    }

    public String toString() {
        return "Club{id=" + id + ", name='" + name + "', sport='" + sport
                + "', division=" + division + ", avg=" + getAverageRating() + "}";
    }
}
