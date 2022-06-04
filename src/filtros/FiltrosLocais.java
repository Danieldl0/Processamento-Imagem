package filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class FiltrosLocais {
	
	public BufferedImage media(BufferedImage img, int tamVizinhaca) {

	    

	    int width = img.getWidth();

	    int height = img.getHeight();

	    

	    BufferedImage imgSaida = img;

	    

	    int tamKernel = tamVizinhaca / 2;

	    

	    for(int y = tamKernel; y < height-tamKernel; y++) {

	      for(int x = tamKernel; x < width-tamKernel; x++) {



	        int soma = 0;

	        for(int i = x-tamKernel; i <= x+tamKernel; i++){

	          for(int j = y-tamKernel; j <= y+tamKernel; j++){

	            Color cor = new Color(img.getRGB(i,j));

	            int red = cor.getRed();

	            soma += red;

	          }

	        }

	        

	        int media = soma/(tamVizinhaca*tamVizinhaca);

	                

	        Color newRGB = new Color(media,media,media);

	        imgSaida.setRGB(x, y, newRGB.getRGB());

	      }

	    }

	    

	    return imgSaida;

	  }

	  

	  public BufferedImage mediana(BufferedImage img, int tamVizinhaca) {

	    

	    int width = img.getWidth();

	    int height = img.getHeight();

	    

	    BufferedImage imgSaida = img;

	    

	    int tamKernel = tamVizinhaca / 2;



	    for(int y = tamKernel; y < height-tamKernel; y++) {

	      for(int x = tamKernel; x < width-tamKernel; x++) {

	        

	        int[] valores = new int[tamVizinhaca*tamVizinhaca];

	        int count = 0;



	        for(int i = x-tamKernel; i <= x+tamKernel; i++){

	          for(int j = y-tamKernel; j <= y+tamKernel; j++){

	            Color cor = new Color(img.getRGB(i,j));

	            int red = cor.getRed();

	            valores[count] = red;

	            count++;

	          }

	        }



	        Arrays.sort(valores);

	        int mediana = valores[tamVizinhaca*tamVizinhaca/2];



	        Color newRGB = new Color(mediana,mediana,mediana);

	        imgSaida.setRGB(x, y, newRGB.getRGB());

	      }

	    }

	    

	    return imgSaida;

	  }

}
