package Tres;

public class PruebaEstudiantes {
    public static void main(String[] args) {
        Estudiantes estudiante = new Estudiantes();
        
        estudiante.abrirArchivo();
        estudiante.crearArchivo();
        estudiante.leer_informacion();
        estudiante.agregarInformacion();
        estudiante.cerrarArchivo();
    }
}
