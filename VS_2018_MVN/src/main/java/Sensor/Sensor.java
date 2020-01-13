/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

/**
 *
 * @author argadaneshwara
 */
public abstract class Sensor<T> {
    private static String name;
    private T data;

    public Sensor(String name) {
        this.name = name;
    }

    public static String getName() {
        return name;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void update() {
        
    }

    public String message() {
        return getName() + "-" + getData();
    }

    public void start() {
        try {
            InetAddress inetAddress = InetAddress.getByName("localhost");
            DatagramSocket socket = new DatagramSocket();
            System.out.println("Sensor " + getName() + " is started...");
            do {

                byte[] buffer = message().getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, inetAddress, 1234);
                socket.send(packet);
                Thread.sleep(1000);
                update();
                System.out.println("Sending data -- Value: " + String.valueOf(data));
            } while (true);

        } catch (SocketTimeoutException e) {
            System.out.println("Socket Timeout!");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
