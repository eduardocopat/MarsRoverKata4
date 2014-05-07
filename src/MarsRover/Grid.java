package MarsRover;


public class Grid {
    private final int maxX;
    private final int maxY;
    private GridPoint obstaclePosition;

    public Grid(int gridSize) {
        maxX = gridSize;
        maxY = gridSize;
    }


    public void requestPosition(GridPoint newPosition) {
        if(isThereAnObstacleAt(newPosition))
            throw new ObstacleFound();

        wrapIfNecessary(newPosition);
    }

    private void wrapIfNecessary(GridPoint newPosition) {
        if(newPosition.getX() < 0)
            newPosition.setX(maxX + newPosition.getX());

        if(newPosition.getX() == maxX)
            newPosition.setX(0);

        if(newPosition.getY() < 0)
            newPosition.setY(maxY + newPosition.getY());

        if(newPosition.getY() == maxY)
            newPosition.setY(0);
    }

    private boolean isThereAnObstacleAt(GridPoint newPosition) {
        if(obstaclePosition != null){
            if(obstaclePosition.getX() == newPosition.getX() &&
               obstaclePosition.getY() == newPosition.getY())
                return true;
        }
        return false;
    }

    public void setObstaclePosition(GridPoint obstaclePosition) {
        this.obstaclePosition = obstaclePosition;
    }
}
