package model;

public class Moon {
    private double x;
    private long sleep;
    private final int step;
    private final int direction;
    public static int RIGHT = 1;
    private final double radius;
    private boolean moving;

    public Moon(double x, long sleep, int step, double max, double radius) {
        this.x = x;
        this.sleep = sleep;
        this.step = step;
        this.radius = radius;
        direction = RIGHT;
        moving = false;
    }

    public void move() {
        x = x + direction * step;
        if (x > 646) {
            x = radius;
        }
        if (x == 646) {
            x = -60;
            move();
        }
    }

    public double getX() {
        return x;
    }

    public long getSleep() {
        return sleep;
    }

    public void setSleep(long sleep) {
        this.sleep = sleep;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

}
