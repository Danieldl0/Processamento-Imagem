package filtros;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class NegativoPanel extends JPanel {
	private Filtros f = new Filtros();
	private BufferedImage img;
	/**
	 * Create the panel.
	 */
	public NegativoPanel() {
		setBounds(0, 0, 340, 435);
		setVisible(false);
		setBackground(SystemColor.control);
		setLayout(null);
		
		
		JCheckBox check_avg = new JCheckBox("RGB");
		check_avg.setBounds(123, 149, 97, 23);
		add(check_avg);
		
		
		JLabel lblNewLabel = new JLabel("Negativo");
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(121, 26, 117, 23);
		add(lblNewLabel);
		
		JCheckBox check_avg_1 = new JCheckBox("Y");
		check_avg_1.setBounds(123, 264, 97, 23);
		add(check_avg_1);
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(check_avg);
		group.add(check_avg_1);
		check_avg.setActionCommand("rgb");
		check_avg_1.setActionCommand("y");
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage imgSaida = null;
				try {
					String selecionado = group.getSelection().getActionCommand();
					if(selecionado == "rgb") {
						imgSaida = f.negativo(img);
					}else{
						imgSaida = f.negativoY(img);
					}
					FiltroPanel filtroPanel = new FiltroPanel();
					filtroPanel.mostrarImage(imgSaida);
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Precisa selecionar uma opção");
				}
				
		
				
				
				
			}
		});
		btnNewButton.setBounds(121, 373, 99, 23);
		add(btnNewButton);
	}
	
	public void recebeImage(BufferedImage imagem) {
		this.img = imagem;
	}
	
}
