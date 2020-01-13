/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import java.text.DecimalFormat;
import mqtt.publisher.configuration.CliParameters;

/**
 *
 * @author argadaneshwara
 */
public class Car {
    private String name;
    private double distance;
    private int tank;
    private int velocity;
    private String traffic;
    private static Car instance;

    private Car(){};
    
    public static Car getInstance() {
        if (instance == null)
            instance = new Car();
        return instance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    public String print() {
        return name + ": Car => Tank: " + Car.getInstance().getTank() + " % || Distance: " + new DecimalFormat("##.##").format(Car.getInstance().getDistance()) + " KM || Velocity: " + Car.getInstance().getVelocity() + "KM/h || Traffic: " + Car.getInstance().getTraffic();
    }
    

    
}

