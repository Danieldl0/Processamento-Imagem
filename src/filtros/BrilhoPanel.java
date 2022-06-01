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
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class BrilhoPanel extends JPanel {
	
	private Filtros f = new Filtros();
	private BufferedImage img;
	private JTextField Valor;
	private JTextField valor_input;

	/**
	 * Create the panel.
	 */
	public BrilhoPanel() {
		
		setBounds(0, 0, 340, 435);
		setVisible(false);
		setBackground(SystemColor.control);
		setLayout(null);
		
		JRadioButton brilhoRGB = new JRadioButton();
		brilhoRGB.setForeground(SystemColor.controlLtHighlight);
		brilhoRGB.setFont(new Font("Dialog", Font.BOLD, 12));
		brilhoRGB.setBackground(Color.GRAY);
		brilhoRGB.setHorizontalAlignment(SwingConstants.CENTER);
		brilhoRGB.setBounds(86, 88, 178, 30);
		add(brilhoRGB);
		
		JRadioButton brilhoMttRGB = new JRadioButton();
		brilhoMttRGB.setForeground(SystemColor.controlLtHighlight);
		brilhoMttRGB.setFont(new Font("Dialog", Font.BOLD, 12));
		brilhoMttRGB.setBackground(Color.GRAY);
		brilhoMttRGB.setHorizontalAlignment(SwingConstants.CENTER);
		brilhoMttRGB.setBounds(86, 144, 178, 30);
		add(brilhoMttRGB);
		
		JRadioButton brilhoY = new JRadioButton();
		brilhoY.setForeground(SystemColor.controlLtHighlight);
		brilhoY.setFont(new Font("Dialog", Font.BOLD, 12));
		brilhoY.setBackground(Color.GRAY);
		brilhoY.setHorizontalAlignment(SwingConstants.CENTER);
		brilhoY.setBounds(86, 200, 178, 30);
		add(brilhoY);
		
		JRadioButton brilhoMttY = new JRadioButton();
		brilhoMttY.setHorizontalAlignment(SwingConstants.CENTER);
		brilhoMttY.setForeground(Color.WHITE);
		brilhoMttY.setFont(new Font("Dialog", Font.BOLD, 12));
		brilhoMttY.setBackground(Color.GRAY);
		brilhoMttY.setActionCommand("blue");
		brilhoMttY.setBounds(86, 251, 178, 30);
		add(brilhoMttY);
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(brilhoRGB);
		group.add(brilhoMttRGB);
		group.add(brilhoY);
		group.add(brilhoMttY);
		brilhoRGB.setActionCommand("rgb");
		brilhoMttRGB.setActionCommand("mttRGB");
		brilhoY.setActionCommand("y");
		brilhoMttY.setActionCommand("mttY");
		
		JLabel valor_label = new JLabel("Valor");
		valor_label.setBounds(44, 320, 30, 14);
		add(valor_label);
		
		valor_input = new JTextField();
		valor_input.setBounds(84, 317, 187, 20);
		add(valor_input);
		valor_input.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = 0.0;
				BufferedImage imgSaida;
				try {
					String opcao = group.getSelection().getActionCommand();
					try {
						String texto = valor_input.getText();
						valor = parseText2Num(texto);
						
						if(opcao == "rgb") {
							imgSaida = f.brilhoRGB(img, (int) valor);
						}else if(opcao == "mttRGB") {
							imgSaida = f.brilhoMttRGB(img, valor);
						}else if(opcao == "y") {
							imgSaida = f.brilhoY(img, (int) valor);
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
		
		JLabel lblNewLabel = new JLabel("Brilho");
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(135, 26, 129, 23);
		add(lblNewLabel);
		
		Valor = new JTextField();
		Valor.setBounds(84, 317, 187, 20);
		add(Valor);
		Valor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("RGB");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(28, 88, 41, 24);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("MttRGB");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(23, 141, 55, 33);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Y");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(44, 200, 30, 26);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("MttY");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_3.setBounds(39, 251, 41, 30);
		add(lblNewLabel_1_3);
		
		
		
	}
	
	public void recebeImage(BufferedImage imagem) {
		this.img = imagem;
	}
	
	public double parseText2Num(String texto) {
		return Double.parseDouble(texto);
	}
}
