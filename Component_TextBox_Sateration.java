import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class Component_TextBox_Sateration extends Component_TextBox {

	public Component_TextBox_Sateration(int x, int y, int w, int h, boolean hitbox, Panel panel, String name, int value) {
		super(x, y, w, h, hitbox, panel, name, value);
	}
	
	public BufferedImage drawRegular (){
		super.drawRegular();
		value = panel.sateration;
		return image;
	}
	
	public void keyPressed (KeyEvent e){
		super.keyPressed(e);
		universalKeyPressed (e);
	}
	
	public void keyEnter(){
		if (value > 100){
			value = 100;
			panel.sateration = 100;
		} else {
			panel.sateration = value;
		}
	}
}
