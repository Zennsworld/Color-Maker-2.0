import java.awt.image.BufferedImage;


public class Component_TextBox_Brightness extends Component_TextBox {

	public Component_TextBox_Brightness(int x, int y, int w, int h, boolean hitbox, Panel panel, String name, int value) {
		super(x, y, w, h, hitbox, panel, name, value);
	}
	
	public BufferedImage drawRegular (){
		super.drawRegular();
		value = panel.brightness;
		return image;
	}

	public void keyEnter(){
		if (value > 100){
			value = 100;
			panel.brightness = 100;
		} else {
			panel.brightness = value;
		}
	}
}
