package aula01;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PintarRGB {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedImage imagem = ImageIO.read(new File ("..\\aula2.jpg"));
		
		int w = imagem.getWidth();
		int h = imagem.getHeight();
		
		Color c = new Color(0,0,255);  //0,0,255 Blue - 0,255,0 Green - 255,0,0 Red
		
			
		for(int x = 0; x < w  ; x++) {
			for(int y = 0; y < h; y++) {
				imagem.setRGB(x, y, c.getRGB());
			}
		}
		
		ImageIO.write(imagem, "png" , new File("..\\aula2.jpg"));
	}

}
