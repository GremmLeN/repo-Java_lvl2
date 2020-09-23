package lesson1;

import java.awt.*;

public class Back {

    private static float time;

    public static void updateBackgroundColor(GameCanvas canvas, float deltaTime) {
        time += deltaTime;
        if (time >= 5) {
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            canvas.setBackground(new Color(r, g, b));
            time = 0;
        }
    }

}
