package Dos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Estudiantes {
    private Scanner entrada;

    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("estudiantes.txt"));
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        }
    }
    
    public void leer_informacion() {
        try {
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split("\\|")));
                String apellido = linea_partes.get(0).substring(0,1);
                
                if (apellido.equals("A") || apellido.equals("B")|| apellido.equals("C") || apellido.equals("E") || apellido.equals("U")) {
                    System.out.println(linea_partes);
                }
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

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        }
    }
}