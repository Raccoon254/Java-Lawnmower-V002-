public class MowingRightState implements State {
    private Lawnmower lawnmower;

    public MowingRightState(Lawnmower lawnmower) {
        this.lawnmower = lawnmower;
    }

    @Override
    public void move() {
        int currentColumn = lawnmower.getColumn();
        int currentRow = lawnmower.getRow();
        Lawn lawn = lawnmower.getLawn();

        if (currentColumn < lawn.getColumns() - 1) {
            // Move the lawnmower to the right
            lawnmower.setColumn(currentColumn + 1);
        } else {
            // At the end of the row, switch to MovingDownState
            lawnmower.setState(new MovingDownState(lawnmower));
        }
    }
}
