package ullman.paintNetworking.drawListener;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener extends MouseListener, MouseMotionListener
{

    void drawPreview(Graphics2D graphics);
}