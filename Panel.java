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
	Component_TextBox_Brightness  textboxbrightness;
	Component_TextBox_RGB  textboxred;
	Component_TextBox_RGB  textboxgreen;
	Component_TextBox_RGB  textboxblue;
	
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
		textboxsateration = new Component_TextBox_Sateration(445, 35, 75, 25, true, this, "S", 0),
		textboxbrightness = new Component_TextBox_Brightness(445, 70, 75, 25, true, this, "B", 0),
		textboxred = new Component_TextBox_RGB(445, 105, 75, 25, true, this, "R", 0, 0),
		textboxgreen = new Component_TextBox_RGB(445, 140, 75, 25, true, this, "G", 0, 1),
		textboxblue = new Component_TextBox_RGB(445, 175, 75, 25, true, this, "B", 0, 2),
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
		Color color = null;
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
		} else if (hue <= 1530) {
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
	
	public void setHSBfromRGB (float R, float G, float B){
		float sat;
		float bri;
		float greatest;
		greatest = findGreatestRGB (R,G,B);
		sat = greatest / 255;
		R = R / sat;
		G = G / sat;
		B = B / sat;
		R = 255 - R;
		G = 255 - G;
		B = 255 - B;
		greatest = findGreatestRGB (R,G,B);
		bri = greatest / 255;
		R = R / bri;
		G = G / bri;
		B = B / bri;
		R = 255 - R;
		G = 255 - G;
		B = 255 - B;
		sateration = (int) (sat * 100);
		brightness = (int) (bri * 100);
		if (R != G && G != B && B != R){
			if (R  == 255 && G < 255) {
				hue = (int)(G);
			} else if (G == 255 && R < 255) {
				hue = 510 - (int)(R);
			} else if (G == 255 && B < 255) {
				hue = 510 + (int)(B);
			} else if (B == 255 && G < 255) {
				hue = 1020 - (int)(G);
			} else if (B == 255 && R <255) {
				hue = 1020 + (int)(R);
			} else if (R == 255 && B < 255) {
				hue = 1530 - (int)(B);
			}
		} else {
			hue = 0;
		}
		System.err.println(sateration + " " + brightness);
		System.err.println(R + " " + G + " " + B);
		convertColor(hue, sateration, brightness);
	}
	
	public float findGreatestRGB (float R, float G, float B){
		float greatest;
		if (R >= G && R >= B){
			greatest = R;
		} else if (G >= R && G >= B){
			greatest = G;			
		} else {
			greatest = B;
		}
		return greatest;
	}
}
