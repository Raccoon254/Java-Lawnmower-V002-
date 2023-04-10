public class MovingDownState implements State {
    private Lawnmower lawnmower;

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
