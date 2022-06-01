package filtros;

import javax.swing.JPanel;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class RgbYiqPanel extends JPanel {
	
	private Filtros f = new Filtros();
	private BufferedImage img;
	private double[][][] imgYIQ;
	
	/**
	 * Create the panel.
	 */
	public RgbYiqPanel() {
		
		setBounds(0, 0, 340, 435);
		setVisible(false);
		setBackground(SystemColor.control);
		setLayout(null);
		
		
		JButton btnNewButton = new JButton("RGB 2 YIQ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgYIQ = f.rgb2yiq(img);
				JOptionPane.showMessageDialog(null, "Imagem convertida para YIQ");
				
			}
		});
		
		btnNewButton.setBounds(121, 139, 99, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("RGB / YIQ");
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(121, 26, 108, 23);
		add(lblNewLabel);
		
		JButton btnYiqRgb = new JButton("YIQ 2 RGB");
		btnYiqRgb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					BufferedImage imgSaida = f.yiq2rgb(imgYIQ);
					FiltroPanel filtroPanel = new FiltroPanel();
					filtroPanel.mostrarImage(imgSaida);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Você precisa converter a imagem para YIQ primeiro");
				}
				
				
				
			}
		});
		btnYiqRgb.setBounds(121, 255, 99, 23);
		add(btnYiqRgb);
	}
	
	public void recebeImage(BufferedImage imagem) {
		this.img = imagem;
	}
}
