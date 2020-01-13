/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thrift;

import Car.Car;
import mqtt.subscriber.mqtt.ManufacturerEntity;
import org.apache.thrift.TException;

/**
 *
 * @author Admin
 */
public class ThriftServer implements ThriftInsuranceService.Iface  {

    @Override
    public String getData() throws TException {
           String result = ManufacturerEntity.getEntity().getMessage();
           if (result == null) {
               return "";
           }
            return result;
    }

    @Override
    public double calculate(String herstellerName, double distance) throws TException {
//        if (herstellerName == "" && distance == 0.0) {
//            return 0.0;
//        }
        Double result = 0.0;
        switch(herstellerName) {
            case "Mazda":
                if (distance < 100) {
                    result = 950.0;
                } else {
                    result = 1500.0;
                }
                break;
            case "Audi":
                if (distance < 100) {
                    result = 110.0;
                } else {
                    result = 120.0;
                }
                break;
        }
        return result;
    }

    

   
 
}
