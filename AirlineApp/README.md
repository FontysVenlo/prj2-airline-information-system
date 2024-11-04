# WIP
This thing does different things, they're not integrated into a single use case (yet):
- Setup a database during the tests
    - with testcontainers - so the tests don't depend on a magically running (and stateful) database
    - spinning up + running the test takes 2s
- Setup a web app automated test
    - with testcontainers and selenium
    - note, its so much slower, a whopping 15 seconds!
- Serve a static html page
    - not working properly because of (resource) path issues
- Serve an API that searches the .csv for a flight route
    - Using a registry pattern for testability

# How to run
Either:
- run App.java from your IDE
- `mvn clean package && java -cp target/AirlineApp-1.0-SNAPSHOT-jar-with-dependencies.jar io.github.fontysvenlo.ais.App`

# API usage
When running, go to:
- http://localhost:8001/ - Serves from the resources/public directory
- http://localhost:8001/api/trip/search?from=GRO&to=MST - This searches for trips Groningen Airport to Maastricht Airport and returns one (direct) route, in JSON format.

