/**
 * @author Antonio Rodrigues
 * 
 */
public class ArvoresOld extends Turtle {
	private int x;
	private int y;

	public ArvoresOld(LabPImage im, int x, int y) {
		super(im, x, y);
		this.x = x;
		this.y = y;
		setRed(240); // cor das linhas a laranja
		super.direction = -90; // direcao inicial para cima
	}

	public boolean arvore0(double tamanho) {

		if (tamanho < 6.25) {// condicao de paragem
			return false;
		}
		penDown();
		forward(tamanho);
		turn(90);
		double sitioDta = posX;
		System.out.println(sitioDta);
		forward(tamanho / 5);
		double sitioEsq = posX;
		System.out.println(sitioEsq);
		turn(90);
		forward(tamanho);
		turn(90);
		forward(tamanho / 5);
		penUp();

		if (tamanho / 5 > 2) {
			turn(-60);
			posX = sitioDta;
			posY = sitioEsq;
			return arvore0(tamanho / 2);
		}
		if (tamanho / 5 > 2) {
			turn(-120);
			posX = sitioDta;
			posY = sitioEsq;
			return arvore0(tamanho / 2);
		}

		return arvore0(tamanho / 2);
	}

	/*
	 * public boolean arvore2(double tamanho) {
	 * 
	 * penDown(); forward(100); System.out.println(direction); turn(+90);
	 * System.out.println(direction); forward(100);
	 * System.out.println(direction); turn(+90); System.out.println(direction);
	 * forward(100); System.out.println(direction); turn(90);
	 * System.out.println(direction); return false;
	 * 
	 * }
	 */

	public boolean arvore1(double tamanho) {
		double largura = tamanho / 5;
		if (tamanho < 1) {// condicao de paragem
			return false;
		}
		penUp();
		forward(tamanho);
		x = (int) posX;
		y = (int) posY;
		penDown();
		turn(90);
		forward(tamanho / 10);
		turn(90);
		forward(tamanho);
		turn(90);
		forward(tamanho / 5);
		turn(90);
		forward(tamanho);
		turn(90);
		forward(tamanho / 10);
		System.out.println(direction);
		if (largura > 2) {
			arvore1(60, tamanho / 2, x, y);
		}

		return arvore1(tamanho / 2);
	}

	private void arvore1(int degraus, double tamanho, int x2, int y2) {
		turn(degraus);
		penUp();
		forward(tamanho);
		penDown();
		turn(90);
		forward(tamanho / 10);
		turn(90);
		forward(tamanho);
		turn(90);
		forward(tamanho / 5);
		turn(90);
		forward(tamanho);
		turn(90);
		forward(tamanho / 10);

	}

	public boolean arvore2(double tamanho) {
		double largura = tamanho / 5;
		if (tamanho < 1) {
			return false;
		} 
		penDown();
		forward(tamanho);
		double x = posX;
		double y = posY;
		if (largura > 2) {
			arvore2Aux(tamanho/2, 60, x, y);
			arvore2Aux(tamanho/2, -120,x, y);
		}

		return arvore2(tamanho / 2);
	}
	private boolean arvore2Aux(double tamanho, int degraus, double x, double y){
		if (tamanho < 1){
			return false;
		}
		turn(degraus);
		forward(tamanho);
		return arvore2Aux(tamanho/2, degraus, posX, posY);
	}

}
