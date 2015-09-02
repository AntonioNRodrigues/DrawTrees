/**
 * The Turtle class provides a set of method to make «Turtle
 * Graphics». The drawing is made on an instance of LabPImage which can
 * be saved in a file as a PNG image.
 * 
 * @author Thibault Langlois 
 */

public class Turtle {
    protected double posX;
    protected double posY;
    protected double direction;
    private LabPImage im;
    private boolean up;
    private int red;
    private int green;
    private int blue;
    private int transparency;
    private boolean debug = false;

    /**
     * Constructor. The argument is a LabPImage instance where the
     * turtle's graphics are drawn. The tutle's initial position is
     * (0, height-1), the lower left corner of the image (See LabPImage
     * documentation). The initial direction is 0 degree. The initial
     * ink used by the turtle is black, opaque (transparency level = 255). 
     *
     * @param  im LabPImage 
     */
    public Turtle (LabPImage im) {
	posX = 0; posY = 0; direction = 0;
	up = true;
	red = 0; green = 0; blue = 0;
	transparency = 0;
	this.im = im;
	posY = im.getHeight()-1;
    }

    /**
     * Constructor. The im argument is a LabPImage instance where the
     * turtle's graphics are drawn. The initial position of the turtle
     * is given by the x and y arguments. The initial direction is 0
     * degree. The initial ink used by the turtle is black, opaque
     * (transparency level = 255).  
     *
     * @param   im LabPImage       
     * @param   x int
     * @param   y int      
     */
    public Turtle (LabPImage im, int x, int y) {
	posX = x; posY = y; direction = 0;
	up = true;
	red = 0; green = 0; blue = 0;
	transparency = 255;
	this.im = im;
	// posY = im.getHeight()-1;
    }

    /**
     * Command that make the turtle walk the specified distance in
     * it's current direction. The dist argument may be negative. The
     * turtle may go out of the image.
     * @ensures The turtle state is changed according to the shift.
     * 
     * @param   dist double
     */
    public void forward(double dist) {
	double lastPosX = posX;
	double lastPosY = posY;
	// cross();
	posX += dist * Math.cos(direction / 180.0 * Math.PI);
	posY += dist * Math.sin(direction / 180.0 * Math.PI);
	if (debug) System.out.println("Turtle forward(" + dist + ") lx " +
				      lastPosX + " ly " + lastPosY + " x " +
				      posX + " y " + posY);
	/*
	if (posX > im.getWidth() - 1) posX = im.getWidth() - 1;
	if (posX < 0) posX = 0.0;
	if (posY > im.getHeight() - 1) posY = im.getHeight() - 1;
	if (posY < 0) posY = 0.0;	
	*/
	if (!up) {
	    if (debug) System.out.println("Draw line " + lastPosX + " " + lastPosY +
					  " " + posX + " " + posY);
	    im.drawLine((int) Math.round(lastPosX), (int) Math.round(lastPosY), 
			(int) Math.round(posX), (int) Math.round(posY), red, green, blue, 
			transparency);
	}
	// cross();
    }

    /**
     * Command that makes the turtle change its direction. The angle
     * is given in degrees. It is added to the current direction.
     * @ensures The turtle state is changed by
     * updating the turtle's angle.
     * 
     * @param   angle double   
     */
    public void turn(double angle) {
	if (debug) System.out.println("Turtle turn " + angle);
	direction -= angle;
    }
    
    /**
     * Command which lifts the turtle's pen. 
     * @ensures The turtle state is changed. Pen is up.
     */
    public void penUp() {
	up = true;
    }

    /**
     * Command which lowers turtle's pen.
     * @ensures The turtle state is changed. Pen is down.
     */
    public void penDown() {
	up = false;
    }

    /**
     * Method wich sets the ink red level.
     * @requires r is in the interval (0 .. 255)
     * @ensures The turtle state is changed
     * according to the parameter value.
     * 
     * @param   r int      
     */
    public void setRed(int r) {
	red = r;
    }

    /**
     * Method wich sets the ink green level.
     * @requires g is in the interval (0 .. 255)
     * @ensures The turtle state is changed
     * according to the parameter value.
     * 
     * @param   g int      
     */
    public void setGreen(int g) {
	green = g;
    }

    /**
     * Method wich sets the ink blue level.
     * @requires b is in the interval (0 .. 255)
     * @ensures The turtle state is changed
     * according to the parameter value.
     * 
     * @param   b int      
     */
    public void setBlue(int b) {
	blue = b;
    }

    /**
     * Method wich sets the ink transparency level.
     * @requires t is in the interval (0 .. 255)
     * @ensures The turtle state is changed
     * according to the parameter value.
     * 
     * @param   t int      
     */
    public void setTransparency(int t) {
	transparency = t;
    }

    /**
     * Method that sets the ink red, green and blue levels.
     * @requires r, g and b are in the interval (0 .. 255)
     * @ensures The turtle state is changed
     * according to the parameter value.
     * 
     * @param   r int      
     * @param   g int      
     * @param   b int      
     */
    public void setRGB(int r, int g, int b) {
	red = r; green = g; blue = b;
    }

    /**
     * Method which sets the ink red, green, blue and transparency levels.
     * @requires r, g, b, t are in the interval (0 .. 255)
     * @ensures The turtle state is changed
     * according to the parameter value.
     * 
     * @param   r       
     * @param   g       
     * @param   b       
     * @param   t       
     */
    public void setRGBT(int r, int g, int b, int t) {
	setRGB(r, g, b);
	setTransparency(t);
    }

    private void cross() {
	double x = posX;
	double y = posY;
	int r = red;
	int g = green;
	int b = blue;
	int t = transparency;
	double angle = direction;
	boolean isUp = up ;

	debug = false;
	System.out.println("Cross (" + x + ", " + y + ")");
	direction = 0; red = 255; green = 0; blue = 0; 
	transparency = 255; penDown();
	turn(45); forward(5); penDown();
	turn(180); penDown(); forward(10); turn(180); forward(5); 
	turn(90); forward(5); turn(180); forward(10);

	posX = x; posY = y;
	red = r; green = g; blue = b;
	transparency = t;
	direction = angle;
	debug = true;
    }

    private void kochSegment1(double size, double minSize) {
	int iSize = (int) Math.round(size);
	penDown();
	forward(iSize);
	turn(60); 
	if (size <= minSize) 
	    forward(iSize);
	else {
	    kochSegment(size/3.0, minSize);
	}
	turn(-120); 
	if (size <= minSize)
		forward(iSize); 
	else
	    kochSegment(size/3.0, minSize);		
	turn(60); 
	forward(iSize);
    }

    private void kochSegment(double size, double minSize) {
	if (size <= minSize) {
	    forward((int) Math.round(size));
	} else {
	    kochSegment(size / 3, minSize);
	    turn(60);
	    kochSegment(size / 3, minSize);
	    turn(-120);
	    kochSegment(size / 3, minSize);
	    turn(60);
	    kochSegment(size / 3, minSize);	    
	}
    }

    /*
to triline :x
  if :x < 1 [fd :x] [triline :x/3 lt 60 triline :x/3 rt 120 triline :x/3 lt 60 triline :x/3]
end
     */

    private void kochSnowflake(double size, double minSize) {
	// cross();
	penDown();       
	kochSegment(size, minSize);	
	turn(-120);
	kochSegment(size, minSize);	
	turn(-120);
	kochSegment(size, minSize);		
	// cross();
    }
}

