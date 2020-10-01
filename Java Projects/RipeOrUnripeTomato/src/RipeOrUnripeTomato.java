import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class RipeOrUnripeTomato {
	static String path;
	public static void getFilePath() throws IOException {
		JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, JPEG & PNG Images", "jpg","jpeg", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	String fileName = chooser.getSelectedFile().getName();
        	File file = new File(fileName);
        	path = file.getAbsolutePath();
        }
	}
	public static boolean isRipe() throws IOException {
		boolean foundRipe = false;
		int x, y, xRad, yRad;
		File picture = new File(path);
		BufferedImage image = ImageIO.read(picture);
		for (x = 0; x < image.getWidth(); x++) {
			for (y = 0; y < image.getHeight(); y++) {
				int clr = image.getRGB(x, y);
				int red = (clr & 0x00ff0000) >> 16;
            	int green = (clr & 0x0000ff00) >> 8;
            	int blue = clr & 0x000000ff;
            	if (red >= 200 && green <= 75 && blue <= 50) {
            		for (xRad = 0; xRad < 10; xRad++) {
            			for (yRad = 0; yRad < 10; yRad++) {
							int rad = image.getRGB((x + xRad), (y + yRad));
            				int radRed = (rad & 0x00ff0000) >> 16;
                    		int radGreen = (rad & 0x0000ff00) >> 8;
                    		int radBlue = rad & 0x000000ff;
                    		if (radRed >= 180 && radGreen <= 75 && radBlue <= 50)
                    			foundRipe = true;
                    		else {
                    			foundRipe = false;
                    			break;
                    		}
            			}
            			if (foundRipe == true)
            				break;
            		}
            		if (foundRipe == true)
            			break;
            	}
            	if (foundRipe == true)
        			break;
			}
			if (foundRipe == true)
    			break;
			y = 0;
		}
		return foundRipe;
	}
	public static void main(String args[]) throws IOException {
		getFilePath();
		if (isRipe()) 
			System.out.println("Ripe");
		else
			System.out.println("Not ripe");
	}
}