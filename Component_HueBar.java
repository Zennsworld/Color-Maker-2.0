import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Component_HueBar extends Component{
	
	int barY = 0;
	
	public Component_HueBar(int x, int y, int w, int h, boolean hitbox, Panel panel) {
		super(x, y, w, h, hitbox, panel);
	}
	
	public BufferedImage drawRegular(){
		Graphics2D g = super.drawRegular().createGraphics();
		float height = this.height;
		for (int i=0;i<height;i++){
			g.setColor(panel.convertColor((int)(1530/height*i), 100, 100));
			g.fillRect(1, 1 + i, width, 1);
		}
		return image;
	}
	
	public BufferedImage drawPressed (){
		Graphics2D g = super.drawPressed().createGraphics();
		float height = this.height;
		for (int i=0;i<height;i++){
			g.setColor(panel.convertColor((int)(1530/height*i), 100, 100));
			g.fillRect(1, 1 + i, width, 1);
		}
		return image;
	}
			
	public void pressed (int mouseX, int mouseY){
		barY = mouseY - y;
		float height = this.height;
		panel.hue = (int) (barY * (1530 / height));
	}
}
