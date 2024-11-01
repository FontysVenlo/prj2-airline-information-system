# How to run
Either:
- run App.java from your IDE
- `mvn clean package && java -cp target/AirlineApp-1.0-SNAPSHOT-jar-with-dependencies.jar io.github.fontysvenlo.ais.App`

# API usage
When running, go to:
- http://localhost:8001/ - Serves from the resources/public directory
- http://localhost:8001/api/trip/search?from=GRO&to=MST - This searches for trips Groningen Airport to Maastricht Airport and returns one (direct) route, in JSON format.

