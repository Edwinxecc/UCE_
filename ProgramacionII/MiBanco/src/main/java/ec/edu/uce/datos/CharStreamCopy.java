package ec.edu.uce.datos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamCopy {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Por favor, proporcione archivo de entrada y salida.");
            return;
        }
        copiarArchivoConChar(args[0], args[1]);
    }

    public static void copiarArchivoConChar(String archivoEntrada, String archivoSalida) {
        char[] buffer = new char[128];
        int cantidadLeida;

        try (FileReader fr = new FileReader(archivoEntrada);
             FileWriter fw = new FileWriter(archivoSalida)) {
            while ((cantidadLeida = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, cantidadLeida);
            }

            System.out.println("Archivo copiado correctamente.");

        } catch (IOException e) {
            System.err.println("Error durante la copia: " + e.getMessage());
        }
    }
}