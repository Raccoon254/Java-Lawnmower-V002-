import java.util.ArrayList;
import java.util.List;

/*
* --This class represents the LawnMower that moves around the lawn cutting grass
* --It has a state that determines how it moves and its direction
* --It has a cutter that cuts the grass
* --It has method like move(),notifyObservers() and registerObserver() together with getters and setters
*/
public class Lawnmower {
    private int row;
    private int column;
    private State state;
    private final Lawn lawn;
    private final Cutter cutter;
    private final List<Observer> observers;

    public Lawnmower(Lawn lawn) {
        this.lawn = lawn;
        this.row = 0;
        this.column = 0;
        this.state = new MowingRightState(this);
        this.observers = new ArrayList<>();
        this.cutter = new Cutter();


        // Cut the initial cell
        cutter.cut();
        lawn.addCutCell(row, column);
    }

    public void move() {
        state.move();
        cutter.cut();
        lawn.addCutCell(row, column);
        System.out.println("At Row->"+row+" Col->"+column);
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
