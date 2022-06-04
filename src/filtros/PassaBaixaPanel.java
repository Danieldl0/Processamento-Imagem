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

public class PassaBaixaPanel extends JPanel {

	private Filtros f = new Filtros();
	private BufferedImage img;
	private JTextField valor_input;

	/**
	 * Create the panel.
	 */
	public PassaBaixaPanel() {
		
		setBounds(0, 0, 340, 435);
		setVisible(false);
		setBackground(SystemColor.control);
		setLayout(null);
		
		JRadioButton mediana = new JRadioButton();
		mediana.setForeground(SystemColor.controlLtHighlight);
		mediana.setFont(new Font("Dialog", Font.BOLD, 12));
		mediana.setBackground(Color.GRAY);
		mediana.setHorizontalAlignment(SwingConstants.CENTER);
		mediana.setBounds(86, 108, 178, 30);
		add(mediana);
		
		JRadioButton media = new JRadioButton();
		media.setForeground(SystemColor.controlLtHighlight);
		media.setFont(new Font("Dialog", Font.BOLD, 12));
		media.setBackground(Color.GRAY);
		media.setHorizontalAlignment(SwingConstants.CENTER);
		media.setBounds(86, 183, 178, 30);
		add(media);
		
		JRadioButton convolucao = new JRadioButton();
		convolucao.setForeground(SystemColor.controlLtHighlight);
		convolucao.setFont(new Font("Dialog", Font.BOLD, 12));
		convolucao.setBackground(Color.GRAY);
		convolucao.setHorizontalAlignment(SwingConstants.CENTER);
		convolucao.setBounds(86, 253, 178, 30);
		add(convolucao);
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(mediana);
		group.add(media);
		group.add(convolucao);
		mediana.setActionCommand("mediana");
		media.setActionCommand("media");
		convolucao.setActionCommand("convolucao");
		
		JLabel valor_label = new JLabel("tamanho kernel");
		valor_label.setBounds(131, 329, 143, 14);
		add(valor_label);
		
		valor_input = new JTextField();
		valor_input.setBounds(77, 342, 187, 20);
		add(valor_input);
		valor_input.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = 0;
				BufferedImage imgSaida = null;
				try {
					String opcao = group.getSelection().getActionCommand();
					try {
						String texto = valor_input.getText();
						valor = parseText2Num(texto);
						
						if(opcao == "mediana") {
							imgSaida = f.mediana(img, valor);
						}else if(opcao == "media") {
							imgSaida = f.media(img, valor);
						}else if(opcao == "convolucao") {
							double[] gaus3x3 = {0.0625, 0.125, 0.0625, 0.125, 0.25, 0.125, 0.0625, 0.125, 0.0625};
							double[] gaus5x5 =  {1.0/256, 4.0/256, 6.0/256, 4.0/256, 1.0/256,
												4.0/256, 16.0/256, 24.0/256, 16.0/256, 4.0/256,
												6.0/256, 24.0/256, 36.0/256, 24.0/256, 6.0/256,
												4.0/256, 19.0/256, 24.0/256, 16.0/256, 4.0/256,
												1.0/256, 4.0/256, 6.0/256, 4.0/256, 1.0/256};
							if (valor == 3) {
								imgSaida = f.convolucao(img, gaus3x3);								
							}else if (valor == 5) {
								imgSaida = f.convolucao(img, gaus5x5);
							}

						}else {
							imgSaida = f.brilhoMttY(img, (int) valor);
						}
						
						FiltroPanel filtroPanel = new FiltroPanel();
						filtroPanel.mostrarImage(imgSaida);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Informe um Valor valido!");
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma opção");
				}
				
				
			}
		});
		
		
		btnNewButton.setBounds(121, 373, 99, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Passa baixa");
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(107, 27, 129, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("mediana");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(150, 76, 99, 24);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("media");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(155, 143, 55, 33);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("convolucao");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(146, 220, 88, 26);
		add(lblNewLabel_1_2);
		
		
		
	}
	
	public void recebeImage(BufferedImage imagem) {
		this.img = imagem;
	}
	
	public int parseText2Num(String texto) {
		return Integer.parseInt(texto);
	}

}
