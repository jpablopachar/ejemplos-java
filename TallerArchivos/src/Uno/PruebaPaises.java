package Uno;

public class PruebaPaises {
    public static void main(String[] args) {
        Paises aplicacion = new Paises();

        aplicacion.abrirArchivo();
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    }
}
