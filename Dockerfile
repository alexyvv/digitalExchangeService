FROM java:8-jre

ADD ./build/libs/digital-exchange-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/digital-exchange-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080