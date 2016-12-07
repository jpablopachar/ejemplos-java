package Tres;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Estudiantes {
    private Scanner entrada;
    private Formatter salida;
    String apellido, nombre;
    int edad;

    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("estudiantes.txt"));
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        }
    }
    
    public void crearArchivo() {
        try {
            salida = new Formatter("estudiantes-2-1.txt");
        } catch (SecurityException securityException) {
            System.err.println("No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        }
    }
    
    public void leer_informacion() {
        try {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                apellido = linea_partes.get(0);
                nombre = linea_partes.get(1);
                edad = 2016 - Integer.parseInt(linea_partes.get(2));
                
                System.out.println(apellido);
            }    
        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        }
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
    }
    
    public void agregarInformacion() {
        Scanner reader = new Scanner(System.in);
        boolean bandera = true;
        
        while (bandera) {            
            try {
                salida.format("%s|%s|%s", nombre, apellido, edad);
            } catch (FormatterClosedException formatterClosedException) {
                System.err.println("Error al escribir en el archivo.");
                return;
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Entrada invalida. Intente de nuevo.");
            }
        }
    }
    
    public void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    }
}
