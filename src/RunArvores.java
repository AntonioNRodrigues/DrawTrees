import java.io.IOException;

/**
 * 
 */

/**
 * @author Antonio Rodrigues
 * 
 */
public class RunArvores {
	private static final int ALTURA = 500;
	private static final int LARGURA = 600;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		LabPImage imagem = new LabPImage(LARGURA, ALTURA);
		Arvores a1 = new Arvores(imagem, LARGURA / 2, ALTURA-1);

		// Arvore 1
		a1.arvore1(200);
		imagem.writeImageToPNG("arvore1.png");

		// Arvore 2
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore2(200);
		imagem.writeImageToPNG("arvore2.png");

		// Arvore 3
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore3(200);
		imagem.writeImageToPNG("arvore3.png");

		// Arvore 4a
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore4(200);
		imagem.writeImageToPNG("arvore4a.png");

		// Arvore 4b
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore4(200);
		imagem.writeImageToPNG("arvore4b.png");

		// Arvore 5a
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore5(200);
		imagem.writeImageToPNG("arvore5b.png");

		// Arvore 5b
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore5(200);
		imagem.writeImageToPNG("arvore5a.png");

		// Arvore 6a
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore6(200);
		imagem.writeImageToPNG("arvore6a.png");

		// Arvore 6b
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore6(200);
		imagem.writeImageToPNG("arvore6b.png");

		// Arvore 7a
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore7(200);
		imagem.writeImageToPNG("arvore7a.png");

		// Arvore 7b
		imagem = new LabPImage(LARGURA, ALTURA);
		a1 = new Arvores(imagem, LARGURA / 2, ALTURA);
		a1.arvore7(200);
		imagem.writeImageToPNG("arvore7b.png");
	}

}
