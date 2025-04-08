package org.example.utils;

import org.example.model.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorCofradias {

    private List<Cofradia> cofradias;
    private final String archivoTexto = "cofradias.txt";

    public GestorCofradias() {this.cofradias = new ArrayList<>();}

    //Obtener la lista de cofradías
    public List<Cofradia> getCofradias() {
        return this.cofradias;
    }

    //Cargar las cofradias desde cofradias.txt
    public void cargarCofradiasTexto() {
        try (BufferedReader br = new BufferedReader(new FileReader("cofradias.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Extraer cada valor individualmente
                String nombre = linea.split(";")[0].split(":")[1].trim();
                int fundacion = Integer.parseInt(linea.split(";")[1].split(":")[1].trim());
                int hermanos = Integer.parseInt(linea.split(";")[2].split(":")[1].trim());
                String ciudad = linea.split(";")[3].split(":")[1].trim();

                cofradias.add(new Cofradia(nombre, fundacion, hermanos, ciudad));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar cofradías: " + e.getMessage());
        }
    }


}
