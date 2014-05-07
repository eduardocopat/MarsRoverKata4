package Test;

import MarsRover.Grid;
import MarsRover.GridPoint;
import MarsRover.Rover;
import MarsRover.Direction;
import MarsRover.ObstacleFound;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class GridTest {

    Grid grid;

    @Before
    public void setUp(){
        int gridSize = 10;
        grid = new Grid(gridSize);
    }

    @Test
    public void requestGridPositionToMove(){
        GridPoint newPosition = new GridPoint(1,1);
        grid.requestPosition(newPosition);
        GridPoint actualPoint = newPosition;

        GridPoint expectedPoint = new GridPoint(1, 1);

        Assert.assertEquals(expectedPoint.getX(),actualPoint.getX());
        Assert.assertEquals(expectedPoint.getY(),actualPoint.getY());
    }

    @Test
    public void requestGridPositionWrappingNorth(){
        GridPoint newPosition = new GridPoint(-1,0);

        grid.requestPosition(newPosition);
        GridPoint actualPoint = newPosition;

        GridPoint expectedPoint = new GridPoint(9, 0);
        Assert.assertEquals(expectedPoint.getX(),actualPoint.getX());
        Assert.assertEquals(expectedPoint.getY(),actualPoint.getY());
    }

    @Test
    public void requestGridPositionWrappingSouth(){
        GridPoint newPosition = new GridPoint(10,0);

        GridPoint expectedPoint = new GridPoint(0, 0);
        grid.requestPosition(newPosition);
        GridPoint actualPoint = newPosition;

        Assert.assertEquals(expectedPoint.getX(),actualPoint.getX());
        Assert.assertEquals(expectedPoint.getY(),actualPoint.getY());
    }

    @Test
    public void requestGridPositionWrappingEast(){
        GridPoint newPosition = new GridPoint(0,-1);

        GridPoint expectedPoint = new GridPoint(0, 9);
        grid.requestPosition(newPosition);
        GridPoint actualPoint = newPosition;

        Assert.assertEquals(expectedPoint.getX(),actualPoint.getX());
        Assert.assertEquals(expectedPoint.getY(),actualPoint.getY());
    }

    @Test
    public void requestGridPositionWrappingWest(){
        GridPoint newPosition = new GridPoint(0,10);

        GridPoint expectedPoint = new GridPoint(0, 0);
        grid.requestPosition(newPosition);
        GridPoint actualPoint = newPosition;

        Assert.assertEquals(expectedPoint.getX(),actualPoint.getX());
        Assert.assertEquals(expectedPoint.getY(),actualPoint.getY());
    }

    @Test(expected = ObstacleFound.class)
    public void requestGridPositionWithObstacle(){
        GridPoint obstaclePosition = new GridPoint(1,1);
        grid.setObstaclePosition(obstaclePosition);

        GridPoint newPosition = new GridPoint(1,1);
        grid.requestPosition(newPosition);
    }


    /*********************************************/


    @Test
    public void moveRoverForwardWrappingNorth(){
        Rover rover = new Rover(grid, new GridPoint(0,0), Direction.NORTH);

        GridPoint expectedPoint = new GridPoint(9, 0);

        rover.moveForward();

        Assert.assertEquals(expectedPoint.getX(),rover.getCurrentPosition().getX());
        Assert.assertEquals(expectedPoint.getY(),rover.getCurrentPosition().getY());
    }

    @Test
    public void moveRoverThroughGridWrappingSouth(){
        Rover rover = new Rover(grid, new GridPoint(0,0), Direction.SOUTH);

        GridPoint expectedPoint = new GridPoint(9, 0);

        rover.moveBackwards();

        Assert.assertEquals(expectedPoint.getX(),rover.getCurrentPosition().getX());
        Assert.assertEquals(expectedPoint.getY(),rover.getCurrentPosition().getY());
    }
}
