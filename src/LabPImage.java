import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.lang.UnsupportedOperationException;
 
/**
 * LabPImage is a wrapper arround the BufferedImage class.
 * It adds some facilities to access individual pixels components (color
 * and transparency). 
 * The coordinate system used by the methods is such that the origin is
 * at the upper left corner.
 *
 * @author Thibault Langlois
 *
 */
public class LabPImage
{
    /**
     * This is a java.awt.image.BufferedImage object. 
     */
    private BufferedImage im;

    /**
     * Makes a new image initialized with the contents of an image file.
     * The image my be in jpeg or png format.
     * @requires The file contains an image in png or jpeg format.
     * @ensures A new object that contains image's pixels is created.
     * @param file
     * @throws IOException
     */
    public LabPImage(File file) throws IOException {
        BufferedImage temp = ImageIO.read(file);
        // The kind of BufferedImage returned by ImageIO.read 
        // does not allow the manipulation of the alpha channel.
        // The work-arround solution is to make a new image and 
        // copy pixels to it. (Ugly)
        im = new BufferedImage(temp.getWidth(), temp.getHeight(), 
                               BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < temp.getWidth(); i++) {
            for (int j = 0; j < temp.getHeight(); j++) {
                int r = (temp.getRGB(i, j) & 0x00FF0000)  >>> 16 ;
                int g = (temp.getRGB(i, j) & 0x0000FF00)  >>> 8 ;
                int b = (temp.getRGB(i, j) & 0x000000FF) ;
                setPixelRGBWithTransparency(i, j, r, g, b, 255);
            }
        }        
    }
 
    /**
     * Makes a LabPImage instance, initialized with an image file. The argument 
     * is the name of the file that contains the image. The image may be in 
     * jpeg or png format.
     * @requires The filename argument correspond to an existing file that 
     * an image in png or jpeg format. 
     * @ensures A new object that contains image's pixels is created.
     * @param filename
     * @throws IOException
     */
    public LabPImage(String filename) throws IOException {
        // The kind of BufferedImage returned by ImageIO.read 
        // does not allow the manipulation of the alpha channel.
        // The work-arround solution is to make a new image and 
        // copy pixels to it. (Ugly)
        BufferedImage temp = ImageIO.read(new File(filename));
        im = new BufferedImage(temp.getWidth(), temp.getHeight(), 
                               BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < temp.getWidth(); i++) {
            for (int j = 0; j < temp.getHeight(); j++) {
                int r = (temp.getRGB(i, j) & 0x00FF0000)  >>> 16 ;
                int g = (temp.getRGB(i, j) & 0x0000FF00)  >>> 8 ;
                int b = (temp.getRGB(i, j) & 0x000000FF) ;
                setPixelRGBWithTransparency(i, j, r, g, b, 255);
            }
        }
    }
 
