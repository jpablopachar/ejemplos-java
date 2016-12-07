package Uno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Paises {
    private Scanner entrada;
    
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("paises.txt"));
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
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(",")));
                String letra = "u";
                
                if (linea_partes.get(0).contains(letra) ||  linea_partes.get(0).contains(letra.toUpperCase())) {
                    System.out.printf("%s - %s\n", linea_partes.get(0), linea_partes.get(1));
                }
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
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
