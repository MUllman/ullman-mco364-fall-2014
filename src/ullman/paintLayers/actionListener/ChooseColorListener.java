package ullman.paintLayers.actionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ullman.paintLayers.Canvas;
import ullman.paintLayers.Paint;

import javax.swing.*;

public class ChooseColorListener implements ActionListener
{
    private Canvas canvas;
    private Paint paint;

    public ChooseColorListener(Paint paint, Canvas canvas)
    {
        this.paint = paint;
        this.canvas = canvas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color currentColor = paint.getColor();
        Color color = JColorChooser.showDialog(canvas, "Choose a color", currentColor);
        paint.changeColor(color);
    }
}
