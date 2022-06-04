package aula01;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FiltrosRGB f = new FiltrosRGB();
		BufferedImage imagem = ImageIO.read(new File ("..\\eu.jpeg"));
		BufferedImage imagemSaida = null;
		// mostrar Banda R, G ou B
		//imagemSaida = FiltrosRGB.bandaRGB(imagem, "red");
		
		// aumentar tonalidade da Banda R, G ou B
		//imagemSaida = f.tonalidadeRGB(imagem, "green", -500 );
		
		//greyscale banda R g ou B
		/*try {
			imagemSaida = FiltrosRGB.greyScale(imagem, "red");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			
		//greyscale media
		//imagemSaida = FiltrosRGB.greyScaleAVG(imagem);
		
		
		//negativo
		//imagemSaida = f.negativo(imagem);
		
		//binarização
		//imagemSaida = FiltrosRGB.binarização(imagem, 50);
		
		//rgb para yiq e yiq para rgb
		//imagemSaida = FiltrosRGB.yiq2rgb(FiltrosRGB.rgb2yiq(imagem));
		
		//brilhoRGB
		//imagemSaida = f.brilhoRGB(imagem, -100);
		
		//brilhoMttRGB
		//imagemSaida = f.brilhoMttRGB(imagem, 0.05);
		
		//brilhoY
		//imagemSaida = f.brilhoY(imagem, 50);
		
		//brilhoMttY
		//imagemSaida = f.brilhoMttRGB(imagem, 0.1);
		
		//negativoY
		//imagemSaida = f.negativoY(imagem);
		
		JLabel label = new JLabel();
		ImageIcon imagemIcon = new ImageIcon(imagemSaida);
		
		label.setIcon (imagemIcon);
		
		JPanel panel = new JPanel();
		panel.add(label);
		
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(imagemSaida.getWidth(),imagemSaida.getHeight()));
		frame.add(panel);
		frame.setVisible(true);
		
		
		//ImageIO.write(imagemSaida, "jpg" , new File("..\\aula2.jpg"));
	}

}
