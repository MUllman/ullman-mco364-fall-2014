package ullman.paintLayers;

import java.awt.*;


public class StrokeSettings {

    private int thickness;
    private Color color;
    private BasicStroke stroke;

    public StrokeSettings() {
        thickness = 8;
        color = Color.BLACK;
        stroke = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    }

    public void changeStrokeSettings(Graphics2D g) {
        g.setColor(color);
        g.setStroke(stroke);
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness> 0 ? thickness : 0;
        stroke = new BasicStroke(this.thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
    }

    public Color getColor() {
        return color;
    }

    public void setLColor(Color color) {
        this.color = color;
    }

}
