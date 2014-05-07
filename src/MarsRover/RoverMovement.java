package MarsRover;

public interface RoverMovement {
    public void moveForward(Grid grid, GridPoint gridPoint);

    public void moveBackwards(Grid grid, GridPoint gridPoint);

    public Direction turnRight();

    public Direction turnLeft();

}
