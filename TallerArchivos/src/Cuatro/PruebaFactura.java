package Cuatro;

public class PruebaFactura {
    public static void main(String[] args) {
        Factura aplicacion = new Factura();
        
        aplicacion.abrirArchivo();
        aplicacion.agregarInformacion();
        aplicacion.cerrarArchivo();
    }
}
