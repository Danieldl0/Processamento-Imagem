package filtros;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.Font;

public class Principal extends JFrame {

	private JPanel contentPane;
	private BufferedImage imagem;
	private JPanel panel_real_img;
	private JPanel panel_controler;
	private JPanel panel_filtro_control;
	private JPanel panel_buttons;
	private BandaRGBPanel bandaRGBPanel;
	private TonalidadePanel tonalidadePanel;
	private GreyScalePanel greyscalePanel;
	private NegativoPanel negativoPanel;
	private BinarizacaoPanel binarizacaoPanel;
	private RgbYiqPanel rgbyiqPanel;
	private BrilhoPanel brilhoPanel;
	private PassaBaixaPanel passaBaixaPanel;
	private PassaAltaPanel passaAltaPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Principal() throws IOException {
		
		bandaRGBPanel = new BandaRGBPanel();
		tonalidadePanel = new TonalidadePanel();
		greyscalePanel = new GreyScalePanel();
		negativoPanel = new NegativoPanel();
		binarizacaoPanel = new BinarizacaoPanel();
		rgbyiqPanel = new RgbYiqPanel();
		brilhoPanel = new BrilhoPanel();
		passaBaixaPanel = new PassaBaixaPanel();
		passaAltaPanel = new PassaAltaPanel();
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 521);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnAbrirImagem = new JButton("nova imagem");
		btnAbrirImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser file = new JFileChooser();
				
				FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
				
				file.setFileFilter(imageFilter);
				file.setCurrentDirectory(new File(""));
				
				int response = file.showOpenDialog(null);
				
				JLabel label_real_img = new JLabel();
				
