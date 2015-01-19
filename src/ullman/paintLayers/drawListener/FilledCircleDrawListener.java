package ullman.paintLayers.drawListener;

import java.awt.Graphics2D;

import ullman.paintLayers.Canvas;

public class FilledCircleDrawListener extends ShapeDrawListener {
    public FilledCircleDrawListener(Canvas canvas) {
        super(canvas);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.fillOval(x, y, width, height);
    }
}
