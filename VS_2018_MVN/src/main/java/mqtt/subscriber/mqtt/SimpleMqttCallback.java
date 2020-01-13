/*
 Copyright (c) 2017, Michael Bredel, H-DA
 ALL RIGHTS RESERVED.
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 
 Neither the name of the H-DA and Michael Bredel
 nor the names of its contributors may be used to endorse or promote
 products derived from this software without specific prior written
 permission.
 */
package mqtt.subscriber.mqtt;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * A simple MQTT callback implementation that
 * logs (prints) information if the connection to the
 * broker got lost, when a message arrived, and
 * when the delivery was completed, i.e., when
 * a delivery token arrived.
 *
 * @author Michael Bredel
 */
 
public class SimpleMqttCallback implements MqttCallback {
 
    /** The logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMqttCallback.class);
    private Timestamp timestamp;
 
 
    @Override
    public void connectionLost(Throwable throwable) {
        LOGGER.error("Connection to MQTT broker lost!");
    }
 
    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        ManufacturerEntity.getEntity().setMessage(new String(mqttMessage.getPayload()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
       // System.out.println(dateFormat.format(cal.getTime()));
       
        System.out.println("Message received: "+ new String(mqttMessage.getPayload()) );
       File log = new File("Manufacturer.txt");
       try{
           if(!log.exists())
           {
               log.createNewFile();
           }
           FileWriter fileWriter = new FileWriter(log,true);
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           bufferedWriter.write(dateFormat.format(cal.getTime())+ "\n" +  new String(mqttMessage.getPayload()) + "\n\n");
           bufferedWriter.close();
           
       }catch(IOException e)
       {
           System.out.println("Error "+ e);
       }
     
    }
 
    @Override
    public void deliveryComplete(IMqttDeliveryToken mqttDeliveryToken) {
        try {
            LOGGER.info("Delivery completed: "+ mqttDeliveryToken.getMessage() );
        } catch (MqttException e) {
            LOGGER.error("Failed to get delivery token message: " + e.getMessage());
        }
    }
}