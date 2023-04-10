public class MowingLeftState implements State {
    private Lawnmower lawnmower;

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
