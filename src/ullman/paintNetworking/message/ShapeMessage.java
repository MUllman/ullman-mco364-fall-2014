package ullman.paintNetworking.message;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class ShapeMessage implements PaintMessage {

	private ShapeType shapeType;
	private int x;
	private int y;
	private int width;
	private int height;
	private int color;
	private int thickness;
	private boolean fill;

	public ShapeMessage(ShapeType shapeType, int x, int y, int width, int height, int color, int thickness, boolean fill) {
		this.shapeType = shapeType;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.thickness= thickness;
		this.fill = fill;
	}

	public ShapeType getShapeType() {
		return shapeType;
	}

	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public String toString() {
		String message = "SHAPE " + shapeType + " " + x + " " + y + " " + width + " " + height + " " + color + " "
				+ thickness + " " + fill + "\n";
		return message;
	}

	@Override
	public void apply(Graphics2D g) {

		g.setColor(new Color(color));
		g.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));

		switch (shapeType) {

		case RECT:
			if (fill) {
				g.fillRect(x, y, width, height);
			} else {
				g.drawRect(x, y, width, height);
			}
			break;

		case OVAL:
			if (fill) {
				g.fillOval(x, y, width, height);
			} else {
				g.drawOval(x, y, width, height);
			}
			break;

		}

	}

}
