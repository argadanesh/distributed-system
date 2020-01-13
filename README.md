# distributed-system
by Hochschule Darmstadt

This project is a simulation for a distributed system application for an autonomous car.

Assigment 1. (UDP)

There will be 4 sensor that can be read from the car.
The technology that we use for transfering the data from sensors to the car is with UDP.

sensor 1 : speed sensor (as double Km/h)
sensor 2 : traffic sensor (output as text)
sensor 3 : tank sensor (value in %)
sensor 4 : distance sensor (value in Km)

The value for the sensor will be incrased every loop so we can see the different value of each sensor.

To Test :
the sensor can send message and received by server,if fail there will error message appear.
if the sensor speed send the value 80, the server should showing the 80 km/h on the console.
if data packet experienced RTO , a new message will be prepared to send.
if sensor is disabled, the the server doesn't update the value.
When the sensor restarts, the value on the server is the same as the initial value on the sensor.

Assigment 2. (TCP)

The car can read the values from sensor by opening Browser such Internet Explorer, Firefox, Chrome, etc.
The technology that we use for reading the values from sensor is TCP.

To Test :
The car can read http request from browser and then it sends back the value that user wants (e.g: localhost:8080/speed ; 
localhost:8080/traffic ; localhost:8080/tank ; localhost:8080/distance)
if browser read the speed sensor at 80 km/h then the car also should read this value,if fail there will error message appear.


Assigment 3. (MQTT)

Car manufacturer can accessing those values such traffic sensor from car with MQTT technology that use publish and subscribe principle.
The car sends the value to the manufacturer via online broker. In our simulation there are two cars: audi and mazda. 
Mazda publishes the message with topic "car1", Audi publishes the message with topic "car2".

To Test:
The message from car should be read successfuly can be read on car producer,if fail there will error message appear.

Assigment 4. (THRIFT)

Car insurance can get datas from car manufacturers and can access data with specific function in this example data from Server suchs as Traffic Sensor,
Velocity Sensor,Distance Sensor,Tank Sensor. and there is also a function for calculate a premi, but this calculate will be done on server side.
In our Program we have 2 server for thrift, so if main server and backup server online, client only acces the main server , but if main server is offline
the client can access the backup server.
this will be done with THRIFT technology.

To Test:
If main server and backup server are online then data will come from main server
If main server down and backup server are online then data will come from backup server
If bot servers are down error message will appear.
