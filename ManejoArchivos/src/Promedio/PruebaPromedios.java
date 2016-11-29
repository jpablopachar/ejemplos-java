/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Promedio;

import lecturaArchivos.LeerArchivoTexto;

/**
 *
 * @author SALAS
 */
public class PruebaPromedios {
    public static void main( String args[] )
   {
      ArchivosPromedio aplicacion = new ArchivosPromedio();

      aplicacion.abrirArchivo();
      aplicacion.leer_informacion();
      aplicacion.cerrarArchivo();
   } // fin de main
}
