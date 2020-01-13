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
public class TankSensor extends Sensor<Integer> {
    public TankSensor(String name) {
        super(name);
    }

    @Override
    public void update() {
        if (getData() != 0) {
            setData(getData() - 1);
        }
    }


    public static void main(String[] args) {
        TankSensor tankSensor = new TankSensor("tank");
        tankSensor.setData(100);
        tankSensor.start();
    }
    
}
