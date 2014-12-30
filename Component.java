import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class Component {
	
	int x;
	int y;
	int width;
	int height;
	boolean hitbox;
	
	Panel panel;
	
	BufferedImage image;
	Graphics2D g;
	
	int EVENT = 0;
	final static int MOUSEOVER = 1;
	final static int PRESSED = 2;
	
	public Component (int x, int y, int w, int h, boolean hitbox, Panel panel){
		this.x = x - 1;
		this.y = y - 1;
		width = w;
		height = h;
		this.hitbox = hitbox;
		this.panel = panel;
		image = new BufferedImage(width+2,height+2,BufferedImage.TYPE_INT_ARGB);
		g = image.createGraphics();
	}
	
	/** All extended class drawings must have 1 added to the x and y axis because of borders **/
	
	public BufferedImage draw (){
		switch (EVENT){
		case (MOUSEOVER):
			return drawMouseOver();
		case (PRESSED):
			return drawPressed();
		default:
			return drawRegular();
		}
	}
	
	public BufferedImage drawRegular (){
		g.setColor(Color.black);
		g.drawRect(0, 0, width+1, height+1);
		return image;
	}
	
	public BufferedImage drawMouseOver (){
		g.setColor(new Color (0,200,0));
		g.drawRect(0, 0, width+1, height+1);
		return image;
	}
	
	public BufferedImage drawPressed (){
		g.setColor(Color.red);
		g.drawRect(0, 0, width+1, height+1);				
		return image;
	}
	
	public void pressed (int mouseX, int mouseY){
		
	}
	
	public void dragged (int mouseX, int mouseY){
		
	}
	
	public void keyPressed (KeyEvent e){
		
	}
}
