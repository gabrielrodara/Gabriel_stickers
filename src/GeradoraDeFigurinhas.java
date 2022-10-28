import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.plaf.FontUIResource;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {

        //leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria uma nova imagem em memória com transparencia e com novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra novo imagem (em memória)
        Graphics graphics = novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar a fonte
        var fonte = new FontUIResource(Font.SANS_SERIF, Font.BOLD, 60);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);
        FontMetrics fm = graphics.getFontMetrics();
        int larguraFonte = fm.stringWidth("TOPZERA");
        int alturaFonte = fm.getHeight();

        //escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", (largura - larguraFonte)/2, novaAltura - (alturaFonte/2));
        

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));


    }

}


