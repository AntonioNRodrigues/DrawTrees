/**
 * 
 */

/**
 * @author Antonio Rodrigues
 *
 */
public class ArvoresFinal extends Turtle{

	public ArvoresFinal(LabPImage imagem, int x, int y) {
		super(imagem, x, y);
		setRed(255);
	}
	public void arvore1(double tamanho) {
		drawRectangulo(tamanho, tamanho/5);
		arvore1Aux(tamanho / 2, (tamanho / 5) / 2, this.posX, this.posY,
				this.direction);
	}
	
	private void arvore1Aux(double comprimento, double largura, double xAnterior, double yAnterior,
			double dir) {
		if(largura > 2){
			turn(60);
			drawRectangulo(comprimento, largura);
			arvores(comprimento/2, largura/2, xAnterior, yAnterior, dir);
			turn(-60);
			drawRectangulo(comprimento, largura);
			arvores(comprimento/2, largura/2, xAnterior, yAnterior, dir);
		}
	}
	private void arvores(double comprimento, double largura, double prevX,
			double prevY, double direction) {
		this.posX = prevX;
		this.posY = prevY;
		this.direction = direction;
		
	}
	private void drawRectangulo(double comprimento, double largura) {
		penUp();
		forward(largura / 2);
		turn(90);
		forward(comprimento);
		turn(90);
		forward(largura / 2);

		penDown();
		forward(largura / 2);
		turn(90);
		forward(comprimento);
		turn(90);
		forward(largura);
		turn(90);
		forward(comprimento);
		turn(90);
		forward(largura / 2);
		turn(-(90 * 6));
	}
	
}
