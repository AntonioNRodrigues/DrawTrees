import java.util.Random;

/**
 * 
 */

/**
 * @author antonio
 * 
 */
public class Arvores extends Turtle {
	private double numSubRamos;

	public Arvores(LabPImage imagem, int xInicial, int yInicial) {
		super(imagem, xInicial, yInicial);
		imagem.filledRectangle(0, 0, xInicial * 2, yInicial, 0, 0, 0, 255);
		setRed(255);
		setBlue(100);
		setGreen(150);
	}

	public void arvore1(double tamanho) {
		drawRectangulo(tamanho, tamanho / 5, false);
		arvore1(tamanho / 2, (tamanho / 5) / 2, this.posX, this.posY,
				this.direction);

	}

	private void arvore1(double comprimento, double largura, double prevX,
			double prevY, double direction) {
		if (largura < 1) {
			return;
		} else {
			turn(60);
			drawRectangulo(comprimento, largura, false);
			arvore1(comprimento / 2, largura / 2, this.posX, this.posY,
					this.direction);
			this.posX = prevX;
			this.posY = prevY;
			this.direction = direction;
			turn(-60);
			drawRectangulo(comprimento, largura, false);
			arvore1(comprimento / 2, largura / 2, this.posX, this.posY,
					this.direction);
		}

	}

	public void arvore2(double tamanho) {
		drawRectangulo(tamanho, tamanho / 5, false);
		arvore2Aux(tamanho / 2, (tamanho / 5) / 2, this.posX, this.posY,
				this.direction);
	}

