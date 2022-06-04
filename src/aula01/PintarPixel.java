package aula01;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PintarPixel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedImage imagem = ImageIO.read(new File ("..\\aula2.jpg"));
		
		int w = imagem.getWidth();
		int h = imagem.getHeight();
		
		Color c = new Color(0,0,0);  //0,0,255 Blue - 0,255,0 Green - 255,0,0 Red
		
		
		//pintar primerio pixel
		//imagem.setRGB(0, 0, c.getRGB());
		
		//pintar ultimo pixel
		//imagem.setRGB(w-1, h-1, c.getRGB());
		
		//pintar metade pixel
		imagem.setRGB((w-1)/2, (h-1)/2, c.getRGB());
		
		

		ImageIO.write(imagem, "png" , new File("..\\aula2.jpg"));
	}

}
