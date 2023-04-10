import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create a Lawn with 20 rows and columns
        Lawn lawn = new Lawn(20, 20);

        // Create a Lawnmower and set it on the Lawn
        Lawnmower lawnmower = new Lawnmower(lawn);

        // Create a LawnView to visualize the Lawnmower on the Lawn
        LawnView lawnView = new LawnView(lawnmower);

        // Configure and display the LawnView JFrame
        lawnView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lawnView.setSize(600, 600);
        lawnView.setVisible(true);
    }
}
