import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Component_TextBox extends Component {

	String name;
	int value;
	char[] values = new char[0];

	public Component_TextBox(int x, int y, int w, int h, boolean hitbox, Panel panel, String name, int value) {
		super(x, y, w, h, hitbox, panel);
		this.name = name;
		this.value = value;
	}

	public BufferedImage drawRegular() {
		Graphics2D g = super.drawRegular().createGraphics();
		values = new char[0];
		g.setColor(Color.white);
		g.fillRect(1, 1, width, height);
		g.setColor(Color.black);
		g.drawString(name, 6, (height / 2) + 5);
		g.drawString(value + "", 30, (height / 2) + 5);
		g.drawRect(25, 3, width - 28, height - 6);
		return image;
	}

	public BufferedImage drawPressed() {
		Graphics2D g = super.drawPressed().createGraphics();
		g.setColor(Color.white);
		g.fillRect(1, 1, width, height);
		g.setColor(Color.black);
		g.drawString(name, 6, (height / 2) + 5);
		g.drawString(value + "", 30, (height / 2) + 5);
		g.drawRect(25, 3, width - 28, height - 6);
		return image;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10){
			keyEnter();
		}
	}
	
	public void keyEnter (){
		
	}
	
	public void universalKeyPressed (KeyEvent e){		
		if (Character.isDigit(e.getKeyChar())) {
			char[] valuesCopy = values;
			values = new char[valuesCopy.length + 1];
			for (int i = 0; i < valuesCopy.length; i++) {
				values[i] = valuesCopy[i];
			}
			values[valuesCopy.length] = e.getKeyChar();
			String tempString = String.copyValueOf(values);
			value = Integer.parseInt(tempString);
		}
	}
}