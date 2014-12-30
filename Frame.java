import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Frame extends JFrame {
	public Frame (){
		Panel panel = new Panel (this);  
		this.add(panel);
		this.setResizable(false);
		this.setSize(600,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
