package MarsRover;

public class SouthMovement implements RoverMovement {

    @Override
    public void moveForward(Grid grid, GridPoint gridPoint) {
        GridPoint nextPosition = new GridPoint(gridPoint.getX() + 1, gridPoint.getY());
        grid.requestPosition(nextPosition);
        gridPoint.setX(nextPosition.getX());
        gridPoint.setY(nextPosition.getY());
    }

    @Override
    public void moveBackwards(Grid grid, GridPoint gridPoint) {
        GridPoint nextPosition = new GridPoint(gridPoint.getX() - 1, gridPoint.getY());
        grid.requestPosition(nextPosition);
        gridPoint.setX(nextPosition.getX());
        gridPoint.setY(nextPosition.getY());
    }

    @Override
    public Direction turnRight() {
        return Direction.WEST;
    }

    @Override
    public Direction turnLeft() {
        return Direction.EAST;
    }


}
