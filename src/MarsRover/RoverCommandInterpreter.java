package MarsRover;

import java.util.ArrayList;
import java.util.List;

public class RoverCommandInterpreter {

    public List<RoverCommand> analyze(String commands) {
        List<RoverCommand> commandList = new ArrayList<RoverCommand>();

        for(char command : commands.toCharArray()){
            switch (command) {
                case 'f':
                    commandList.add(new MoveForwardCommand());
                    break;
                case 'b':
                    commandList.add(new MoveBackwardsCommand());
                    break;
                case 'r':
                    commandList.add(new TurnRightCommand());
                    break;
                case 'l':
                    commandList.add(new TurnLeftCommand());
                    break;
            }
        }
        return commandList;
    }
}
