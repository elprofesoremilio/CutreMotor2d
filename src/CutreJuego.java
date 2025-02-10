import javax.swing.*;

public class CutreJuego extends JFrame {
    private CutreLienzo lienzo;
    private boolean enEjecucion = false;

    public CutreJuego() {
        // Cargar la configuración al iniciar el juego
        Config.cargar("src/config.properties");

        setTitle("CutreMotor2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lienzo = new CutreLienzo();
        add(lienzo);

        pack(); // Ajusta la ventana al tamaño del lienzo
        setVisible(true);
    }

    public void iniciar() {
        enEjecucion = true;
        while (enEjecucion) {
            lienzo.actualizar();
            lienzo.repaint();

            try {
                Thread.sleep(1000 / Config.FPS); // Control de FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void detener() {
        enEjecucion = false;
    }


    public void agregarObjeto(CutreObjeto objeto) {
        lienzo.agregarObjeto(objeto);
    }
}