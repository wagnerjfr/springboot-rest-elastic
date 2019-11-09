# SpringBoot REST Elasticsearch/Kibana Example

This project was developed using SpringBoot [Spring Initializr](start.spring.io) and the following dependencies were selected:
1. Web
2. Elasticsearch (https://www.elastic.co/)
3. Actuator (https://spring.io/guides/gs/actuator-service/)
4. Lombok (https://projectlombok.org/)

The following sections details each step to get the project up and running.

## 1. Clone the project and build it
Run the command below in your terminal to clone the project:
```
git clone https://github.com/wagnerjfr/sprinboot-rest-elastic.git
```
Go inside project folder and build the project running:
```
cd sprinboot-rest-elastic
mvn clean package -DskipTests
```
## 2. Start Elasticsearch and Kibana using Docker Compose

Execute the command:
```
docker-compose up -d
```

It will take some seconds. We can follow its status by running:
```
docker-compose ps
```

The containers are ready to be used when the below output log is printed with **State** ```Up (healthy)```:
```console
    Name                   Command                  State                           Ports
--------------------------------------------------------------------------------------------------------------
elasticsearch   /usr/local/bin/docker-entr ...   Up (healthy)   0.0.0.0:9200->9200/tcp, 0.0.0.0:9300->9300/tcp
kibana          /usr/local/bin/kibana-docker     Up (healthy)   0.0.0.0:5601->5601/tcp
```

## 3. Adding some data
Let's add some data.. `cd` into scripts folder and run:
```
chmod +x insert-activities.sh
./insert-activities.sh
```

We now can `curl` and see the data added:
```
curl http://localhost:9200/training/_search?pretty
```

## 4. Launch the application and interact with it
From the project root folder, run the command below to launch the application:
```
mvn clean spring-boot:run
```
A successful output log will be:
```console
2019-01-14 10:07:21.484  INFO 29432 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2019-01-14 10:07:21.873  INFO 29432 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2019-01-14 10:07:21.876  INFO 29432 --- [           main] pringbootElasticGymActivitiesApplication : Started SpringbootElasticGymActivitiesApplication in 10.686 seconds (JVM running for 29.18)
```
### Swagger
We can use Swagger to easily interact with the REST API.

Access using your internet browser the link at <http://localhost:8080/swagger-ui.html>.

We can use this UI to run POST, PUT, GET and DELETE calls.

First, we are going to check the existing data.

Open "**GET** *"api/activities*" and click on **"Try it out"** button.

Then click on **"Execute"** button in the bottom as shown in the figure bellow.

![alt text](https://github.com/wagnerjfr/springboot-rest-elastic/blob/master/figures/figure1.png)

Let's add a new activity. Open the **POST** section and click on **"Try it out"** button.

The below window will appear. Fill with the JSON information want for your new user and click on **"Execute"** button in the bottom.

![alt text](https://github.com/wagnerjfr/springboot-rest-elastic/blob/master/figures/figure2.png)

## 5. Play around with Kibana
Kibana is running at <http://localhost:5601>.

Open it and play around. Create cool visualizations and add them to your dashboard.

![alt text](https://github.com/wagnerjfr/springboot-rest-elastic/blob/master/figures/kibana.png)

## 6. Clean up
Stop Elasticsearch and Kibana containers:
```
docker-compose down
```
Delete created Docker images:
```
docker rmi docker.elastic.co/kibana/kibana-oss:6.4.2 docker.elastic.co/elasticsearch/elasticsearch-oss:6.4.2
```
