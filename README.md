A simple CLI application simulating a bike driving on a 7 x 7 grid developed using Java.

### Application description

The bike is placed at a point on the grid before its first movement. The four corners of the n x m grid are (0,0), (n-1,0), (0, m-1), and (n-1,m-1). The application accepts the following commands to simulate the bike driving on the grid.

The following commands are accepted by the application:
1. PLACE X,Y,<Facing-direction> - Place the bike on the grid on the point (x,y) with facing the given direction(NORTH, SOUTH, EAST, or WEST).
2. FORWARD - move one step forward in the grid
3. TURN_LEFT - rotate the direction of the bike to its left
4. TURN_RIGHT - rotate the direction of the bike to its right
5. GPS_REPORT -  print the current position and direction of the bike

### Assumptions

1. No error/log statement will be printed when any command tries to move the bike out of the grid.
2. EXIT command will be given to stop the simulation. Once exited, no history is maintained.
3. Following are the error messages that will be printed in the console.

* _Invalid command_ - No command entered
* _Invalid command - <INVALID_COMMAND>_ - Invalid command name
* _Place the bike on the grid!_ - Commands are executed before valid first PLACE command
* _Invalid parameters for the command!_ - When the parameters count does not match with command syntax.
* _Invalid parameters for the place command!_ - When the parameters x,y, directions for place command are invalid.


### Running the application
**System requirement**: Java 8 or above installed on your system

**Steps to run the application in the terminal**
1. Navigate to out/artifacts/bike_simulation_jar/ directory.
2. Run the command: _java -jar bike-simulation.jar_

### UML diagram of the solution
<img src="/appImages/bike-simulation.jpg" alt="Class diagram" width="700"/>

### Code coverage stats
<img src="/appImages/code-coverage.png" alt="Code coverage stats" width="700"/>
