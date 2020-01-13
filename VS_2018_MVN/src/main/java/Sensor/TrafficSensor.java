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
public class TrafficSensor extends Sensor<String> {

    public TrafficSensor(String name) {
        super(name);
    }

    @Override
    public void update() {
        Random rand = new Random();
        int n = rand.nextInt(3);
        Traffic traffic = null;
        switch(n) {
            case 0: traffic = Traffic.Free;
            break;
            case 1: traffic = Traffic.Moderate;
            break;
            case 2: traffic = Traffic.High;
            break;
            case 3: traffic = Traffic.Jam;
            break;
        }
        setData(traffic.name());
    }
        
    
    public static void main(String[] args) {
        
        TrafficSensor traffic = new TrafficSensor("traffic");
        traffic.setData(Traffic.Free.name());
        traffic.start();
        
    }
   
    
    
    
    
}
