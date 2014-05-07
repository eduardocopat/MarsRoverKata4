package MarsRover;


public class TurnRightCommand implements RoverCommand {
    @Override
    public void execute(Rover rover) {
        rover.turnRight();
    }
}
