package filtros;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FiltroPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public FiltroPanel() {
		setBackground(SystemColor.textHighlight);
		setBounds(0, 0, 340, 435);
		setLayout(null);
		
		
	}
	
	public void mostrarImage(BufferedImage imgSaida) {
		JLabel label = new JLabel();
		Image imagemMenor = imgSaida.getScaledInstance(335, 426, Image.SCALE_AREA_AVERAGING);
		ImageIcon imageIcon = new ImageIcon(imagemMenor);
		label.setIcon(imageIcon);
		JPanel panel = new JPanel();
		panel.add(label);
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(340	, 430) );
		frame.add(panel);
		frame.setVisible(true);
	}
}
