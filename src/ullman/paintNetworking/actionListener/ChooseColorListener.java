package ullman.paintNetworking.actionListener;

import ullman.paintNetworking.Canvas;
import ullman.paintNetworking.Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseColorListener implements ActionListener
{
    private ullman.paintNetworking.Canvas canvas;
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
