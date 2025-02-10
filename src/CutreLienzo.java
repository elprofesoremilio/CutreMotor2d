import javax.swing.*; // Importa la libreria Swing para crear paneles
import java.awt.*; // Importa la libreria AWT para dibujar
import java.util.ArrayList; // Importa la clase ArrayList para crear listas
import java.util.List; // Importa la interfaz List

public class CutreLienzo extends JPanel { // Hereda de JPanel para crear un panel
    private List<CutreObjeto> objetos = new ArrayList<>(); // Lista de objetos a dibujar

    public CutreLienzo() {
        setBackground(Config.COLOR_FONDO); // Establece el color de fondo
        setPreferredSize(new Dimension(Config.ANCHO_LIENZO, Config.ALTO_LIENZO)); // Fija el tamaño del lienzo
    }

    public void actualizar() {
        for (CutreObjeto obj : objetos) { // Recorre la lista de objetos
            obj.actualizar(); // Llama al método actualizar de cada objeto
        }
    }

    @Override
    protected void paintComponent(Graphics g) { // Método para dibujar en el panel
        super.paintComponent(g); // Llama al método de la clase padre
        for (CutreObjeto obj : objetos) { // Recorre la lista de objetos
            obj.dibujar(g); // Llama al método dibujar de cada objeto
        }
    }

    public void agregarObjeto(CutreObjeto obj) {
        objetos.add(obj); // Agrega un objeto a la lista
    }
}