package ullman.paintLayers.actionListener;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JLabel;

import ullman.paintLayers.StrokeSettings;

public class ScrollListener implements MouseWheelListener
{
    private StrokeSettings settings;
    private JLabel thicknessLabel;

    public ScrollListener(StrokeSettings settings, JLabel thicknessLabel)
    {
        this.settings = settings;
        this.thicknessLabel = thicknessLabel;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        int scrollAmt = e.getWheelRotation();
        settings.setThickness(settings.getThickness() + scrollAmt);
        thicknessLabel.setText(String.valueOf(settings.getThickness()));
    }
}
