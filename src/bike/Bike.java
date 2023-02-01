package bike;

import bike.movement.ForwardMovement;
import bike.movement.Movement;

public class Bike {
    private Position position;
    private Direction direction;

    public Bike() {
        position = new Position(0,0);
        direction = Direction.NORTH;
    }

    public Bike(int rowIndex, int columnIndex, Direction direction) {
        position = new Position(rowIndex,columnIndex);
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setPositionByIndex(int rowIndex, int columnIndex) {
        position.setRowIndex(rowIndex);
        position.setColumnIndex(columnIndex);
    }
    public void turnLeft() {
        this.direction = direction.rotateLeft();
    }

    public void turnRight() {
        this.direction = direction.rotateRight();
    }

    public Position getNextPosition() {
        Movement forwardMovement = new ForwardMovement(this);
        return forwardMovement.getNextPosition();
    }
}
