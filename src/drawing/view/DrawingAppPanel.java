package drawing.view;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import javax.swing.*;

import javax.swing.JPanel;
import drawing.controller.DrawingController;



public class DrawingAppPanel extends JPanel
{
	private DrawingController app;
	private ArtPanel canvas;
	private JPanel colorPanel;
	private JPanel menuPanel;
    private JScrollPane canvasPane;
	private SpringLayout appLayout;
	private JSlider widthSlider;
	private JButton redButton;
	private JButton greenButton;
	private JButton blueButton;
	private JButton whiteButton;
	private JButton blackButton;
	private JButton purpleButton;
	private JButton orangeButton;
	private JButton yellowButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton clearButton;
	
	private final int MINIMUM_LINE = 1;
	private final int MAXIMUM_LINE = 25;
	
	public DrawingAppPanel(DrawingController app)
	{
		super();
		this.app = app;
		this.canvas = new ArtPanel(app);
		canvasPane = new JScrollPane();
		appLayout = new  SpringLayout();
		
		greenButton = new JButton("green");
		redButton = new JButton("red");
		blueButton = new JButton("blue");
		blackButton = new JButton("black");
		whiteButton = new JButton("white");
		purpleButton = new JButton("purple");
		orangeButton = new JButton("orange");
		yellowButton = new JButton("yellow");
		
		saveButton = new JButton("save panel");
		loadButton = new JButton("load new panel");
		clearButton = new JButton("save panel");
		widthSlider = new JSlider(MINIMUM_LINE, MAXIMUM_LINE);
		colorPanel = new JPanel(new GridLayout(0, 1));
		menuPanel = new JPanel(new GridLayout(0, 1));
		
		setupMenuPanels();
		setupSlider();
		setupScrollPane();
		setupPanel();
		setupLayout();
		
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.DARK_GRAY);
	}
	
	private void setupScrollPane()
	{
		canvasPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setViewportView(canvas);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		canvas.addMouseListener(new MouseListener()
			{
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				canvas.drawDot(e.getX(), e.getY(), widthSlider.getValue());
			}
			
			public void mousePressed(MouseEvent e)
			{
				
			}
			@Override
			public void mouseReleased(MouseEvent e)
			{
				canvas.resetPoint();
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				canvas.resetPoint();
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				canvas.resetPoint();
			}
		
		
		
			});

	}
	
	private void setupSlider()
	{
		Hashtable<Integer, JLabel> scaleLabels = new Hashtable<Integer, JLabel>();
		scaleLabels.put(MINIMUM_LINE,  new JLabel("<HTML>Small<BR>Line</HTML>"));
		scaleLabels.put(MINIMUM_LINE,  new JLabel("<HTML>Large<BR>Line</HTML>"));
		widthSlider.setLabelTable(scaleLabels);
		widthSlider.setSnapToTicks(true);
		widthSlider.setMajorTickSpacing(5);
		widthSlider.setMinorTickSpacing(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintLabels(true);
		widthSlider.setValue((MAXIMUM_LINE + MINIMUM_LINE) / 2);
		
	}
	
	private void setupMenuPanels()
	{
		colorPanel.setPreferredSize(new Dimension(50, 700));
		menuPanel.setPreferredSize(new Dimension(50, 700));
		
		purpleButton.setForeground(new Color(75, 0, 130));
		blueButton.setForeground(Color.BLUE);
		greenButton.setForeground(Color.GREEN);
		orangeButton.setForeground(Color.ORANGE);
		redButton.setForeground(Color.RED);
		yellowButton.setForeground(Color.YELLOW);
		
		colorPanel.add(blackButton);
		colorPanel.add(purpleButton);
		colorPanel.add(blueButton);
		colorPanel.add(greenButton);
		colorPanel.add(yellowButton);
		colorPanel.add(orangeButton);
		colorPanel.add(redButton);
		colorPanel.add(whiteButton);
		
		menuPanel.add(widthSlider);
		menuPanel.add(loadButton);
		menuPanel.add(saveButton);
		menuPanel.add(clearButton);
	}
	
	
}
