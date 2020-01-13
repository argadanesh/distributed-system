/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thrift;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.*;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author Admin
 */
public class Insurance {

    public static void main(String[] args) throws TException {

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Which Manufacturer do you want to choose? (audi/mazda)");
            String antwort = sc.nextLine().toLowerCase();

            switch (antwort) {
                case "audi":
                    connectToManufacturer("141.100.42.129",6060, "141.100.42.129", 6061);
                    break;
                case "mazda":
                    connectToManufacturer("141.100.42.136",6070, "141.100.42.136", 6071);
                    break;
                default:
                    System.out.println("Error input");
                    break;
            }
        }

    }

    public static void connectToManufacturer(String ipaddress1, int port1, String ipaddress2, int port2) throws TException {
        TTransport transport = new TSocket(ipaddress1, port1);
        TTransport transportBackup = new TSocket(ipaddress2, port2);
        TProtocol protocol = new TBinaryProtocol(transport);
        ThriftInsuranceService.Client client = new ThriftInsuranceService.Client(protocol);
        TProtocol protocolBackup = new TBinaryProtocol(transportBackup);
        ThriftInsuranceService.Client clientBackup = new ThriftInsuranceService.Client(protocolBackup);

        try {
            transport.open();
        } catch (TTransportException ex) {
            System.out.println("Server 1 is down. Try to connect to Server 2...");
        }
        try {
            transportBackup.open();
        } catch (TTransportException ex) {
            System.out.println("Server 2 is down.");
        }

        if (transport.isOpen() == false && transportBackup.isOpen() == false) {
            System.out.println("Can't Connect to both Server.");

        } else if (transport.isOpen() == true && transportBackup.isOpen() == true) { //if both server are alive, use only Server 1
            transportBackup.close();
            System.out.print("Server 1 : ");
            System.out.println(client.getData());
            String brand = getBrand(client.getData());
            Double distance = getDistance(client.getData());
            System.out.println("Premi: " + client.calculate(brand, distance) + " EUR");
            transport.close();

        } else if (transportBackup.isOpen() == true && transport.isOpen() == false) {

            System.out.print("Server 2 : ");
            System.out.println(clientBackup.getData());
            String brand = getBrand(clientBackup.getData());
            Double distance = getDistance(clientBackup.getData());
            System.out.println("Premi: " + clientBackup.calculate(brand, distance) + " EUR");
            transportBackup.close();
        } else if (transport.isOpen() == true && transportBackup.isOpen() == false) {

            System.out.print("Server 1 : ");
            System.out.println(client.getData());
            String brand = getBrand(client.getData());
            Double distance = getDistance(client.getData());
            System.out.println("Premi: " + client.calculate(brand, distance) + " EUR");
            transport.close();
        }

    }
    
    public static String getBrand(String message) {
        String[] parts = message.split(":");
        String result = parts[0];   
        return result;
    }
    
    public static Double getDistance(String message) {
        String[] parts = message.split("D");
        Double result = Double.valueOf(parts[1].substring(9, 12));    
        return result;
    }
    
    
}
