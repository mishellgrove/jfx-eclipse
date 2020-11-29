package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Moon;
import threads.MoonThread;
import threads.SliderThread;

public class EclipseGUI {
    private Moon m;
    private boolean isBouncing;
    private boolean brightness;

    @FXML
    private AnchorPane background;

    @FXML
    private Circle sun;

    @FXML
    private Circle moon;

    @FXML
    private Slider slider;

    @FXML
    private Color color;

    @FXML
    private Rectangle sky;
    
    @FXML
    private Circle star4;

    @FXML
    private Circle star3;

    @FXML
    private Circle star2;

    @FXML
    private Circle star1;

    @FXML
    private Circle star;

    @FXML
    private Circle star5;

    @FXML
    private Circle star7;

    public EclipseGUI() {

    }

    @FXML
    void startButton() {
        isBouncing = true;
        SliderThread sThread = new SliderThread(this);
        sThread.start();
        MoonThread bt = new MoonThread(this, m);
        m.setMoving(true);
        bt.start();
    }

    @FXML
    void stopButton() {
        isBouncing = false;
        m.setMoving(false);
    }

    public void star() {
        brightness = !brightness;
        updateStars(brightness);
    }

    public boolean isBouncing() {
        return isBouncing;
    }

    public Slider getSlider() {
        return slider;
    }

    public void updateBall() {
        moon.setLayoutX(m.getX());

        if (moon.getLayoutX() >= sun.getLayoutX() - sun.getRadius() && moon.getLayoutX() <= sun.getLayoutX()) {
            color = color.darker();
            updateStars(true);
          
            star();
        } else {
            color = color.brighter();
            updateStars(false);
        }
        sky.setFill(color);
    }

    public void updateSpeed(long sleep) {
        m.setSleep(sleep);
    }

    public void initialize() {
        m = new Moon(moon.getLayoutX(), 50, 5, background.getWidth(), moon.getRadius());
        color = (Color) sky.getFill();
        updateStars(false);
    }
    
    public void updateStars(boolean visible ) {
    	star.setVisible(visible);
        star1.setVisible(visible);
        star2.setVisible(visible);
        star3.setVisible(visible);
        star4.setVisible(visible);
        star5.setVisible(visible);
        star7.setVisible(visible);
   
    }
}