package com.company;

import java.lang.annotation.Annotation;

public class PlanetMassCalculator {

    /**
     * @param planetData some obj with information of planet
     * @return mass value of planet
     */
    @UselessAnnotation
    public double calc(PlanetData planetData){
        try {
            Class<PlanetData> clazz = PlanetData.class;
            Annotation annotation1 = clazz.getAnnotation(Planet.class);
            if(annotation1 instanceof Planet){
                Planet planet = (Planet) annotation1;
                return (4 / 3) * Math.PI * Math.pow(planetData.getRadius(), 3) * planet.density();
            }
        } catch (Throwable exc){
            exc.printStackTrace();
        }
        System.out.println("Something wrong");
        return 0.0;
    }
}
