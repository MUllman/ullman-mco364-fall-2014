package ullman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	Integer x = null;
	Integer y = null;
	BufferedImage image;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	public void setPoint(int newX, int newY) {

		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval(newX, newY, 0, 0);
		if (x != null && y != null) {
			g.setStroke(new BasicStroke(10));
            g.draw(new Line2D.Float(x, y, newX, newY));
		}
		x = newX;
		y = newY;
	}
}
