import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LawnView extends JFrame implements Observer {
    private Lawnmower lawnmower;
    private LawnPanel lawnPanel;
    private JButton startButton;
    private JButton stopButton;
    private JPanel controlPanel;
    private ExecutorService executor;
    private Future<?> simulationFuture;

    public LawnView(Lawnmower lawnmower) {
        this.lawnmower = lawnmower;
        this.lawnmower.registerObserver(this);
        this.lawnPanel = new LawnPanel(lawnmower);

        this.startButton = new JButton("Start");
        this.stopButton = new JButton("Stop");
        this.controlPanel = new JPanel();
        this.executor = Executors.newSingleThreadExecutor();

        setupControls();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(lawnPanel, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);
    }

    private void setupControls() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (simulationFuture == null || simulationFuture.isDone()) {
                    Runnable simulation = new Runnable() {
                        @Override
                        public void run() {
                            Lawn lawn = lawnmower.getLawn();
                            while (lawnmower.getRow() < lawn.getRows() &&
                                    lawnmower.getColumn() < lawn.getColumns() &&
                                    lawnmower.getColumn() >= 0) {
                                lawnmower.move();
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException ex) {
                                    break;
                                }
                            }
                        }
                    };
                    simulationFuture = executor.submit(simulation);
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (simulationFuture != null && !simulationFuture.isDone()) {
                    simulationFuture.cancel(true);
                }
            }
        });

        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
    }

    @Override
    public void update() {
        lawnPanel.repaint();
        new  Cutter().cut();
    }

    private class LawnPanel extends JPanel {
        private Lawnmower lawnmower;

        public LawnPanel(Lawnmower lawnmower) {
            this.lawnmower = lawnmower;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Lawn lawn = lawnmower.getLawn();
            int cellWidth = getWidth() / lawn.getColumns();
            int cellHeight = getHeight() / lawn.getRows();

            g.setColor(Color.GREEN);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(new Color(0, 128, 0));

            // Draw the cut grass with a different color
            g.setColor(new Color(52, 66, 17));
            for (int row = 0; row < lawn.getRows(); row++) {
                for (int column = 0; column < lawn.getColumns(); column++) {
                    if (lawn.isCellCut(row, column)) {
                        g.fillRect(column * cellWidth, row * cellHeight, cellWidth, cellHeight);
                    }
                }
            }

            // Draw the lawnmower
            g.setColor(Color.BLUE);
            g.fillRect(lawnmower.getColumn() * cellWidth, lawnmower.getRow() * cellHeight, cellWidth, cellHeight);
        }

    }
}
