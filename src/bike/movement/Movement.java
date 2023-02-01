package bike.movement;

import bike.Bike;
import bike.Position;

public abstract class Movement {
    Bike bike;
    public Movement(Bike bike) {
        this.bike = bike;
    }
    public abstract Position getNextPosition();
}
