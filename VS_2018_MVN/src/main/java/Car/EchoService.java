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
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.text.DecimalFormat;
public class EchoService extends Thread{
    Socket client;
    EchoService(Socket client){this.client = client;}

  @Override
    public void run (){
        String line;
        BufferedReader fromClient;
        DataOutputStream toClient;
        boolean verbunden = true;
        
        System.out.println("Thread started: "+this); // Display Thread-ID
        try{
            fromClient = new BufferedReader              // Datastream FROM Client
            (new InputStreamReader(client.getInputStream()));
            toClient = new DataOutputStream (client.getOutputStream()); // TO Client

            while(verbunden){     // repeat as long as connection exists
                line = fromClient.readLine();             // Read Request
                //System.out.println("Received: "+ line);
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println("\r\n");
                out.print(
                        "<!DOCTYPE html>" +
                                "<html lang=\"en\" dir=\"ltr\">" +
                                "<head>" +
                                "<meta charset=\"utf-8\">" +
                                "<title>AUTO</title>" +
                                "<style>" +
                                "h1 {text-align: center;}"+
                                "</style>" +
                                "</head>" +
                                "<body>" +
                                "<br><h1>"+Car.getInstance().getName()+"</h1><br>"     );


                if(line.toLowerCase().contains("distance")) {
                    out.print("<h1>Distance => "+new DecimalFormat("##.##").format(Car.getInstance().getDistance())+" KM</h1>");
                } else if (line.toLowerCase().contains("tank")) {
                    out.print("<h1>Tank => "+Car.getInstance().getTank()+" %</h1>");
                } else if (line.toLowerCase().contains("traffic")) {
                    out.print("<h1>Traffic =>"+Car.getInstance().getTraffic()+"</h1>");
                } else if (line.toLowerCase().contains("velocity")) {
                    out.print("<h1>Velocity => "+Car.getInstance().getTank()+" KM/H</h1>");
                } else {
                    out.print("<h1>"+Car.getInstance().print()+"</h1>");
                }

                out.print("</body></html>");
                out.flush();
                out.close();
                
                if (line.equals(".")) verbunden = false;   // Break Conneciton?
                else toClient.writeBytes(line.toUpperCase()+'\n'); // Response
            }
            fromClient.close();
            toClient.close();
            client.close(); // End
            System.out.println("Thread ended: "+this);
        }catch (Exception e){System.out.println(e);}
    }
}
