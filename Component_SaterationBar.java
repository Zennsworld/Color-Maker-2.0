import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Component_SaterationBar extends Component{
	
	int barX = 0;
	
	public Component_SaterationBar(int x, int y, int w, int h, boolean hitbox, Panel panel) {
		super(x, y, w, h, hitbox, panel);
	}
	
	public BufferedImage drawRegular(){
		barX = (int)(panel.sateration * (width / 100));
		Graphics2D g = super.drawRegular().createGraphics();
		float width = this.width;
		for (int i=0;i<width;i++){
			g.setColor(panel.convertColor(panel.hue, 100, (int) (i * (100 / width))));
			g.fillRect(1 + i, 1, 1, height);
		}
		g.setColor(Color.black);
		g.fillRect(1 + barX, 1, 1, height);
		return image;
	}
	
	public BufferedImage drawPressed (){
		barX = (int)(panel.sateration * (width / 100));
		Graphics2D g = super.drawPressed().createGraphics();
		float width = this.width;
		for (int i=0;i<width;i++){
			g.setColor(panel.convertColor(panel.hue, 100, (int) (i * (100 / width))));
			g.fillRect(1 + i, 1, 1, height);
		}
		g.setColor(Color.black);
		g.fillRect(1 + barX, 1, 1, height);
		return image;
	}
			
	public void pressed (int mouseX, int mouseY){
		float width = this.width;
		panel.sateration = (int) ((mouseX - x) * (100 / width));
	}
}
