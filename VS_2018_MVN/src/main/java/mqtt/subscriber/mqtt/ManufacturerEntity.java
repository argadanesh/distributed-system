/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt.subscriber.mqtt;

/**
 *
 * @author argadaneshwara
 */
public class ManufacturerEntity {
    private String message;
    private static ManufacturerEntity entity = new ManufacturerEntity();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ManufacturerEntity getEntity() {
        return entity;
    }

    public static void setEntity(ManufacturerEntity eintity) {
        ManufacturerEntity.entity = eintity;
    }
    
    
    
}
