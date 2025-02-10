import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Crea una instancia de la clase CutreJuego
        CutreJuego juego = new CutreJuego();

        // Inicia el juego
        juego.agregarObjeto(new Pelota(100, 100, 50, 50, Color.RED));
        juego.iniciar();
    }
}
