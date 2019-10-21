

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FenetreMind extends JFrame {
	/** */
	private static final long serialVersionUID = 1L;

	public FenetreMind() {
		
		setTitle("Master Mind");
		setSize(800, 800);
		PanelMind panel = new PanelMind();
		add(panel);
		

	}
}
