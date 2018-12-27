package com.company;

@Planet(name ="Earth", density = 5.51)
/**
 * @param radius is radius value of planet
 */

public class PlanetData {

    @Deprecated
    private double radius;

    public PlanetData(double radius){
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "PlanetData{" +
                "radius=" + radius +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
