package filtros;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PassaAltaPanel extends JPanel {

	private Filtros f = new Filtros();
	private BufferedImage img;

	/**
	 * Create the panel.
	 */
	public PassaAltaPanel() {
		
		setBounds(0, 0, 340, 435);
		setVisible(false);
		setBackground(SystemColor.control);
		setLayout(null);
		
		JRadioButton horizontal = new JRadioButton();
		horizontal.setForeground(SystemColor.controlLtHighlight);
		horizontal.setFont(new Font("Dialog", Font.BOLD, 12));
		horizontal.setBackground(Color.GRAY);
		horizontal.setHorizontalAlignment(SwingConstants.CENTER);
		horizontal.setBounds(86, 108, 178, 30);
		add(horizontal);
		
		JRadioButton vertical = new JRadioButton();
		vertical.setForeground(SystemColor.controlLtHighlight);
		vertical.setFont(new Font("Dialog", Font.BOLD, 12));
		vertical.setBackground(Color.GRAY);
		vertical.setHorizontalAlignment(SwingConstants.CENTER);
		vertical.setBounds(86, 183, 178, 30);
		add(vertical);
		
		JRadioButton oeste = new JRadioButton();
		oeste.setForeground(SystemColor.controlLtHighlight);
		oeste.setFont(new Font("Dialog", Font.BOLD, 12));
		oeste.setBackground(Color.GRAY);
		oeste.setHorizontalAlignment(SwingConstants.CENTER);
		oeste.setBounds(86, 253, 178, 30);
		add(oeste);
		
		JRadioButton laplaciano = new JRadioButton();
		laplaciano.setHorizontalAlignment(SwingConstants.CENTER);
		laplaciano.setForeground(Color.WHITE);
		laplaciano.setFont(new Font("Dialog", Font.BOLD, 12));
		laplaciano.setBackground(Color.GRAY);
		laplaciano.setBounds(86, 324, 178, 30);
		add(laplaciano);

		
		ButtonGroup group = new ButtonGroup();
		
		group.add(horizontal);
		group.add(vertical);
		group.add(oeste);
		group.add(laplaciano);
		horizontal.setActionCommand("horizontal");
		vertical.setActionCommand("vertical");
		oeste.setActionCommand("oeste");
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = 0;
				BufferedImage imgSaida = null;
				
				try {
					String opcao = group.getSelection().getActionCommand();
					try {
						
						if(opcao == "horizontal") {
							double[] kernel = {-1, -1, -1, -1, 8 , -1 ,-1, -1, -1};
							imgSaida = f.convolucao(img, kernel);
						}else if(opcao == "vertical") {
							double[] kernel = {-1, 0, 1, -2, 0, 2, -1, 0 , 1};
							imgSaida = f.convolucao(img, kernel);
						}else if(opcao == "oeste") {
							double[] kernel = {1,1,-1,1,-2,-1,1,1,-1};
							imgSaida = f.convolucao(img, kernel);
						}else {
							double[] kernel = {0,-1,0,-1,4,-1,0,-1,0};
							imgSaida = f.convolucao(img, kernel);
						}
						FiltroPanel filtroPanel = new FiltroPanel();
						filtroPanel.mostrarImage(imgSaida);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Erro");
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma opção");
				}
				
				
			}
		});
		
		
		btnNewButton.setBounds(121, 384, 99, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Passa baixa");
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(107, 27, 129, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("horizontal");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(150, 76, 99, 24);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("vertical");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(155, 143, 55, 33);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("oeste");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(161, 220, 88, 26);
		add(lblNewLabel_1_2);
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("laplaciano");
		lblNewLabel_1_2_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(148, 291, 88, 26);
		add(lblNewLabel_1_2_1);
		
		
		
	}
	
	public void recebeImage(BufferedImage imagem) {
		this.img = imagem;
	}
}
