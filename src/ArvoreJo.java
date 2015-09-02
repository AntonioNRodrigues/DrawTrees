import java.io.IOException;
import java.util.Random;


public class ArvoreJo extends Turtle {

    public static void main(String[]args) throws IOException{
        
        LabPImage img = new LabPImage(600, 500);
        ArvoreJo tree = new ArvoreJo(img, img.getWidth()/2, img.getHeight());
        tree.arvore1(200);
        img.writeImageToPNG("arvore_1.png");
        System.out.println(tree.calcNumero(0.75, 1.25));
        
    }
    
    public ArvoreJo(LabPImage img, int x, int y) {
        super(img, x, y);
        setRed(255);
        img.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
    }
    
    public void arvore1(double tamanho){
        //desenha tronco
        genRect(tamanho, tamanho/5);
        
        //entra em desenho de ramos e folhas
        arvore1(tamanho/2, (tamanho/5)/2, this.posX, this.posY, this.direction);
        
    }
    
    private void arvore1(double tamanho, double largura, double prevX, double prevY, double direction){
        if(largura < 1)
            return;
        else{
            //imprime rectangulos esquerda
            turn(60);
            genRect(tamanho, largura);
            arvore1(tamanho/2, largura/2, this.posX, this.posY, this.direction);
            
            //volta para o eixo anterior para poder desenhar a da direita
            this.posX = prevX;
            this.posY = prevY;
            
            //imprime rectangulos direita
            turn(-60); 
            genRect(tamanho, largura);
            arvore1(tamanho/2, largura/2, this.posX, this.posY, this.direction);
            
            
        }
    }
    
    private void genRect(double tamanho, double largura){
        //levanta pen
        this.penUp();
        
        //posiciona pen para inicio de desenho
        this.forward(largura/2);
        this.turn(90);
        this.forward(tamanho);
        this.turn(90);
        this.forward(largura/2);
        
        //acenta pen e desenha
        this.penDown();
        this.forward(largura/2);
        this.turn(90);
        this.forward(tamanho);
        this.turn(90);
        this.forward(largura);
        this.turn(90);
        this.forward(tamanho);
        this.turn(90);
        this.forward(largura/2);
        turn(-(90*6));
    }
    
    private double calcNumero(double min, double max) {
		return new Random().nextDouble() * (max - min) + min;
	}

}