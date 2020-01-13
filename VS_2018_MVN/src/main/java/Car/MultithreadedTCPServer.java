/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

/**
 *
 * @author argadaneshwara
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author argadaneshwara
 */
public class MultithreadedTCPServer extends Thread {

    @Override
    public void run() {
        try {
            int port = 8000;
            ServerSocket listenSocket = new ServerSocket(port);
            System.out.println("Multithreaded Server starts on Port " + port);
            while (true) {
                Socket client = listenSocket.accept();
                System.out.println("Connection with: "
                        + // Output connection
                        client.getRemoteSocketAddress());   // (Client) address
                new EchoService(client).start();
            }

        } catch (IOException ex) {
            Logger.getLogger(MultithreadedTCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}