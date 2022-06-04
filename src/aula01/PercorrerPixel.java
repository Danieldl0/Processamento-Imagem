package aula01;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PercorrerPixel {

	public static void main(String[] args) throws IOException {
		//percorrer imagem pixel por pixel e pegar seu rgb
		
		BufferedImage imagem = ImageIO.read(new File ("..\\aula2.jpg"));
		
		int w = imagem.getWidth();
		int h = imagem.getHeight();
		
		int blue,red,green;
		
		Color c;
		
		for(int y = 0; y < w; y++){
			for(int x = 0; x < h; x++) {
				int rgb = imagem.getRGB(x, y);
				c = new Color(rgb);
				blue = c.getBlue();
				red = c.getRed();
				green = c.getGreen();
				//System.out.println(red + " "  + blue + " " + green);
			}	
		}
		
		
	}

}
