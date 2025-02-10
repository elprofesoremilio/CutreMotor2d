import java.awt.*;
import java.util.Random;

public class Pelota extends CutreObjeto {
    private Color color;
    private int velocidadX;
    private int velocidadY;

    public Pelota(int x, int y, int ancho, int alto, Color color) {
        super(x, y, ancho, alto, "src/assets/mylimIdle1.png");
        this.color = color;

        // Inicializa la velocidad con valores aleatorios
        Random random = new Random();
        velocidadX = random.nextInt(5) + 1; // Velocidad entre 1 y 5
        velocidadY = random.nextInt(5) + 1; // Velocidad entre 1 y 5

        // Asegura que la velocidad pueda ser negativa
        if (random.nextBoolean()) {
            velocidadX = -velocidadX;
        }
        if (random.nextBoolean()) {
            velocidadY = -velocidadY;
        }
    }

    @Override
    public void actualizar() {
        // Mueve la pelota
        x += velocidadX;
        y += velocidadY;

        // Revisa si la pelota toca los bordes y la hace rebotar
        if (x + ancho > Config.ANCHO_LIENZO || x < 0) {
            velocidadX = -velocidadX; // Invierte la dirección horizontal
        }
        if (y + alto > Config.ALTO_LIENZO || y < 0) {
            velocidadY = -velocidadY; // Invierte la dirección vertical
        }
    }

}