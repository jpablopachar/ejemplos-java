package Dos;

public class PruebaEstudiantes {
    public static void main(String[] args) {
        Estudiantes aplicacion = new Estudiantes();

        aplicacion.abrirArchivo();
        aplicacion.leer_informacion();
        aplicacion.cerrarArchivo();
    }
}
