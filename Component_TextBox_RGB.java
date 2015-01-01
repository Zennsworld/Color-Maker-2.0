import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class Component_TextBox_RGB extends Component_TextBox {

	boolean setRed;
	boolean setGreen;
	boolean setBlue;
	
	public Component_TextBox_RGB(int x, int y, int w, int h, boolean hitbox, Panel panel, String name, int value, boolean setR, boolean setG, boolean setB) {
		super(x, y, w, h, hitbox, panel, name, value);
		setRed = setR;
		setGreen = setG;
		setBlue = setB;
	}
	
	public BufferedImage drawRegular (){
		super.drawRegular();
		if (setRed){
			value = (int) (panel.R);
		} else if (setGreen){
			value = (int) (panel.G);
		} else if (setBlue){
			value = (int) (panel.B);
		}
		return image;
	}
	
	public void keyPressed (KeyEvent e){
		super.keyPressed(e);
		universalKeyPressed (e);
	}
	
	public void keyEnter(){
		if (value > 255){
			if (setRed){
				panel.setHSBfromRGB(255, panel.R, panel.B);
			} else if (setGreen){
				panel.setHSBfromRGB(panel.R, 255, panel.B);
			} else if (setBlue){
				panel.setHSBfromRGB(panel.R, panel.G, 255);
			}
		} else {
			if (setRed){
				panel.setHSBfromRGB(value, panel.R, panel.B);
			} else if (setGreen){
				panel.setHSBfromRGB(panel.R, value, panel.B);
			} else if (setBlue){
				panel.setHSBfromRGB(panel.R, panel.G, value);
			}	
		}
	}
}