	private void arvore2Aux(double comprimento, double largura,
			double xAnterior, double yAnterior, double direction) {
		if (largura < 1) {
			return;
		} else {

			turn(60);
			drawRectangulo(comprimento, largura, false);
			arvore2Aux(comprimento / 2, largura / 2, this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(0);
			drawRectangulo(comprimento, largura, false);
			arvore2Aux(comprimento / 2, largura / 2, this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(-60);
			drawRectangulo(comprimento, largura, false);
			arvore2Aux(comprimento / 2, largura / 2, this.posX, this.posY,
					this.direction);
		}
	}

	public void arvore3(double tamanho) {
		drawRectangulo(tamanho, tamanho / 5, false);
		arvore3Aux(tamanho / 2, (tamanho / 5) / 2, this.posX, this.posY,
				this.direction);

	}

	private void arvore3Aux(double comprimento, double largura,
			double xAnterior, double yAnterior, double direction) {
		if (largura < 1) {
			return;
		} else {
			turn(60);
			drawRectangulo(comprimento, largura, false);
			arvore3Aux(comprimento / 2, largura / 2, this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(20);
			drawRectangulo(comprimento, largura, false);
			arvore3Aux(comprimento / 2, largura / 2, this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(-20);
			drawRectangulo(comprimento, largura, false);
			arvore3Aux(comprimento / 2, largura / 2, this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(-60);
			drawRectangulo(comprimento, largura, false);
			arvore3Aux(comprimento / 2, largura / 2, this.posX, this.posY,
					this.direction);
		}
	}

	public void arvore4(double tamanho) {
		drawRectangulo(tamanho, tamanho / 5, false);
		arvore4Aux(tamanho / 2, (tamanho / 5) / 2, this.posX, this.posY,
				this.direction);

	}

	private void arvore4Aux(double comprimento, double largura,
			double xAnterior, double yAnterior, double direction) {
		if (largura < 1) {
			return;
		} else {
			turn(60);
			drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura, false);
			arvore4Aux(comprimento / 2, (largura / 2), this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(20);
			drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura, false);
			arvore4Aux(comprimento / 2, (largura / 2), this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(-20);
			drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura, false);
			arvore4Aux(comprimento / 2, (largura / 2), this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(-60);
			drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura, false);
			arvore4Aux(comprimento / 2, (largura / 2), this.posX, this.posY,
					this.direction);
		}

	}

	public void arvore5(double tamanho) {
		drawRectangulo(tamanho, tamanho / 5, false);
		arvore5Aux(tamanho / 2, (tamanho / 5) / 2, this.posX, this.posY,
				this.direction);

	}

	private void arvore5Aux(double comprimento, double largura,
			double xAnterior, double yAnterior, double direction) {
		if (largura < 1) {
			return;
		} else {
			turn(60);
			drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura, false);
			arvore5Aux(comprimento / 2, (largura / 2), this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(20 * calcNumero(0.5, 1.5));
			drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura, false);
			arvore5Aux(comprimento / 2, (largura / 2), this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(-20 * calcNumero(0.5, 1.5));
			drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura, false);
			arvore5Aux(comprimento / 2, (largura / 2), this.posX, this.posY,
					this.direction);
			this.posX = xAnterior;
			this.posY = yAnterior;
			this.direction = direction;
			turn(-60 * calcNumero(0.5, 1.5));
			drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura, false);
			arvore5Aux(comprimento / 2, (largura / 2), this.posX, this.posY,
					this.direction);
		}

	}

	public void arvore6(double tamanho) {
		drawRectangulo(tamanho, tamanho / 5, false);
		arvore6Aux(1, tamanho / 2, (tamanho / 5) / 2, this.posX, this.posY,
				this.direction, this.numSubRamos, false);
	}

	private void arvore6Aux(double limite, double comprimento, double largura,
			double xAnterior, double yAnterior, double direction,
			double numSubRamos, boolean pintarFolhas) {
		if (largura < limite) {
			return;
		} else {
			if (numSubRamos < -0.8) {
				turn(60 * calcNumero(0.5, 1.5));
				drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura,
						pintarFolhas);
				arvore6Aux(limite, comprimento / 2, largura / 2, this.posX,
						this.posY, this.direction, numSubRamos, pintarFolhas);
				this.posX = xAnterior;
				this.posY = yAnterior;
				this.direction = direction;
				numSubRamos = calucateNumRamos();
				turn(-60 * calcNumero(0.5, 1.5));

				drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura,
						pintarFolhas);
				arvore6Aux(limite, comprimento / 2, largura / 2, this.posX,
						this.posY, this.direction, numSubRamos, pintarFolhas);

			} else if (numSubRamos >= -0.8 && numSubRamos < 0.2) {
				turn(60 * calcNumero(0.5, 1.5));
				drawRectangulo(comprimento, largura, pintarFolhas);
				arvore6Aux(limite, comprimento / 2, largura / 2, this.posX,
						this.posY, this.direction, numSubRamos, pintarFolhas);
				this.posX = xAnterior;
				this.posY = yAnterior;
				this.direction = direction;
				numSubRamos = calucateNumRamos();
				turn(0 * calcNumero(0.5, 1.5));
				drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura,
						pintarFolhas);
				arvore6Aux(limite, comprimento / 2, largura / 2, this.posX,
						this.posY, this.direction, numSubRamos, pintarFolhas);
				this.posX = xAnterior;
				this.posY = yAnterior;
				this.direction = direction;
				numSubRamos = calucateNumRamos();
				turn(-60 * calcNumero(0.5, 1.5));
				drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura,
						pintarFolhas);
				arvore6Aux(limite, comprimento / 2, largura / 2, this.posX,
						this.posY, this.direction, numSubRamos, pintarFolhas);
			} else if (numSubRamos >= 0.2) {
				turn(60 * calcNumero(0.5, 1.5));
				drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura,
						pintarFolhas);
				arvore6Aux(limite, comprimento / 2, largura / 2, this.posX,
						this.posY, this.direction, numSubRamos, pintarFolhas);
				this.posX = xAnterior;
				this.posY = yAnterior;
				this.direction = direction;
				numSubRamos = calucateNumRamos();
				turn(20 * calcNumero(0.5, 1.5));
				drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura,
						pintarFolhas);
				arvore6Aux(limite, comprimento / 2, largura / 2, this.posX,
						this.posY, this.direction, numSubRamos, pintarFolhas);
				this.posX = xAnterior;
				this.posY = yAnterior;
				this.direction = direction;
				numSubRamos = calucateNumRamos();
				turn(-20 * calcNumero(0.5, 1.5));
				drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura,
						pintarFolhas);
				arvore6Aux(limite, comprimento / 2, largura / 2, this.posX,
						this.posY, this.direction, numSubRamos, pintarFolhas);
				this.posX = xAnterior;
				this.posY = yAnterior;
				this.direction = direction;
				numSubRamos = calucateNumRamos();
				turn(-60 * calcNumero(0.5, 1.5));
				drawRectangulo(comprimento * calcNumero(0.75, 1.25), largura,
						pintarFolhas);
				arvore6Aux(limite, comprimento / 2, largura / 2, this.posX,
						this.posY, this.direction, numSubRamos, pintarFolhas);
			}
		}
	}

	public void arvore7(double tamanho) {
		drawRectangulo(tamanho, tamanho / 5, true);
		arvore6Aux(0.5, tamanho / 2, (tamanho / 5) / 2, this.posX, this.posY,
				this.direction, this.numSubRamos, true);
	}

	private double calucateNumRamos() {
		return new Random().nextGaussian();
	}

	private double calcNumero(double min, double max) {
		return new Random().nextDouble() * (max - min) + min;
	}

	private void drawRectangulo(double comprimento, double largura,
			boolean isFolha) {
		penUp();
		forward(largura / 2);
		turn(90);
		forward(comprimento);
		turn(90);
		forward(largura / 2);

		if (isFolha) {
			resetGreen(largura);
		}

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

	private void resetGreen(double largura) {
		if (largura <= 1.25) {
			setGreen(255);
		} else {
			setGreen(150);
		}
	}

}
