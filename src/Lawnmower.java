import java.util.ArrayList;
import java.util.List;

public class Lawnmower {
    private int row;
    private int column;
    private State state;
    private Lawn lawn;
    private List<Observer> observers;

    public Lawnmower(Lawn lawn) {
        this.lawn = lawn;
        this.row = 0;
        this.column = 0;
        this.state = new MowingRightState(this);
        this.observers = new ArrayList<>();
    }

    public void move() {
        state.move();
        notifyObservers();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
