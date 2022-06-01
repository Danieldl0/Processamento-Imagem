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
import javax.swing.JCheckBox;

public class GreyScalePanel extends JPanel {

	private Filtros f = new Filtros();
	private BufferedImage img;

	/**
	 * Create the panel.
	 */
	public GreyScalePanel() {
		setBounds(0, 0, 340, 435);
		setVisible(false);
		setBackground(SystemColor.control);
		setLayout(null);
		
		JRadioButton redRadioButton = new JRadioButton();
		redRadioButton.setForeground(SystemColor.controlLtHighlight);
		redRadioButton.setFont(new Font("Dialog", Font.BOLD, 12));
		redRadioButton.setBackground(new Color(255, 51, 51));
		redRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		redRadioButton.setBounds(86, 119, 178, 30);
		add(redRadioButton);
		
		JRadioButton greenRadioButton = new JRadioButton();
		greenRadioButton.setForeground(SystemColor.controlLtHighlight);
		greenRadioButton.setFont(new Font("Dialog", Font.BOLD, 12));
		greenRadioButton.setBackground(new Color(0, 204, 51));
		greenRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		greenRadioButton.setBounds(86, 185, 178, 30);
		add(greenRadioButton);
		
		JRadioButton blueRadioButton = new JRadioButton();
		blueRadioButton.setForeground(SystemColor.controlLtHighlight);
		blueRadioButton.setFont(new Font("Dialog", Font.BOLD, 12));
		blueRadioButton.setBackground(SystemColor.textHighlight);
		blueRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		blueRadioButton.setBounds(86, 250, 178, 30);
		add(blueRadioButton);
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(redRadioButton);
		group.add(greenRadioButton);
		group.add(blueRadioButton);
		redRadioButton.setActionCommand("red");
		greenRadioButton.setActionCommand("green");
		blueRadioButton.setActionCommand("blue");
		
		JCheckBox check_avg = new JCheckBox("AVG");
		check_avg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				group.clearSelection();
			}
		});
		check_avg.setBounds(86, 322, 97, 23);
		add(check_avg);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage imgSaida = null;
				try {
					if(check_avg.isSelected()) {
						imgSaida = f.greyScaleAVG(img);
					}else {
						String banda = group.getSelection().getActionCommand();
						imgSaida = f.greyScale(img, banda);
					}
					FiltroPanel filtroPanel = new FiltroPanel();
					filtroPanel.mostrarImage(imgSaida);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Precisa selecionar uma banda ou marcar a opção AVG");
				}
				
				
				
				
			}
		});
		
		
		btnNewButton.setBounds(121, 373, 99, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("GreyScale");
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 20));
		lblNewLabel.setBounds(121, 26, 117, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RED");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(42, 129, 38, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("GREEN");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(32, 190, 48, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("BLUE");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(42, 260, 38, 14);
		add(lblNewLabel_1_2);
		
	}
	
	public void recebeImage(BufferedImage imagem) {
		this.img = imagem;
	}
}
