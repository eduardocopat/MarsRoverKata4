package MarsRover;


public class MoveBackwardsCommand implements RoverCommand {
    @Override
    public void execute(Rover rover) {
        rover.moveBackwards();
    }
}
