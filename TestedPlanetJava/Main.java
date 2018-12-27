package com.company;

import java.util.logging.Logger;

public class Main {
    public static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        PlanetData newPlanet = new PlanetData(1.1);
        PlanetMassCalculator planetCalculator = new PlanetMassCalculator();
        System.out.println(planetCalculator.calc(newPlanet));



    }
}
