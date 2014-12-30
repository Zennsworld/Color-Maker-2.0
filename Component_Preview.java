import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Component_Preview extends Component {

	public Component_Preview(int x, int y, int w, int h, boolean hitbox, Panel panel) {
		super(x, y, w, h, hitbox, panel);
	}

	public BufferedImage drawRegular(){
		Graphics2D g = super.drawRegular().createGraphics();
		g.setColor(panel.convertColor(panel.hue, panel.brightness, panel.sateration));
		g.fillRect(1, 1, width, height);
		return image;
	}
}
