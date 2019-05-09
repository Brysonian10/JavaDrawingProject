package drawing.view;

import javax.swing.JFrame;
import drawing.controller.DrawingController;

public class DrawingFrame extends JFrame
{
	private DrawingController app;
	
	public DrawingFrame()
	{
		super();
		this.app = app;
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setVisible(true);
	}
}
