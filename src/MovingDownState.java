
/*
* --This class is the moving down state, and it is responsible for the mower to shift down at the end of the lawn ie Left & Right
* --It implements the State interface
* --It has a constructor that takes in a Lawnmower object
* --It has a method move() that moves the mower down
*/
public class MovingDownState implements State {
    private final Lawnmower lawnmower;

    public MovingDownState(Lawnmower lawnmower) {
        this.lawnmower = lawnmower;
    }

    @Override
    public void move() {
        int currentColumn = lawnmower.getColumn();
        int currentRow = lawnmower.getRow();
        Lawn lawn = lawnmower.getLawn();

        if (currentRow < lawn.getRows() - 1) {
            // Move the lawnmower down one row
            lawnmower.setRow(currentRow + 1);

            // Switch direction based on the current column
            if (currentColumn == 0) {
                lawnmower.setState(new MowingRightState(lawnmower));
            } else if (currentColumn == lawn.getColumns() - 1) {
                lawnmower.setState(new MowingLeftState(lawnmower));
            }
        } else {
            // Lawnmower has reached the last row, mowing completed
        }
    }
}
