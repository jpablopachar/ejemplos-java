package Cuatro;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Factura {
    private Formatter salida;
    
    public void abrirArchivo() {
        try {
            salida = new Formatter("factura.txt");
        } catch (SecurityException securityException) {
            System.err.println("No tiene acceso de escritura a este archivo.");
            System.exit(1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al crear el archivo.");
            System.exit(1);
        }
    }
    
    public void agregarInformacion() {
        Scanner reader = new Scanner(System.in);            
        try {
            int i = 0;
            
            double subTotal = 0, total = 0, iva = 0;
            char desea = 'S';
            
            System.out.print("Ingrese el nombre: ");
            String nombre = reader.next();
            System.out.print("Ingrese el apellido: ");
            String apellido = reader.next();
            System.out.print("Ingrese la ciudad: ");
            String ciudad = reader.next();
            
            salida.format("\tComercial Ventas y Reventas\nNombre: %s %s\nCiudad: %s\n"
                + "Producto\tCantidad\tPrecio\n", nombre, apellido, ciudad);

            while (desea == 'S' || desea == 's') {
                String nombreProd[] = new String[i+1];
                int cant[] = new int[i+1];
                double precio[] = new double[i+1];
                System.out.print("1. Arroz; Costo del kilo $2.50\n");
                System.out.print("2. Azucar; Costo del kilo $1.50\n");
                System.out.print("3. Aceite; Costo del kilo $1.30\n");
                System.out.print("4. Tallarines; Costo del kilo $1.50\n");
                System.out.print("5. Sal; Costo del kilo $1.00\n");
                System.out.print("¿Que producto desea? (1 - 5): ");
                int opcion = reader.nextInt();
                switch (opcion) {
                    case 1:
                        nombreProd[i] = "ARROZ";
                        System.out.print("Cantidad: ");
                        cant[i] = reader.nextInt();
                        precio[i] = 2.50 * cant[i];
                    break;
                    case 2:
                        nombreProd[i] = "AZUCAR";
                        System.out.print("Cantidad: ");
                        cant[i] = reader.nextInt();
                        precio[i] = 1.50 * cant[i];
                    break;
                    case 3:
                        nombreProd[i] = "ACEITE";
                        System.out.print("Cantidad: ");
                        cant[i] = reader.nextInt();
                        precio[i] = 1.30 * cant[i];
                    break;
                    case 4:
                        nombreProd[i] = "TALLARINES";
                        System.out.print("Cantidad: ");
                        cant[i] = reader.nextInt();
                        precio[i] = 1.50 * cant[i];
                    break;
                    case 5:
                        nombreProd[i] = "SAL";
                        System.out.print("Cantidad: ");
                        cant[i] = reader.nextInt();
                        precio[i] = 1.00 * cant[i];
                    break;
                }
                
                salida.format("%s\t\t%d\t\t%.2f\n", nombreProd[i], cant[i], precio[i]);
                
                subTotal = subTotal + precio[i];
                iva = (subTotal * 14) / 100;
                total = subTotal + iva;
                i++;

                System.out.print("¿Desea ingresar más datos (S/N)?: ");
                desea = reader.next().charAt(0);    
            }

            salida.format("Subtotal: %.2f\n"
                + "IVA: %.2f\nTotal: %.2f\n", subTotal, iva, total);
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error al escribir en el archivo.");
            return;
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Entrada invalida. Intente de nuevo.");
        }
    }
    
    public void cerrarArchivo() {
        if (salida != null) {
            salida.close();
        }
    }
}
