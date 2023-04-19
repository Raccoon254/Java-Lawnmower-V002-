/*
* --This is the moving left state, and it implements the state interface
* --It has a constructor that takes in a Lawnmower object
* --It ensures the mower moves left
*/
public class MowingLeftState implements State {
    private final Lawnmower lawnmower;

    public MowingLeftState(Lawnmower lawnmower) {
        this.lawnmower = lawnmower;
    }

    @Override
    public void move() {
        int currentColumn = lawnmower.getColumn();
        int currentRow = lawnmower.getRow();
        Lawn lawn = lawnmower.getLawn();

        if (currentColumn > 0) {
            // Move the lawnmower to the left
            lawnmower.setColumn(currentColumn - 1);
        } else {
            // At the start of the row, switch to MovingDownState
            lawnmower.setState(new MovingDownState(lawnmower));
        }
    }
}
