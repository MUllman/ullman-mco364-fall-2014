package ullman.paintNetworking.message;

import ullman.paintNetworking.Canvas;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;



public class BucketFillMessage implements PaintMessage {

	private Canvas canvas;

	private int x;
	private int y;
	private int color;

	public BucketFillMessage(int x, int y, int color, Canvas canvas) {
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String toString() {
		String message;
		message = "BUCKET_FILL " + x + " " + y + " " + color + "\n";
		return message;
	}

	private void floodFill(int x, int y, int oldColor, int newColor) {
		if (oldColor ==newColor) {
			return;
		}

		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			if (x >= 0 && x < 800 && y >= 0 && y < 600) {
				if (oldColor == canvas.getImage().getRGB(p.x, p.y)){
					canvas.getImage().setRGB(p.x, p.y, newColor);
					if (p.x-1 >=0) {
						queue.add(new Point(p.x - 1, p.y));
					}
					if (p.x+1 <800) {
						queue.add(new Point(p.x + 1, p.y));
					}
					if (p.y - 1>=0) {
						queue.add(new Point(p.x, p.y - 1));
					}
					if (p.y + 1<600) {
						queue.add(new Point(p.x, p.y + 1));
					}
				}
			}
		}
	}

	@Override
	public void apply(Graphics2D g) {

		int current = canvas.getStrokeSettings().getColor().getRGB();
		int replacement = color;

		floodFill(x,y, current, replacement);

	}

}
