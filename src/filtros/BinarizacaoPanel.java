package filtros;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.awt.image.BufferedImage;

public class BinarizacaoPanel extends JPanel {
	
	private Filtros f = new Filtros();
	private BufferedImage img;

	
	/**
	 * Create the panel.
	 */
	public BinarizacaoPanel() {
		
		setBounds(0, 0, 340, 435);
		setVisible(false);
		setBackground(SystemColor.control);
		setLayout(null);
		
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setValue(255);
		slider.setMaximum(255);
		slider.setBounds(61, 138, 200, 160);
		add(slider);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage imgSaida = f.binarizacao(img, slider.getValue());
				FiltroPanel filtroPanel = new FiltroPanel();
				filtroPanel.mostrarImage(imgSaida);
				
			}
		});
		
		btnNewButton.setBounds(121, 374, 99, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Binariza\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(121, 26, 115, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("255");
		lblNewLabel_1.setBounds(140, 125, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("0");
		lblNewLabel_1_1.setBounds(140, 296, 46, 14);
		add(lblNewLabel_1_1);
		
	}
	
	public void recebeImage(BufferedImage imagem) {
		this.img = imagem;
	}
}
