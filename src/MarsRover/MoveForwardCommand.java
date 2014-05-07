package MarsRover;

public class MoveForwardCommand implements RoverCommand {

    @Override
    public void execute(Rover rover) {
        rover.moveForward();
    }
}
