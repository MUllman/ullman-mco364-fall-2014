package ullman.paintLayers.drawListener;

import java.awt.Graphics2D;

import ullman.paintLayers.Canvas;

public class RectDrawListener extends ShapeDrawListener
{

    public RectDrawListener(Canvas canvas)
    {
        super(canvas);
    }

    @Override
    public void draw(Graphics2D g)
    {
        super.draw(g);
        g.drawRect(x, y, width, height);
    }
}
