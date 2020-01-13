/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 *
 * @author Admin
 */
public class ThriftMultithreadServer extends Thread { //Server
    
    public void run(){
        try{
        ThriftServer thriftServer = new ThriftServer();
        ThriftInsuranceService.Processor processor = new ThriftInsuranceService.Processor(thriftServer);
        TServerTransport serverTransport = new TServerSocket(6060);
        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor)); //thread
        System.out.println("Starting Thrift Server");
        server.serve();}
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
