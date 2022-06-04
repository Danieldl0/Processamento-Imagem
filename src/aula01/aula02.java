package aula01;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class aula02 {

	public static void main(String[] args) throws IOException {
		BufferedImage imagem = ImageIO.read(new File ("..\\aula2.jpg"));
				
		int w = imagem.getWidth();
		int h = imagem.getHeight();
		
		Color c = new Color(255,255,255);
		
		int metade_x = 994/2 ;
		int metade_y = 459/2;
		
		
		for(int x = 0; x < 995  ; x++) {
			for(int y = 0; y < 460; y++) {
				imagem.setRGB(x, y, c.getRGB());
			}
		}
		
		ImageIO.write(imagem, "png" , new File("..\\aula2.jpg"));

	}

}
