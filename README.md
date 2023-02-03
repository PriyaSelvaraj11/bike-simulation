A simple CLI application simulating a bike driving on a 7 x 7 grid developed using Java.

The following commands are accepted by the application:
1. PLACE X,Y,<Facing-direction> - Place the bike on the grid on the point (x,y) with facing the given direction.
2. FORWARD - move one step forward in the grid
3. TURN_LEFT - rotate the direction of the bike to its left
4. TURN_RIGHT - rotate the direction of the bike to its right
5. GPS_REPORT -  print the current position and direction of the bike

### Running the application
**System requirement**: Java 8 or above installed on your system

**Steps to run the application in the terminal**
1. Navigate to out/artifacts/bike_simulation_jar/ directory.
2. Run the command - _java -jar bike-simulation.jar_

### UML diagram of the solution
<img src="/appImages/bike-simulation.jpg" alt="Class diagram" width="700"/>

### Code coverage stats
<img src="/appImages/code-coverage.png" alt="Code coverage stats" width="700"/>
