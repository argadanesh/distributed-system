/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.DecimalFormat;

/**
 *
 * @author argadaneshwara
 */
public class UDPServer extends Thread {
    private DatagramSocket socket;

    @Override
    public void run() {
        //super.run();
        try {

            socket = new DatagramSocket(1234);

            while(true) {
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String receiver = new String(buffer, 0 , packet.getLength());
                String[] parts = receiver.split("-");
                String part1 = parts[0];
                String part2 = parts[1];

                switch (part1) {
                    case "tank" : Car.getInstance().setTank(Integer.valueOf(part2));
                        break;
                    case "distance" : Car.getInstance().setDistance(Double.valueOf(part2));
                        break;
                    case "velocity" : Car.getInstance().setVelocity(Integer.valueOf(part2));
                        break;
                    
                    case "traffic" : Car.getInstance().setTraffic(part2);
                        break;
                }

                System.out.println(Car.getInstance().print());
             

            }

        } catch (SocketException e) {
            System.out.println("Socket Exception" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOEXception " + e.getMessage());
        }
    }
    
}
