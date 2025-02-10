import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.awt.Color;

public class Config {
    // Atributos estáticos de configuración
    public static int FPS;
    public static int ANCHO_LIENZO;
    public static int ALTO_LIENZO;
    public static Color COLOR_FONDO;

    // Método para cargar la configuración desde un archivo
    public static void cargar(String rutaArchivo) {
        Properties propiedades = new Properties();
        try (FileInputStream entrada = new FileInputStream(rutaArchivo)) {
            propiedades.load(entrada);

            // Leer y asignar los valores del archivo
            FPS = Integer.parseInt(propiedades.getProperty("FPS", "60"));
            ANCHO_LIENZO = Integer.parseInt(propiedades.getProperty("ANCHO_LIENZO", "800"));
            ALTO_LIENZO = Integer.parseInt(propiedades.getProperty("ALTO_LIENZO", "600"));
            COLOR_FONDO = Color.decode(propiedades.getProperty("COLOR_FONDO", "#000000"));

        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuración: " + e.getMessage());
            // Valores por defecto en caso de error
            FPS = 60;
            ANCHO_LIENZO = 800;
            ALTO_LIENZO = 600;
            COLOR_FONDO = Color.BLACK;
        }
    }
}