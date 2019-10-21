

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class PanelMind extends JPanel {

	private static final long serialVersionUID = 1L;

	public Combinaison combinaison;
	Color couleurs[] = {Color.WHITE,Color.BLUE,Color.GREEN,Color.MAGENTA
						,Color.ORANGE,Color.RED,Color.YELLOW,Color.gray};

	public PanelMind() {
		setBackground(Color.pink);
		combinaison=new Combinaison();
	}
		
	

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);


		
		dessinCombinaison(combinaison, graphics);
				
	}

	final int rayon=30;
	final int tailleBord = 50;
	final int espace=60;

	
	
	

	void dessinCombinaison(Combinaison combinaison, Graphics graphics) {
		int x=tailleBord;
		int y=tailleBord;
		
		for (int i=0; i<combinaison.t.length; i++)
		{
			graphics.setColor(couleurs[combinaison.t[i]]);
			graphics.fillOval(x+i*espace, y, rayon, rayon);
			
			graphics.setColor(Color.BLACK);
			graphics.drawOval(x+i*espace, y, rayon, rayon);
		}
	}
	
	
	
}
