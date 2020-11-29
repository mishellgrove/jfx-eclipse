package threads;

import ui.EclipseGUI;

public class SliderThread extends Thread{
	private final EclipseGUI eGui;
	
	public SliderThread(EclipseGUI eGui) {
		setDaemon(true);
		this.eGui = eGui;
		
	}
	
	@Override
    public void run() {
        while (eGui.isBouncing()){
            double sliderValue =  100 - (eGui.getSlider().getValue() - 1);
            eGui.updateSpeed((long)sliderValue);
        }
    }
	
}