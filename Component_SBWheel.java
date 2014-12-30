import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Component_SBWheel extends Component{
	public Component_SBWheel(int x, int y, int w, int h, boolean hitbox, Panel panel) {
		super(x, y, w, h, hitbox, panel);
	}
	
	public BufferedImage drawRegular(){
		Graphics2D g = super.drawRegular().createGraphics();
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				g.setColor(panel.convertColor(panel.hue, i, j));
				g.fillRect(1 + j * width/100,1 + (height/100)*99 - (i * (height/100)), width/100, height/100);
			}
		}
		g.setColor(Color.white);
		g.fillRect(1,1 + width - (panel.brightness * (width/100)), width, 1);
		g.fillRect(1 + panel.sateration * (height/100), 1, 1, height);
		g.setColor(panel.convertColor(panel.hue, panel.brightness, panel.sateration));
		g.fillOval(1 + panel.sateration * (height/100)-5, 1 + width - (panel.brightness * (width/100))-5, 10, 10);
		g.setColor (Color.white);
		g.drawOval(1 + panel.sateration * (height/100)-5, 1 + width - (panel.brightness * (width/100))-5, 10, 10);	
		return image;
	}
	
	public BufferedImage drawPressed (){
		Graphics2D g = super.drawPressed().createGraphics();
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				g.setColor(panel.convertColor(panel.hue, i, j));
				g.fillRect(1 + j * width/100,1 + (height/100)*99 - (i * (height/100)), width/100, height/100);
			}
		}
		g.setColor(Color.white);
		g.fillRect(1,1 + width - (panel.brightness * (width/100)), width, 1);
		g.fillRect(1 + panel.sateration * (height/100), 1, 1, height);
		g.setColor(panel.convertColor(panel.hue, panel.brightness, panel.sateration));
		g.fillOval(1 + panel.sateration * (height/100)-5, 1 + width - (panel.brightness * (width/100))-5, 10, 10);
		g.setColor (Color.white);
		g.drawOval(1 + panel.sateration * (height/100)-5, 1 + width - (panel.brightness * (width/100))-5, 10, 10);
		return image;		
	}
	
	public void pressed (int mouseX, int mouseY){
		panel.brightness = 100 - ((mouseY - y) / (height/100));
		panel.sateration = ((mouseX - x) / (width/100));
	}
}
