import javax.imageio.ImageIO;
import java.awt.*; // Importa la libreria AWT para dibujar
import java.awt.image.BufferedImage;
import java.io.File;

public abstract class CutreObjeto { // Clase abstracta (no se puede instanciar directamente)
    protected int x, y, ancho, alto; // Atributos protegidos (accesibles desde las clases hijas)
    protected BufferedImage imagen;

    public CutreObjeto(int x, int y, int ancho, int alto, String rutaImagen) { // Constructor
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;

        try {
            File file = new File(rutaImagen);
            imagen = ImageIO.read(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Métodos abstractos (deben ser implementados por las clases hijas)
    public abstract void actualizar(); // Actualiza la lógica del objeto
    public void dibujar(Graphics g) { // Dibuja el objeto en el lienzo
        g.drawImage(imagen, x, y, null);
    }
}