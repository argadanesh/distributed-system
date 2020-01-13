/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

/**
 *
 * @author argadaneshwara
 */
public class DistanceSensor extends Sensor<Double> {
    public DistanceSensor(String name) {
        super(name);
    }

    @Override
    public void update() {
        setData(getData()+ 1);
    }


    public static void main(String[] args) {
        DistanceSensor distanceSensor = new DistanceSensor("distance");
        distanceSensor.setData(50.00);
        distanceSensor.start();
    }
    
}
