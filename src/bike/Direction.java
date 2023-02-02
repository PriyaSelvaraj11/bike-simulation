package bike;

import java.util.Optional;
import java.util.Arrays;
public enum Direction {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270),
    ;

    private final int directionAngle;

    private Direction(int directionAngle) {
        this.directionAngle = directionAngle;
    }

    static Direction valueOf(int directionAngle) {
        try {
            Optional<Direction> matchedDirection = Arrays.stream(values())
                    .filter(direction -> direction.directionAngle == directionAngle)
                    .findFirst();
            return matchedDirection.get();
        } catch(Exception exception) {
            System.out.println("Error: "+ exception.getMessage());
            return null;
        }
    }

    private Direction rotate(int rotationAngle) {
        int rotatedAngle = directionAngle + rotationAngle;
        if(rotatedAngle < 0) {
            rotatedAngle += 360;
        }
        return valueOf(rotatedAngle%360);
    }

    public Direction rotateLeft() {
        return rotate(-90);
    }

    public Direction rotateRight() {
        return rotate(90);
    }
}


