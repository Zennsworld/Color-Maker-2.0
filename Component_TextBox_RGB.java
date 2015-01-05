import java.awt.Color;
import java.awt.image.BufferedImage;


public class Component_TextBox_RGB extends Component_TextBox {

	int set;
	
	public Component_TextBox_RGB(int x, int y, int w, int h, boolean hitbox, Panel panel, String name, int value, int set) {
		super(x, y, w, h, hitbox, panel, name, value);
		this.set = set;
	}
	
	public BufferedImage drawRegular (){
		Color color = panel.convertColor(panel.hue, panel.brightness, panel.sateration);
		super.drawRegular();
		switch(set){
		case (0):
			value = color.getRed();
		break;
		case (1):
			value = color.getGreen();
		break;
		case (2):
			value = color.getBlue();
		break;
		}
		return image;
	}
	
	public void keyEnter(){
		
		float R = panel.convertColor(panel.hue, panel.brightness, panel.sateration).getRed();
		float G = panel.convertColor(panel.hue, panel.brightness, panel.sateration).getGreen();
		float B = panel.convertColor(panel.hue, panel.brightness, panel.sateration).getBlue();
		
		if (value > 255){
			switch(set){
			case (0):
				panel.setHSBfromRGB(255, R, B);
			break;
			case (1):
				panel.setHSBfromRGB(R, 255, B);
			break;
			case (2):
				panel.setHSBfromRGB(R, G, 255);
			break;
			}
		} else {
			switch(set){
			case (0):
				panel.setHSBfromRGB(value, R, B);
			break;
			case (1):
				panel.setHSBfromRGB(R, value, B);
			break;
			case (2):
				panel.setHSBfromRGB(R, G, value);
			break;
			}	
		}
	}
}
