import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Lawn {
    private int rows;
    private int columns;
    private Set<Point> cutCells;

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
