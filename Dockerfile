FROM dockerfile/java:oracle-java8
MAINTAINER huseyinbabal88@gmail.com
EXPOSE 9091
CMD java -jar restful-chat-service.jar
ADD build/libs/restful-chat-service-0.1.0.jar /data/restful-chat-service.jar