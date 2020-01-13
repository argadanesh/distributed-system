/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import java.io.IOException;
import mqtt.publisher.mqtt.PublisherThread;

/**
 *
 * @author argadaneshwara
 */
public class CarProgram {
    public static void main(String[] args) throws InterruptedException, IOException {
    System.out.println("[Server is started]");
    UDPServer carUDPServer = new UDPServer();
    MultithreadedTCPServer carTCPServer = new MultithreadedTCPServer();
    PublisherThread carPublisher = new PublisherThread();   
    Car.getInstance().setName("Mazda");
    carUDPServer.start();
    carTCPServer.start();
    carPublisher.start();
    
    }
    
}