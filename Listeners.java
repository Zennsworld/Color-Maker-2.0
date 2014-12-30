import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Listeners implements MouseListener, MouseMotionListener, KeyListener{

	Panel panel;
	Frame frame;

	Component[] components;
	Point mouse;

	int mouseX;
	int mouseY;

	Component pressedCom;
	Component selectedCom;

	public Listeners(Frame frame, Component[] components, Panel panel) {
		frame.addMouseListener(this);
		frame.addMouseMotionListener(this);
		frame.addKeyListener(this);
		this.components = components;
		this.panel = panel;
		this.frame = frame;
	}

	public void mouseDragged(MouseEvent arg0) {
		mouse = MouseInfo.getPointerInfo().getLocation();
		mouseX = mouse.x - frame.getX() - 4;
		mouseY = mouse.y - frame.getY() - 25;
		int falseMouseX = mouseX;
		int falseMouseY = mouseY;
		if (pressedCom != null) {
			if (mouseX < pressedCom.x) {
				falseMouseX = pressedCom.x;
			} else if (mouseX > pressedCom.x + pressedCom.width) {
				falseMouseX = pressedCom.x + pressedCom.width;
			}
			if (mouseY < pressedCom.y) {
				falseMouseY = pressedCom.y;
			} else if (mouseY > pressedCom.y + pressedCom.height) {
				falseMouseY = pressedCom.y + pressedCom.height;
			}
			pressedCom.pressed(falseMouseX, falseMouseY);
		}
		panel.repaint();
	}

	public void mouseMoved(MouseEvent arg0) {
		mouse = MouseInfo.getPointerInfo().getLocation();
		mouseX = mouse.x - frame.getX() - 4;
		mouseY = mouse.y - frame.getY() - 25;
		for (int i = 0; i < components.length; i++) {
			if (inHitBox(components[i], mouseX, mouseY)) {
				components[i].EVENT = Component.MOUSEOVER;
				panel.repaint();
			} else {
				components[i].EVENT = 0;
				panel.repaint();
			}
		}
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {
		mouse = MouseInfo.getPointerInfo().getLocation();
		mouseX = mouse.x - frame.getX() - 4;
		mouseY = mouse.y - frame.getY() - 25;
		for (int i = 0; i < components.length; i++) {
			if (inHitBox(components[i], mouseX, mouseY)) {
				components[i].pressed(mouseX, mouseY);
				components[i].EVENT = Component.PRESSED;
				pressedCom = components[i];
				selectedCom = components[i];
				panel.repaint();
			} else {
				components[i].EVENT = 0;
				panel.repaint();
			}
		}

	}

	public void mouseReleased(MouseEvent arg0) {
		mouse = MouseInfo.getPointerInfo().getLocation();
		mouseX = mouse.x - frame.getX() - 4;
		mouseY = mouse.y - frame.getY() - 25;
		for (int i = 0; i < components.length; i++) {
			if (inHitBox(components[i], mouseX, mouseY)) {
				components[i].EVENT = Component.MOUSEOVER;
				panel.repaint();
			} else {
				components[i].EVENT = 0;
				panel.repaint();
			}
		}
		pressedCom = null;
	}

	private boolean inHitBox(Component com, int x, int y) {
		if (com.hitbox) {
			if (mouseX >= com.x && mouseX <= com.x + com.width && mouseY >= com.y && mouseY <= com.y + com.height) {
				return true;
			}
		}
		return false;
	}

	public void keyPressed(KeyEvent e) {
		if (selectedCom != null){
			selectedCom.keyPressed(e);
			selectedCom.EVENT = Component.PRESSED;
			panel.repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
		selectedCom.EVENT = Component.MOUSEOVER;
		panel.repaint();
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
