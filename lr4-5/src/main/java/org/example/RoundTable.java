package org.example;
public class RoundTable {
    private double diameter;
    private String material;

    public RoundTable(double diameter, String material) {
        this.diameter = diameter;
        this.material = material;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double area() {
        double radius = diameter / 2.0;
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "RoundTable{diameter=" + diameter +
                ", material='" + material + '\'' + '}';
    }
}