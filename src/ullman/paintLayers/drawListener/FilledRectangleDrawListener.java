package ullman.paintLayers.drawListener;

import java.awt.Graphics2D;

import ullman.paintLayers.Canvas;

public class FilledRectangleDrawListener extends ShapeDrawListener {

    public FilledRectangleDrawListener(Canvas canvas) {
        super(canvas);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.fillRect(x, y, width, height);
    }
}