    /**
     * Makes a new empty image.
     * @requires The requested image size must not exceed the
     * available virtual memory of the machine. 
     * @ensures A new object that contains transparent pixels is created.
     * @param width
     * @param height
     */
    public LabPImage(int width, int height) {
        im = new BufferedImage(width, height, 
                               BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * Writes the image to a java.io.File in jpeg format.
     * <b>Not implemented !</b>
     * @param file
     * 
     */
    public void writeImageToJPG (File file) {
        // ImageIO.write(im, "jpg", file);
        throw new UnsupportedOperationException();
    }

    /**
     * Writes the image to a file (the file name is given) in jpeg
     * format.
     * <b>Not implemented !</b>
     * @requires The filename argument is a valid file name for the
     * file system being used. 
     * @ensures A new file is created that contains the image in
     * jpeg format.
     * @param filename
     * 
     */
    public void writeImageToJPG (String filename) {
        // ImageIO.write(im, "jpg", new File(filename));
        throw new UnsupportedOperationException();
    }

    /**
     * Writes the image to a file (the filename is given) in png format.
     * @requires The filename argument is a valid file name for the
     * file system being used. 
     * @ensures A new file is created that contains the image in
     * png format.
     * @param filename
     * @throws IOException
     */
    public void writeImageToPNG (String filename) throws IOException {
        ImageIO.write(im,"png", new File(filename));
    }

    /**
     * Writes the image to a file in png format.
     * @requires The file argument is a valid File instance for the
     * file system being used. 
     * @ensures A new file is created that contains the image in
     * png format.
     * @param file
     * @throws IOException
     */
    public void writeImageToPNG (File file) throws IOException {
        ImageIO.write(im, "png", file);
    }

    /**
     * Returns the image's height. 
     * @ensures The returned value is in the interval (0 .. height
     * - 1)
     * @return the image's height  
     */
    public int getHeight() {
        return im.getHeight();
    }

    /**
     * Returns the image's width.
     * @ensures The returned value is in the interval (0 .. height
     * - 1)
     * @return the image's width
     */
    public int getWidth() {
        return im.getWidth();
    }

    /**
     * Returns the pixel's transparency level (0 - 255).
     * @requires x is in (0 .. width - 1) and y is in (0 .. height
     * - 1)
     * @ensures returns a value in the interval (0 .. 255)
     * @param x pixel coordinate      
     * @param y pixel coordinate      
     * 
     * @return the pixel's transparency level   
     */
    public int getPixelTransparency(int x, int y) {	
        return (im.getRGB(x, y) & 0xFF000000)  >>> 24 ;
    }

    /**
     * Returns the red component of pixel (0 - 255).
     * @requires x is in (0 .. width - 1) and y is in (0 .. height
     * - 1)
     * @ensures returns a value in the interval (0 .. 255)
     * 
     * @param     x pixel coordinate      
     * @param     y pixel coordinate            
     * 
     * @return  the pixel red component  
     */
    public int getPixelRed(int x, int y) {	
        return (im.getRGB(x, y) & 0x00FF0000)  >>> 16 ;
    }

    /**
     * Returns the green component of pixel (0 - 255).
     * @requires x is in (0 .. width - 1) and y is in (0 .. height
     * - 1)
     * @ensures returns a value in the interval (0 .. 255)
     * 
     * @param     x pixel coordinate      
     * @param     y pixel coordinate      
     * 
     * @return  the pixel green component  
     */
    public int getPixelGreen(int x, int y) {	
        return (im.getRGB(x, y) & 0x0000FF00)  >>> 8 ;
    }

    /**
     * Returns the blue component of pixel (0 - 255).
     * @requires x is in (0 .. width - 1) and y is in (0 .. height
     * - 1)
     * @ensures returns a value in the interval (0 .. 255)
     * 
     * @param     x pixel coordinate      
     * @param     y pixel coordinate      
     * 
     * @return  the pixel blue component  
     */
    public int getPixelBlue(int x, int y) {	
        return (im.getRGB(x, y) & 0x000000FF);
    }

    /**
     * Set a pixel color. The transparency level remains unchanged.
     * @requires x is in (0 .. width - 1) and y is in (0 .. height
     * - 1) and r, g and b are in the interval (0 .. 255)
     * @ensures The corresponding pixel is changed according to
     * the given values.
     * 
     * @param     x pixel coordinate      
     * @param     y pixel coordinate      
     * @param     r red component (0 - 255)      
     * @param     g green component (0 - 255)      
     * @param     b blue component (0 - 255)      
     */
    public void setPixelRGB(int x, int y, int r, int g, int b) {
        setPixelRGBWithTransparency(x, y, r, g, b, getPixelTransparency(x, y));
    }

    /**
     * Set a pixel color and transparency.
     * @requires x is in (0 .. width - 1) and y is in (0 .. height
     * - 1) and r, g, b and t are in the interval (0 .. 255)
     * @ensures The corresponding pixel is changed according to
     * the given values.
     * Warning: This method is used interaly by the constructors and by
     * the methods setPixelRGB and setPixelGreyLevel, 
     * @param     x pixel coordinate      
     * @param     y pixel coordinate
     * @param     r red component (0 - 255)      
     * @param     g green component (0 - 255)      
     * @param     b blue component (0 - 255)      
     * @param     t transparency level (0 - 255)      
     */
    public void setPixelRGBWithTransparency(int x, int y, int r, int g, 
                                            int b, int t) {
        im.setRGB(x, y, b  + (g << 8)  + (r << 16) + (t << 24));
    }

    /**
     * Set pixel transparency level. The color remains unchanged.
     * @requires x is in (0 .. width - 1) and y is in (0 .. height
     * - 1) and t is in the interval (0 .. 255)
     * @ensures The corresponding pixel is changed according to
     * the given values.
     * 
     * @param     x pixel coordinate      
     * @param     y pixel coordinate            
     * @param     t transparency level (0 - 255)      
     */
    public void setPixelTransparency(int x, int y, int t) {
        int r = getPixelRed(x, y);
        int g = getPixelGreen(x, y);
        int b = getPixelGreen(x, y);
        int value =  b  + (g << 8)  + (r << 16) + (t << 24);
        im.setRGB(x, y, value);
        if (im.getRGB(x, y) != value) {
            System.err.println("Error in setTransparency. " + value + " rgb " + im.getRGB(x, y) +
                               " diff " + (value - im.getRGB(x, y)));
        }
    }

    /**
     * Returns the grey level of pixel.
     * @requires x is in (0 .. width - 1) and y is in (0 .. height
     * - 1)
     * @ensures returns a value in the interval (0 .. 255)
     * 
     * @param     x pixel coordinate            
     * @param     y pixel coordinate            
     * 
     * @return the grey level of pixel (0 .. 255)   
     */
    public int getPixelGreyLevel(int x, int y) {
        return ((getPixelRed(x, y) + getPixelGreen(x, y) + 
                 getPixelBlue(x, y)) / 3);
    }

    /**
     * Set pixel grey level.
     * @requires x is in (0 .. width - 1) and y is in (0 .. height
     * - 1) and level is in the interval (0 .. 255)
     * @ensures The corresponding pixel is changed according to
     * the given values.
     * 
     * @param     x pixel coordinate      
     * @param     y pixel coordinate            
     * @param     level grey level (0 - 255)      
     */
    public void setPixelGreyLevel(int x, int y, int level) {
        setPixelRGBWithTransparency(x, y, level, level, level, 
                                    getPixelTransparency(x,y));
    }

    private boolean inImage(int x, int y) {
	return (x >= 0) && (x < im.getWidth()) && (y >= 0) && (y < im.getHeight());
    }
    
    
    /**
     * Draws a line between (x1, y1) and (x2, y2). The line color is
     * given by the r, g and b arguments and its transparency by the
     * transparency argument.   
     * 
     * @requires x1 and x2 are zero or positive, y1
     * and y2 are zero or positive, r, g, b and transparency are in the interval (0 .. 255)
     * @ensures The corresponding pixel is changed according to
     * the given values.
     *
     * @param   x1 int     
     * @param   y1 int     
     * @param   x2 int     
     * @param   y2 int     
     * @param   r  int     
     * @param   g  int     
     * @param   b  int     
     * @param   transparency int
     */
    public void drawLine(int x1, int y1, int x2, int y2, int r, int g, int b, int transparency) {
        int dashLength = 1;
        int dashInterval = 0;
        boolean drawing = true;
        int counter = 0;
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;
        int aDeltaX = (deltaX > 0 ? deltaX : -deltaX);
        int aDeltaY = (deltaY > 0 ? deltaY : -deltaY);
        int xInc = (deltaX > 0 ? 1 : -1);
        int yInc = (deltaY > 0 ? 1 : -1);
        int x = x1, y = y1;

        if (aDeltaX >= aDeltaY) {
            int count = aDeltaX + 1;
            int errMax = aDeltaX;
            int errInc = aDeltaY;
            int err = errMax / 2;
            for (int i = 0; i < count; i++) {
                //
                if (inImage(x, y))
                    setPixelRGBWithTransparency(x, y, r, g, b, transparency);
                err += errInc;
                if (err >= errMax) {
                    y += yInc;
                    err -= errMax;
                } 
                x += xInc;
            }
        } else {
            int count = aDeltaY + 1;
            int errMax = aDeltaY;
            int errInc = aDeltaX;
            int err = errMax / 2;
            for (int i = 0; i < count; i++) {
                //
                if (inImage(x, y))
                    setPixelRGBWithTransparency(x, y, r, g, b, transparency);
                err += errInc;
                if (err >= errMax) {
                    x += xInc;
                    err -= errMax;
                } 
                y += yInc;
            }
        }
    }
    
    /**
     * Draws a rectangle with upper left corner at (x1, y1) and
     * dimensions given by the width and height arguments. The rectangle
     * is filled with the color defined by the r, g, b and transparency
     * arguments. 
     * @requires the values of x1, y1, width and height
     * are such that x1 is in [0 .. width-1], y1 is in [0 .. height-1]
     * x1 + width is in [0 .. width-1] and y1 + height is in [0
     * .. height-1]. The values of red, green, blue and transparency
     * must be in [0 .. 255].
     *
     * @param   x1 int     
     * @param   y1 int     
     * @param   red  int     
     * @param   green  int     
     * @param   blue  int     
     * @param   transparency int
     */
    public void filledRectangle(int x1, int y1, int width, int height, 
				int red, int green, int blue, int transparency){
	for (int x = x1; x < x1 + width; x++) {
	    for (int y = y1; y < y1 + height; y++) {
		setPixelRGBWithTransparency(x, y, red, green, blue, transparency);
	    }
	} 
    }   
 

    /**
     * 
     */
    private void scale(float factor) {
        int newWidth = Math.round(getWidth() * factor);
        int newHeight = Math.round(getHeight() * factor);
        LabPImage newIm = new LabPImage(newWidth, newHeight);
        float newXf = 0;
        float newYf = 0;
        int newY = 0;
        for (int y = 0; y < getHeight(); y++) {
            int newX = 0;      
            for (int x = 0; x < getWidth(); x++){
                if (newXf - newX > 1) {
                    System.out.println("newX " + newX + " newY " + newY);
                    newIm.setPixelRGB(newX, newY,
                                      getPixelRed(x, y),
                                      getPixelGreen(x, y),
                                      getPixelBlue(x, y));
                    newX++;
                }
                newXf += factor;
                if (newYf - newY > 1) newY++;
            }
            newYf += factor;
        }
        im = newIm.im;
    }
        

    private void testTransparency() {
        Random gen = new Random();
        int h = im.getHeight();
        int w = im.getWidth();
        LabPImage newIm = new LabPImage(w,h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int r = getPixelRed(j, i);
                int g = getPixelGreen(j, i);
                int b = getPixelBlue(j, i);
                newIm.setPixelRGBWithTransparency(j, i, r, g, b, 255);
            }
        }
        for (int i = 0; i < h/2; i++) {
            for (int j = 0; j < w/2; j++) {
                System.out.println(" x " + j + " y " + i + " > " + 
                                   getPixelTransparency(j, i) +
                                   " rgb " + ((im.getRGB(j,i) & 0xFF000000) >>> 24));
                int r = getPixelRed(j, i);
                int g = getPixelGreen(j, i);
                int b = getPixelBlue(j, i);
                newIm.setPixelRGBWithTransparency(j, i, r, g, b, 0);
                System.out.println("trans " + newIm.getPixelTransparency(j, i));
            }
        }
        try { newIm.writeImageToPNG("im2.png"); } catch (Exception e) {};
    }
}
