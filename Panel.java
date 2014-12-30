import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	int hue = 0;
	int brightness = 0;
	int sateration = 0;
	
	Component_SBWheel sbwheel;
	Component_HueBar huebar;
	Component_Preview preview;
	Component_SaterationBar saterationbar;
	Component_BrightnessBar brightnessbar;
	Component_TextBox_Hue  textboxhue;
	Component_TextBox_Sateration  textboxsateration;
	
	Component [] components;
	
	public Panel (Frame frame){
		super();
		Component[] tempComponents = {
		preview = new Component_Preview(0, 0, 600, 600, false, this),
		sbwheel = new Component_SBWheel (0, 0,400,400, true,this),
		huebar = new Component_HueBar(410, 0, 25, 400, true, this),
		saterationbar = new Component_SaterationBar(0, 410, 400, 25, true, this),
		brightnessbar = new Component_BrightnessBar(0, 445, 400, 25, true, this),
		textboxhue = new Component_TextBox_Hue(445, 0, 75, 25, true, this, "H", 0),
		textboxhue = new Component_TextBox_Hue(445, 35, 75, 25, true, this, "S", 0),
		};
		components = tempComponents;
		@SuppressWarnings("unused")
		Listeners listeners = new Listeners(frame, components, this);
	}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		
		for (int i=0;i<components.length;i++){
			g.drawImage(components[i].draw(), components[i].x, components[i].y,null);
		}
		
	}
	
	public Color convertColor (int hue, int bri, int sat){
		Color color;
		float R = 0;
		float G = 0;
		float B = 0;
		
		float R0 = 0;
		float G0 = 0;
		float B0 = 0;
		if (hue < 255) {
			R = 255;
			G = hue;
			B = 0;
		} else if (hue < 510) {
			R = 255 - (hue - 255);
			G = 255;
			B = 0;
		} else if (hue < 765) {
			R = 0;
			G = 255;
			B = (hue - 510);
		} else if (hue < 1020) {
			R = 0;
			G = 255 - (hue - 765);
			B = 255;
		} else if (hue < 1275) {
			R = (hue - 1020);
			G = 0;
			B = 255;
		} else if (hue < 1530) {
			R = 255;
			G = 0;
			B = 255 - (hue - 1275);
		}
		R0 = (255 - R);
		G0 = (255 - G);
		B0 = (255 - B);
		R = ((R0 / 100)) * sat;
		G = ((G0 / 100)) * sat;
		B = ((B0 / 100)) * sat;
		R0 = R;
		G0 = G;
		B0 = B;
		R = (((255 - R0) / 100) * bri);
		G = (((255 - G0) / 100) * bri);
		B = (((255 - B0) / 100) * bri);
		color = new Color ((int)(R),(int)(G),(int)(B));
		return color;
	}
}
