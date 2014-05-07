package MarsRover;


public enum Direction {
    SOUTH {
        public RoverMovement getRoverMovement(){
            return new SouthMovement();
        }
    },
    WEST{
        public RoverMovement getRoverMovement(){
            return new WestMovement();
        }
    },
    EAST{
        public RoverMovement getRoverMovement(){
            return new EastMovement();
        }
    },
    NORTH{
        public RoverMovement getRoverMovement(){
            return new NorthMovement();
        }
    };

    abstract RoverMovement getRoverMovement();
}
