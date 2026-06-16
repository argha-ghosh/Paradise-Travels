package Plane;
import javax.swing.*;

public class CustomSizedBasePage {
    public JFrame frame;
    public ImageIcon i = new ImageIcon("Plane/Picture/Logo.png");

    public CustomSizedBasePage(String title) {
        frame = new JFrame(title);
        frame.setSize(900, 650);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(i.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponent(JComponent component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height);
        frame.add(component);
    }

    public void show() {
        frame.setVisible(true);
    }
}
