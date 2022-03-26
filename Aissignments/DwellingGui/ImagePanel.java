package dwellingImages;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private ArrayList<ImageIcon> top = new ArrayList<>();
	private ArrayList<ImageIcon> garage = new ArrayList<>();
	private ArrayList<ImageIcon> window = new ArrayList<>();

	private Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA};
	private ImageIcon house =  new ImageIcon(ImagePanel.class.getResource("/dwelling/house.png"));
		
	private int colorIndex = 0;
	private int garageIndex = 0;
	private int windowIndex = 0;
	private int topIndex = 0;
	
	/**
	 * Create the panel.
	 */
	public ImagePanel() {
		for(int i = 0; i < 4; i ++) {
		      top.add(new ImageIcon(ImagePanel.class.getResource("/dwelling/top" + String.valueOf(i) + ".png")));
		      garage.add(new ImageIcon(ImagePanel.class.getResource("/dwelling/garage" + String.valueOf(i) + ".png")));
		      window.add(new ImageIcon(ImagePanel.class.getResource("/dwelling/window" + String.valueOf(i) + ".png")));
		}
	}
	/**
	 * changes the background color if no 
	 * check box is selected
	 */
	public void changeColor() {
		colorIndex = ++colorIndex % color.length;
		setBackground(color[colorIndex]);
	}

	/**
	 * changes the Garage image 
	 */
	public void changeGarageImage() {		
		garageIndex = ++garageIndex % garage.size();
		repaint();
	}
	
	/**
	 * changes the window image 
	 */
	public void changeWindowImage() {
		windowIndex = ++windowIndex % window.size();
		repaint();
	}
	
	/**
	 * changes the topWindow image 
	 */
	public void changeTopWindowImage() {
		topIndex = ++topIndex % top.size();
		repaint();
	}


	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		ImageIcon icon = house;
		initiateImages(g, icon);
		
		ImageIcon garageIcon = garage.get(garageIndex);  
		initiateImages(g, garageIcon);
		
		ImageIcon windowIcon = window.get(windowIndex);
		initiateImages(g, windowIcon);
		
		ImageIcon topWindowIcon = top.get(topIndex);
		initiateImages(g, topWindowIcon);
		
	}
	private void initiateImages(Graphics g, ImageIcon icon) {
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		scaledIcon.paintIcon(this, g, 50, 50);
	}
}
