package lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    Sprite[] sprites = new Sprite[10];

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mouseClicked(e);
                int n = 1;
                if (e.getButton() == MouseEvent.BUTTON1) {
                    addBall(new Ball(), n);
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    removeBall(n);
                }
            }
        });
        add(canvas, BorderLayout.CENTER);
        initApplication();
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
        Back.updateBackgroundColor(canvas, deltaTime);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }

    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    public void addBall(Ball b, int n) {
        Sprite[] newArr = new Sprite[sprites.length + n];
        System.arraycopy(sprites, 0, newArr,0, sprites.length);
        newArr[sprites.length] = b;
        sprites = newArr;
    }

    public void removeBall(int n) {
        Sprite[] newArr = new Sprite[sprites.length - n];
        System.arraycopy(sprites, 0, newArr,0, sprites.length - n);
        sprites = newArr;
    }
}