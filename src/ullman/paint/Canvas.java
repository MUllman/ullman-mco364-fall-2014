package ullman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	private Integer x = null;
	private Integer y = null;
	private Color color;
	private int stroke;
	private BufferedImage image;
	

	public Canvas() {
		setColor(Color.BLACK);
		setStroke(10);
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent event){
				setX(event.getX());
				setY(event.getY());
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
	
	

	public void setPoint(int newX, int newY) {

		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(getColor());
		g.fillOval(newX, newY, 0, 0);
		if (x != null && y != null) {
			g.setStroke(new BasicStroke(getStroke()));
            g.draw(new Line2D.Float(x, y, newX, newY));
		}
		x = newX;
		y = newY;
	}


	public void setX(Integer x) {
		this.x = x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}
	
	
	
	
}
