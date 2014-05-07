package MarsRover;


import java.util.List;

public class Rover {
    private Grid grid;
    private GridPoint currentPosition;
    private Direction currentDirection;
    private RoverMovement roverMovement;

    public Rover(Grid grid, GridPoint startingPoint, Direction startingDirection) {
        this.grid = grid;
        currentPosition = startingPoint;
        currentDirection = startingDirection;

        roverMovement = startingDirection.getRoverMovement();
    }

    public GridPoint getCurrentPosition() {
        return currentPosition;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void moveForward() {
        roverMovement.moveForward(grid, currentPosition);
    }

    public void moveBackwards() {
        roverMovement.moveBackwards(grid , currentPosition);
    }

    public void turnRight() {
        currentDirection = roverMovement.turnRight();
    }

    public void turnLeft() {
        currentDirection = roverMovement.turnLeft();
    }

    public void sendCommands(String commands) {
        RoverCommandInterpreter commandInterpreter = new RoverCommandInterpreter();
        List<RoverCommand> roverCommands = commandInterpreter.analyze(commands);

        for(RoverCommand roverCommand : roverCommands){
            roverCommand.execute(this);
        }

    }
}
