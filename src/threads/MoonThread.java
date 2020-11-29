package threads;

import model.Moon;
import ui.EclipseGUI;

public class MoonThread extends Thread {
    private final EclipseGUI moonGUI;
    private final Moon moon;

    public MoonThread(EclipseGUI moonGUI, Moon moon) {
        setDaemon(true);
        this.moonGUI = moonGUI;
        this.moon = moon;
    }

    @Override
    public void run() {
        while (moon.isMoving()) {
            moon.move();
            moonGUI.updateBall();
            try {
                Thread.sleep(moon.getSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}