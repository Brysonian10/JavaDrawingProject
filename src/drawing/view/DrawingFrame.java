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
		this.setSize(1000,  800);
		this.setResizable(false);
		this.setTitle("Drawing in Java");
		this.setVisible(true);
	}
}
