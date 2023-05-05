package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static JFrame jFrame;
    public static JPanel jPanel;

    public static void main(String[] args) {
        createFrame();
        addBackground();
    }

    private static void createFrame(){
        jFrame = new JFrame();
        jFrame.setTitle("Swaglords of Space");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int windowWidth = (int)(0.4167 * dimension.width);
        int windowHeight = (int)(0.556 * dimension.height);
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;

        jFrame.setBounds((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2, windowWidth, windowHeight);

        jPanel = new JPanel();
        jFrame.add(jPanel);
    }

    public static void addBackground(){
        Image background;
        try {
            BufferedImage image = ImageIO.read(new File("/home/dmitry/Desktop/Swaglords of Space/src/Textures/background.png"));
            background = image.getScaledInstance(jFrame.getWidth(), jFrame.getHeight(), Image.SCALE_DEFAULT);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JLabel backgroundLabel = new JLabel(new ImageIcon(background));
        backgroundLabel.setBounds(0, 0, jFrame.getWidth(), jFrame.getHeight());
        jPanel.add(backgroundLabel);
        jPanel.revalidate();
    }
}