				if(response == JFileChooser.APPROVE_OPTION) {
					try {
						File caminho = new File(file.getSelectedFile().getAbsolutePath());
						imagem = ImageIO.read(new File (caminho.toString()));
						
						ImageIcon imagemIcon;
						
						//redimensionar a imagem
						int width = imagem.getWidth();
						int height = imagem.getHeight();
						if(width > 335) {
							width = 335;
						}
						if(height > 426) {
							height = 426;
						}
						Image imagemMenor = imagem.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
						imagemIcon = new ImageIcon(imagemMenor);
						
						label_real_img.setIcon(imagemIcon);
						panel_real_img.removeAll();
						panel_real_img.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
						panel_real_img.add(label_real_img);
						panel_buttons.setVisible(true);
						panel_filtro_control.removeAll();
						atualizarFrame();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Erro ao abrir a imagem");
					}
					
				}
				
			}
		});
		menuBar.add(btnAbrirImagem);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_controler = new JPanel();
		panel_controler.setBackground(SystemColor.activeCaption);
		panel_controler.setBounds(0, 0, 227, 457);
		contentPane.add(panel_controler);
		panel_controler.setLayout(null);
		
		panel_buttons = new JPanel();
		panel_buttons.setBackground(SystemColor.activeCaption);
		panel_buttons.setBounds(10, 11, 207, 435);
		panel_controler.add(panel_buttons);
		panel_buttons.setLayout(null);
		panel_buttons.setVisible(false);
		
		JButton bandaRGB_button = new JButton("bandaRGB");
		bandaRGB_button.setBounds(0, 64, 99, 23);
		panel_buttons.add(bandaRGB_button);
		
		JButton tonalidadeRGB_button = new JButton("tonalidade");
		tonalidadeRGB_button.setBounds(108, 64, 99, 23);
		panel_buttons.add(tonalidadeRGB_button);
		
		JButton btnNewButton_7 = new JButton("brilhoRGB");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brilhoPanel.recebeImage(imagem);
				panel_filtro_control.add(brilhoPanel);
				menuClicked(brilhoPanel);
			}
		});
		btnNewButton_7.setBounds(0, 194, 99, 23);
		panel_buttons.add(btnNewButton_7);
		
		JButton greyScale_button = new JButton("greyScale");
		greyScale_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				greyscalePanel.recebeImage(imagem);
				panel_filtro_control.add(greyscalePanel);
				menuClicked(greyscalePanel);
			}
		});
		greyScale_button.setBounds(0, 132, 99, 23);
		panel_buttons.add(greyScale_button);
		
		JLabel lblNewLabel_1 = new JLabel("Filtros");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(68, 11, 72, 23);
		panel_buttons.add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("negativo");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				negativoPanel.recebeImage(imagem);
				panel_filtro_control.add(negativoPanel);
				menuClicked(negativoPanel);
			}
		});
		btnNewButton_4.setBounds(108, 132, 99, 23);
		panel_buttons.add(btnNewButton_4);
		
		JButton rgbyiq_button = new JButton("RGB/YIQ");
		rgbyiq_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rgbyiqPanel.recebeImage(imagem);
				panel_filtro_control.add(rgbyiqPanel);
				menuClicked(rgbyiqPanel);
			}
		});
		rgbyiq_button.setBounds(108, 194, 99, 23);
		panel_buttons.add(rgbyiq_button);
		
		JButton binarizacao_button = new JButton("Binariza\u00E7\u00E3o");
		binarizacao_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binarizacaoPanel.recebeImage(imagem);
				panel_filtro_control.add(binarizacaoPanel);
				menuClicked(binarizacaoPanel);
				
			}
		});
		binarizacao_button.setBounds(41, 255, 120, 23);
		panel_buttons.add(binarizacao_button);
		
		JButton passaBaixa_button = new JButton("passa baixa");
		passaBaixa_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passaBaixaPanel.recebeImage(imagem);
				panel_filtro_control.add(passaBaixaPanel);
				menuClicked(passaBaixaPanel);
			}
		});
		passaBaixa_button.setBounds(41, 323, 120, 23);
		panel_buttons.add(passaBaixa_button);
		
		JButton btnNewButton = new JButton("passa alta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passaAltaPanel.recebeImage(imagem);
				panel_filtro_control.add(passaAltaPanel);
				menuClicked(passaAltaPanel);
			}
		});
		btnNewButton.setBounds(41, 380, 120, 23);
		panel_buttons.add(btnNewButton);
		
		tonalidadeRGB_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tonalidadePanel.recebeImage(imagem);
				panel_filtro_control.add(tonalidadePanel);
				menuClicked(tonalidadePanel);
			}
		});
		
		bandaRGB_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bandaRGBPanel.recebeImage(imagem);
				panel_filtro_control.add(bandaRGBPanel);
				menuClicked(bandaRGBPanel);
			}
		});
		
		panel_real_img = new JPanel();
		panel_real_img.setBackground(SystemColor.infoText);
		panel_real_img.setBounds(237, 11, 340, 435);
		contentPane.add(panel_real_img);
		panel_real_img.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("abrir imagem...");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(135, 202, 103, 14);
		panel_real_img.add(lblNewLabel);
		
		panel_filtro_control = new JPanel();
		panel_filtro_control.setBackground(SystemColor.control);
		panel_filtro_control.setLayout(null);
		panel_filtro_control.setBounds(593, 11, 340, 435);
		contentPane.add(panel_filtro_control);
		
		JLabel lblNewLabel_2 = new JLabel("PROJETO");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(114, 169, 119, 80);
		panel_filtro_control.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Desenvolvido por Daniel de Oliveira");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(39, 355, 340, 80);
		panel_filtro_control.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Processamento de Imagem");
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(35, 0, 295, 80);
		panel_filtro_control.add(lblNewLabel_2_2);
		
		
	}
	
	public void atualizarFrame() {
		this.invalidate();
		this.validate();
		this.repaint();
	}
	
	public void menuClicked(JPanel panel) {
		tonalidadePanel.setVisible(false);
		bandaRGBPanel.setVisible(false);
		greyscalePanel.setVisible(false);
		negativoPanel.setVisible(false);
		binarizacaoPanel.setVisible(false);
		rgbyiqPanel.setVisible(false);
		brilhoPanel.setVisible(false);
		passaBaixaPanel.setVisible(false);
		passaAltaPanel.setVisible(false);
		
		panel.setVisible(true);
	}
}
