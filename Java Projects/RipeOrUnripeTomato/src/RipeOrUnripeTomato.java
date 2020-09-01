import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class RipeOrUnripeTomato {
	public static void main(String args[]) throws IOException {
		int width = 2513;
		int height = 1997;
		BufferedImage image = null;
		try {
			File inputFile = new File("C:\\Users\\Thomas Zhang\\eclipse-workspace\\RipeOrUnripeTomato\\RipeTomato.jpg");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(inputFile);
			System.out.println("Reading complete.");
		}	
		catch(IOException e) {
			System.out.println("Error: " + e);
		}
		try {
			File outputFile = new File("C:\\Users\\Thomas Zhang\\eclipse-workspace\\RipeOrUnripeTomato\\New.jpg");
			ImageIO.write(image, "jpg", outputFile);
			System.out.println("Writing complete.");
		}
		catch(IOException e) {
			System.out.println("Error: " + e);
		}
	}
}