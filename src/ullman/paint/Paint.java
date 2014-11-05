package ullman.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Paint extends JFrame{

	public Paint(){
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint");
		setLocationRelativeTo(null);
		
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		
		DrawListner listner = new DrawListner(canvas);
		
		canvas.addMouseMotionListener(listner);
	}
	
	public static void main(String[] args){
		Paint paint = new Paint();
		paint.setVisible(true);
	}
	
}

