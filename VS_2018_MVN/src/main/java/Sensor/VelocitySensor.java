/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import java.util.Random;

/**
 *
 * @author argadaneshwara
 */
public class VelocitySensor extends Sensor<Integer> {
    
    public VelocitySensor(String name) {
        super(name);
    }

    @Override
    public void update() {
        Random rand = new Random();
        int n = rand.nextInt(10) + 70;
        setData(n);
    }

 
    public static void main(String[] args) {
        VelocitySensor velocitySensor = new VelocitySensor("velocity");
        velocitySensor.setData(70);
        velocitySensor.start();
    }
    //test
}
