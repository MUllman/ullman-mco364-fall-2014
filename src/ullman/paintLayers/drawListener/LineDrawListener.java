package ullman.paintLayers.drawListener;

import java.awt.Graphics2D;

import ullman.paintLayers.Canvas;

public class LineDrawListener extends ShapeDrawListener {
    public LineDrawListener(Canvas canvas) {
        super(canvas);
    }

    @Override
    public void draw(Graphics2D g) {

        g.drawLine(startPoint.x, startPoint.y, currentPoint.x, currentPoint.y);
    }

}