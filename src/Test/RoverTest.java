package Test;

import MarsRover.Direction;
import MarsRover.Grid;
import MarsRover.GridPoint;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import MarsRover.Rover;

public class RoverTest {

    Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(10);
    }

    @Test
    public void createRover() {
        Rover rover = givenRoverAt(0, 0, Direction.SOUTH);

        assertRoverAt(rover, 0, 0);

        assertRoverDirectionAs(Direction.SOUTH, rover.getCurrentDirection());
    }


    @Test
    public void moveRoverForwardFacingSouth() {
        Rover rover = givenRoverAt(0, 0, Direction.SOUTH);

        moveRoverForward(rover);

        assertRoverAt(rover, 1, 0);
    }

    private void moveRoverForward(Rover rover) {
        rover.moveForward();
    }

    private void assertRoverAt(Rover rover, int x, int y) {
        GridPoint roverCurrentPosition = rover.getCurrentPosition();
        Assert.assertEquals(x, roverCurrentPosition.getX());
        Assert.assertEquals(y, roverCurrentPosition.getY());
    }

    private Rover givenRoverAt(int x, int y, Direction direction) {
        GridPoint startingPoint = new GridPoint(x, y);
        return new Rover(grid, startingPoint, direction);
    }

    @Test
    public void moveRoverBackwardsFacingSouth() {
        Rover rover = givenRoverAt(1, 1, Direction.SOUTH);
        moveRoverBackwards(rover);

        assertRoverAt(rover, 0, 1);
    }

    @Test
    public void moveRoverForwardFacingNorth() {
        Rover rover = givenRoverAt(1, 1, Direction.NORTH);
        moveRoverForward(rover);

        assertRoverAt(rover, 0, 1);
    }

    @Test
    public void moveRoverBackwardsFacingNorth() {
        Rover rover = givenRoverAt(0, 0, Direction.NORTH);
        moveRoverBackwards(rover);

        assertRoverAt(rover, 1, 0);
    }

    @Test
    public void moveRoverForwardFacingWest() {
        Rover rover = givenRoverAt(1, 1, Direction.WEST);
        moveRoverForward(rover);

        assertRoverAt(rover, 1, 0);
    }

    @Test
    public void moveRoverBackwardsFacingWest() {
        Rover rover = givenRoverAt(0, 0, Direction.WEST);
        moveRoverBackwards(rover);

        assertRoverAt(rover, 0, 1);
    }

    private void moveRoverBackwards(Rover rover) {
        rover.moveBackwards();
    }

    @Test
    public void moveRoverForwardFacingEast() {
        Rover rover = givenRoverAt(0, 0, Direction.EAST);
        moveRoverForward(rover);

        assertRoverAt(rover, 0, 1);
    }

    @Test
    public void moveRoverBackwardsFacingEast() {
        Rover rover = givenRoverAt(1, 1, Direction.EAST);
        moveRoverBackwards(rover);

        assertRoverAt(rover, 1, 0);
    }

    @Test
    public void turnRoverRightFacingSouth() {
        Rover rover = givenRoverAt(0, 0, Direction.SOUTH);

        turnRoverRight(rover);
        Direction roverCurrentDirection = rover.getCurrentDirection();
        assertRoverDirectionAs(Direction.WEST, roverCurrentDirection);
    }

    @Test
    public void turnRoverLeftFacingSouth() {
        Rover rover = givenRoverAt(0, 0, Direction.SOUTH);

        turnRoverLeft(rover);
        Direction roverCurrentDirection = rover.getCurrentDirection();
        assertRoverDirectionAs(Direction.EAST, roverCurrentDirection);
    }

    private void turnRoverLeft(Rover rover) {
        rover.sendCommands("l");
    }

    @Test
    public void turnRoverRightFacingNorth() {
        Rover rover = givenRoverAt(0, 0, Direction.NORTH);

        turnRoverRight(rover);
        Direction roverCurrentDirection = rover.getCurrentDirection();
        assertRoverDirectionAs(Direction.EAST, roverCurrentDirection);
    }

    @Test
    public void turnRoverLeftFacingNorth() {
        Rover rover = givenRoverAt(0, 0, Direction.NORTH);

        turnRoverLeft(rover);
        Direction roverCurrentDirection = rover.getCurrentDirection();
        assertRoverDirectionAs(Direction.WEST, roverCurrentDirection);
    }

    @Test
    public void turnRoverRightFacingWest() {
        Rover rover = givenRoverAt(0, 0, Direction.WEST);

        turnRoverRight(rover);
        Direction roverCurrentDirection = rover.getCurrentDirection();
        assertRoverDirectionAs(Direction.NORTH, roverCurrentDirection);
    }

    @Test
    public void turnRoverLeftFacingWest() {
        Rover rover = givenRoverAt(0, 0, Direction.WEST);

        turnRoverLeft(rover);
        Direction roverCurrentDirection = rover.getCurrentDirection();
        assertRoverDirectionAs(Direction.SOUTH, roverCurrentDirection);
    }

    @Test
    public void turnRoverRightFacingEast() {
        Rover rover = givenRoverAt(0, 0, Direction.EAST);

        turnRoverRight(rover);
        Direction roverExpectedDirection = Direction.SOUTH;
        Direction roverCurrentDirection = rover.getCurrentDirection();
        assertRoverDirectionAs(roverExpectedDirection, roverCurrentDirection);
    }

    private void assertRoverDirectionAs(Direction roverExpectedDirection, Direction roverCurrentDirection) {
        Assert.assertEquals(roverExpectedDirection, roverCurrentDirection);
    }

    private void turnRoverRight(Rover rover) {
        rover.sendCommands("r");
    }

    @Test
    public void turnRoverLeftFacingEast() {
        Rover rover = givenRoverAt(0, 0, Direction.EAST);

        turnRoverLeft(rover);
        Direction roverCurrentDirection = rover.getCurrentDirection();
        assertRoverDirectionAs(Direction.NORTH, roverCurrentDirection);
    }


}
