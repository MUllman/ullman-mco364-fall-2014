package ullman.paintLayers;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ullman.paintLayers.actionListener.ChooseColorListener;
import ullman.paintLayers.actionListener.ClearListener;
import ullman.paintLayers.actionListener.ScrollListener;
import ullman.paintLayers.actionListener.ShapeDropDownListener;
import ullman.paintLayers.actionListener.ImageLayersDropDownListener;

import java.awt.*;

public class Paint extends JFrame {

    private String[] Shapes = {"Draw", "Line", "Rectangle", "Filled Rectangle", "Circle", "Filled Circle", "Bucket Fill"};
    private String [] imageLayers = {"Layer 1", "Layer 2", "Layer 3", "Layer 4" };
    private StrokeSettings settings;
    private JLabel thicknessLabel;
    private JButton colorButton;

    public Paint() {
        settings = new StrokeSettings();

        setSize(800, 600);
        setTitle("Paint");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Canvas canvas = new Canvas(settings);
        add(canvas, BorderLayout.CENTER);

        JPanel topNav = new JPanel();

        colorButton = new JButton("CHANGE COLOR");
        colorButton.setOpaque(true);
        colorButton.setBackground(settings.getColor());
        colorButton.addActionListener(new ChooseColorListener(this, canvas));
        topNav.add(colorButton);

        JComboBox shapeDropDown = new JComboBox(Shapes);
        shapeDropDown.addActionListener(new ShapeDropDownListener(canvas));
        shapeDropDown.setSelectedIndex(0);
        topNav.add(shapeDropDown);

        JButton clearButton = new JButton("CLEAR SELECTED LAYER");
        clearButton.addActionListener(new ClearListener(canvas));
        topNav.add(clearButton);

        topNav.add(new JLabel("Thickness:"));
        thicknessLabel = new JLabel(String.valueOf(settings.getThickness()));
        topNav.add(thicknessLabel);
        canvas.addMouseWheelListener(new ScrollListener(settings, thicknessLabel));

        JComboBox imageLayerDropDown = new JComboBox(imageLayers);
        imageLayerDropDown.addActionListener(new ImageLayersDropDownListener(canvas));
        imageLayerDropDown.setSelectedIndex(0);
        topNav.add(imageLayerDropDown);


        add(topNav, BorderLayout.NORTH);
    }

    public void changeColor(Color color) {
        settings.setLColor(color);
        colorButton.setBackground(color);
    }

    public Color getColor(){
        return settings.getColor();
    }


    public static void main(String[] args) {
        Paint p = new Paint();
        p.setVisible(true);
    }
}
