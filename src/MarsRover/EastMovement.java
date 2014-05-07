package MarsRover;

public class EastMovement implements RoverMovement {
    @Override
    public void moveForward(Grid grid, GridPoint gridPoint) {
        GridPoint nextPosition = new GridPoint(gridPoint.getX(), gridPoint.getY() + 1);
        grid.requestPosition(nextPosition);
        gridPoint.setX(nextPosition.getX());
        gridPoint.setY(nextPosition.getY());
    }

    @Override
    public void moveBackwards(Grid grid, GridPoint gridPoint) {
        GridPoint nextPosition = new GridPoint(gridPoint.getX(), gridPoint.getY() - 1);
        grid.requestPosition(nextPosition);
        gridPoint.setX(nextPosition.getX());
        gridPoint.setY(nextPosition.getY());
    }

    @Override
    public Direction turnRight() {
        return Direction.SOUTH;
    }

    @Override
    public Direction turnLeft() {
        return Direction.NORTH;
    }
}
