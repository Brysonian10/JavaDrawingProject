package drawing.view;

import javax.swing.JPanel;
import drawing.controller.DrawingController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.chrono.Chronology;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import drawing.controller.DrawingController;


public class ArtPanel extends JPanel
{
	
	private DrawingController app;
	private Color currentColor;
	private BufferedImage currentCanvas;
	private int previousX;
	private int previousY;
	
	public ArtPanel(DrawingController app)
	{
		super();
		this.app = app;
		this.currentCanvas = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
		setupPanel();
		resetPoint();
	}
	
	public void resetPoint()
	{
		previousX = Integer.MIN_VALUE;
		previousY = Integer.MIN_VALUE;
	}
	
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(700, 700));
		this.setBackground(Color.WHITE);
		this.currentColor = Color.BLACK;
		
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(currentCanvas, 0, 0, null);
	}
	
	private Color randomColor()
	{
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		int alpha = (int)(Math.random() * 256);
		
		Color randomColor = new Color(red, green, blue, alpha);
		return randomColor;
		
	}
	
	private void setCurrentColor(String color)
	{
		if(color.equalsIgnoreCase("Black"))
		{
			currentColor = Color.BLACK;
		}
		else if(color.equalsIgnoreCase("purple"))
		{
			currentColor = new Color(75, 0, 130);
		}
		else
		{
			currentColor = randomColor();
		}
	}
	
	public void drawDot(int currentX, int currentY, int width)
	{
		Graphics2D current = currentCanvas.createGraphics();
		current.setColor(currentColor);
		current.setStroke(new BasicStroke(width));
		current.drawOval(currentX, currentY, width, width);
		repaint();
	}
	
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupMenuPanels()
	{
		
	}
}
