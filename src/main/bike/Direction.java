package main.bike;

import java.util.Optional;
import java.util.Arrays;

/**
 * Enum class denoting four directions
 */
public enum Direction {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270),
    ;

    private final int directionAngle;

    /**
     * Creates and sets the given direction angle
     * to the enum value.
     *
     * @param directionAngle
     */
    private Direction(int directionAngle) {
        this.directionAngle = directionAngle;
    }

    /**
     * Returns the enum value based on the specified directionAngle
     * Returns null if no match found.
     *
     * @param directionAngle
     * @return Direction
     */
    static Direction valueOf(int directionAngle) {
        try {
            // gets the enum values as streams and matches the direction angle
            Optional<Direction> matchedDirection = Arrays.stream(values())
                    .filter(direction -> direction.directionAngle == directionAngle)
                    .findFirst();

            return matchedDirection.get();
        } catch(Exception exception) {
            System.out.println("Error: "+ exception.getMessage());
            return null;
        }
    }

    /**
     * Adds the given rotationAngle to current directionAngle
     * to compute new direction.
     *
     * @param rotationAngle
     * @return direction
     */
    private Direction rotate(int rotationAngle) {
        int rotatedAngle = directionAngle + rotationAngle;

        // compute the corresponding positive angle for negative angle value
        if(rotatedAngle < 0) {
            rotatedAngle += 360;
        }

        // mod operator to handle the condition NORTH angle can be 0 or 360
        return valueOf(rotatedAngle%360);
    }

    /**
     * Rotates the direction by -90 degree angle
     * @return direction
     */
    public Direction rotateLeft() {
        return rotate(-90);
    }

    /**
     * Rotates the direction by +90 degree angle
     * @return direction
     */
    public Direction rotateRight() {
        return rotate(90);
    }
}


