import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class Component_TextBox_Hue extends Component_TextBox {

	public Component_TextBox_Hue(int x, int y, int w, int h, boolean hitbox, Panel panel, String name, int value) {
		super(x, y, w, h, hitbox, panel, name, value);
	}
	
	public BufferedImage drawRegular (){
		super.drawRegular();
		value = (int) (panel.hue / 4.25);
		return image;
	}
	
	public void keyPressed (KeyEvent e){
		super.keyPressed(e);
		universalKeyPressed (e);
	}
	
	public void keyEnter(){
		if (value > 360){
			value = 360;
			panel.hue = (int) (360f * 4.25);
		} else {
			panel.hue = (int)(4.25 * value);
		}
	}
}
