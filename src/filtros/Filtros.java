package filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Filtros {

	
	public BufferedImage bandaRGB(BufferedImage img, String banda) {
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		BufferedImage imgSaida = new BufferedImage(width, height, 1);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int rgb = img.getRGB(x, y);
				Color color = new Color(rgb);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getGreen();
				
				Color newRGB;
				switch (banda) 
				{
					case "red":
						newRGB =  new Color(red,0,0);
						break;
					case "green":
						newRGB =  new Color(0,green,0);
						break;
					case "blue":
						newRGB = new Color(0,0,blue);
						break;
					default:
						newRGB = color;
				}
				imgSaida.setRGB(x, y, newRGB.getRGB());
			}
		}
		
		return imgSaida;
	}
	
	
	public BufferedImage tonalidadeRGB(BufferedImage img, String banda, int valor) {
			
		int width = img.getWidth();
		int height = img.getHeight();
		
		BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int rgb = img.getRGB(x, y);
				Color color = new Color(rgb);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				
				Color newRGB;
				switch (banda) 
				{
					case "red":
						int newRed = valor + red;
						red = verificarValorRGB(newRed);
						break;
					case "green":
						int newGreen = valor + green;
						green= verificarValorRGB(newGreen);
						break;
					case "blue":
						int newBlue = valor + blue;
						blue = verificarValorRGB(newBlue);
						break;
					default:
						System.out.println("Dados invalidos");
				}
				newRGB = new Color(red, green, blue);
				imgSaida.setRGB(x, y, newRGB.getRGB());
			}
		}
		
		return imgSaida;
	}
	
	
	private static int verificarValorRGB(int valor) {
		if(valor > 255) {
			valor = 255;
		}else if(valor < 0) {
			valor = 0;
		}
		
		return valor;
	}
	
	
	public BufferedImage greyScale(BufferedImage img, String banda) throws Exception {
			
		int width = img.getWidth();
		int height = img.getHeight();
		
		BufferedImage imgSaida = new BufferedImage(width, height, 1);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int rgb = img.getRGB(x, y);
				Color color = new Color(rgb);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getGreen();
				
				Color newRGB;
				switch (banda) 
				{
					case "red":
						newRGB =  new Color(red,red,red);
						break;
					case "green":
						newRGB =  new Color(green,green,green);
						break;
					case "blue":
						newRGB =  new Color(blue,blue,blue);
						break;
					default:
						throw new Exception("Infome a banda - red, green ou blue");
				}
				imgSaida.setRGB(x, y, newRGB.getRGB());
			}
		}
		
		return imgSaida;
	}
	

	public BufferedImage greyScaleAVG(BufferedImage img) {
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		BufferedImage imgSaida = new BufferedImage(width, height, 1);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int rgb = img.getRGB(x, y);
				Color color = new Color(rgb);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getGreen();
				
				int avg_rgb = (int) (red + green + blue) / 3;
				
				Color newRGB = new Color(avg_rgb, avg_rgb, avg_rgb);
				imgSaida.setRGB(x, y, newRGB.getRGB());
			}
		}
		
		return imgSaida;
	}
	
	
	public BufferedImage negativo(BufferedImage img) {
			
		int width = img.getWidth();
		int height = img.getHeight();
		
		BufferedImage imgSaida = new BufferedImage(width, height, 1);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int rgb = img.getRGB(x, y);
				Color color = new Color(rgb);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getGreen();
				
				
				Color newRGB = new Color(255-red,255-green,255-blue);
				imgSaida.setRGB(x, y, newRGB.getRGB());
			}
		}
		
		return imgSaida;
	}
	

	public BufferedImage binarizacao(BufferedImage img, int limiar) {
			
		int width = img.getWidth();
		int height = img.getHeight();
		
		BufferedImage imgSaida = new BufferedImage(width, height, 1);
		img = greyScaleAVG(img); 
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int rgb = img.getRGB(x, y);
				Color color = new Color(rgb);
				int red = color.getRed();
				
				if(red > limiar) {
					red = 0;
				}else {
					red = 255;
				}
				
				Color newRGB = new Color(red,red,red);
				imgSaida.setRGB(x, y, newRGB.getRGB());
			}
		}
		
		return imgSaida;
	}
	
	public double[][][] rgb2yiq(BufferedImage img) {
		
		int width = img.getWidth();
		int height = img.getHeight();
		double[][][] matrizYIQ = new double[height][width][3];
		//BufferedImage imgSaida = new BufferedImage(width, height, 1); 
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int rgb = img.getRGB(x, y);
				Color color = new Color(rgb);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getGreen();
				
				matrizYIQ[y][x][0] = (0.299*red) + (0.587*green) + (0.114*blue);
				matrizYIQ[y][x][1] = (0.596*red) - (0.274*green) - (0.322*blue);
				matrizYIQ[y][x][2] = (0.211*red) - (0.523*green) + (0.312*blue);
				

			}
		}
		
		return matrizYIQ;
	}
	
	public BufferedImage yiq2rgb(double[][][] matrizYIQ) {
		
		int width = matrizYIQ[0].length;
		int height = matrizYIQ.length;
		
		BufferedImage imgSaida = new BufferedImage(width, height, 1);
	
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
			
				
				int red = (int) (matrizYIQ[y][x][0] + 0.956 * matrizYIQ[y][x][1] + 0.621 * matrizYIQ[y][x][2]);
                int green = (int) (matrizYIQ[y][x][0] - 0.272* matrizYIQ[y][x][1] - 0.647* matrizYIQ[y][x][2]);
                int blue = (int) (matrizYIQ[y][x][0] - 1.106 * matrizYIQ[y][x][1] + 1.703 * matrizYIQ[y][x][2]);
				
                
                red = verificarValorRGB(red);
                green = verificarValorRGB(green);
                blue = verificarValorRGB(blue);
                
           
				Color newRGB = new Color(red,green,blue);
                imgSaida.setRGB(x,y,newRGB.getRGB());
			}
		}
		
		return imgSaida;
	}
	
	public BufferedImage brilhoRGB(BufferedImage img, int valor) {
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int rgb = img.getRGB(x, y);
				Color color = new Color(rgb);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				
				int newRed = red + valor;
				red = verificarValorRGB(newRed);
				int newGreen = green + valor;
				green = verificarValorRGB(newGreen);
				int newBlue = blue + valor;
				blue = verificarValorRGB(newBlue);
				
				
				Color newRGB = new Color(red, green, blue);
				imgSaida.setRGB(x, y, newRGB.getRGB());
			}
		}
		
		return imgSaida;
	}
	
	public BufferedImage brilhoMttRGB(BufferedImage img, double valor) {
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		BufferedImage imgSaida = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0 ; y < height; y++) {
			for(int x = 0; x < width; x++){
				int rgb = img.getRGB(x, y);
				Color color = new Color(rgb);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				
				int newRed = (int) (red * valor);
				red = verificarValorRGB(newRed);
				int newGreen = (int) (green * valor);
				green = verificarValorRGB(newGreen);
				int newBlue = (int) (blue * valor);
				blue = verificarValorRGB(newBlue);
				
				Color newRGB = new Color(red, green, blue);
				imgSaida.setRGB(x, y, newRGB.getRGB());
			}
		}
		
		return imgSaida;
		
	}
	
	public BufferedImage brilhoY(BufferedImage img, int valor) {
			
		double[][][] imgYIQ = rgb2yiq(img);
		
		int width = imgYIQ[0].length;
		int height = imgYIQ.length;
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				imgYIQ[y][x][0]+= valor;
			}
		}
		
		BufferedImage imgRGB =  yiq2rgb(imgYIQ);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				
			}
		}
		
		
		return imgRGB;
	}
	
	public BufferedImage brilhoMttY(BufferedImage img, int valor) {
		
		double[][][] imgYIQ = rgb2yiq(img);
		
		int width = imgYIQ[0].length;
		int height = imgYIQ.length;
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				imgYIQ[y][x][0]*= valor;
			}
		}
		
		BufferedImage imgRGB =  yiq2rgb(imgYIQ);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				
			}
		}
		
		
		return imgRGB;
	}
	
	public BufferedImage negativoY(BufferedImage img) {
		double[][][] imgYIQ = rgb2yiq(img);
		
		int width = imgYIQ[0].length;
		int height = imgYIQ.length;
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				imgYIQ[y][x][0] = 255 - imgYIQ[y][x][0];
			}
		}
		
		BufferedImage imgRGB =  yiq2rgb(imgYIQ);
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				
			}
		}
		
		
		return imgRGB;
	}
	
}
