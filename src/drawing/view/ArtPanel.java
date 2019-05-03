package drawing.view;

import javax.swing.JPanel;
import drawing.controller.DrawingController;

public class ArtPanel extends JPanel
{
	
	private DrawingController app;
	
	public ArtPanel(DrawingController app)
	{
		super();
		this.app = app;
	}
}
