package MarsRover;

public class TurnLeftCommand implements RoverCommand {
    @Override
    public void execute(Rover rover) {
        rover.turnLeft();
    }
}
