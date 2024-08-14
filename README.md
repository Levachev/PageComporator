# Description
 ### Version
  java 21
 ### Build system
  maven
# Build project
    mvn clean compile assembly:single
# Run tests
    mvn test
# Run project
    java -jar target/PageComporator-1.0-SNAPSHOT-jar-with-dependencies.jar ./src/main/resources/data/yesterday.json ./src/main/resources/data/today.json
