package ullman.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawListner implements MouseMotionListener{
	
	private Canvas canvas;
	
	public DrawListner(Canvas canvas){
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		canvas.setPoint(event.getX(), event.getY());
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
