import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
/*
* --This class represents the lawn that the LawnMower will cut grass on
* --It is a 2D grid of cells
* --It keeps track of which cells have been cut too
*/
public class Lawn {
    private final int rows;
    private final int columns;
    private final Set<Point> cutCells;

    public Lawn(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cutCells = new HashSet<>();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void addCutCell(int row, int column) {
        cutCells.add(new Point(row, column));
    }

    public boolean isCellCut(int row, int column) {
        return cutCells.contains(new Point(row, column));
    }
}
