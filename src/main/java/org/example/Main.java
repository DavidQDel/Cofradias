package org.example;

import org.example.model.Cofradia;
import org.example.model.CofradiaWrapper;
import org.example.utils.CofradiaJSON;
import org.example.utils.CofradiaXML;
import org.example.utils.GestorCofradias;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorCofradias gestor = new GestorCofradias();
        CofradiaWrapper wrapper = null;
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    gestor.cargarCofradiasTexto();
                    wrapper = new CofradiaWrapper(gestor.getCofradias());
                    System.out.println("Datos cargados desde texto correctamente.");
                    break;

                case 2:
                    if (wrapper != null) {
                        try {
                            CofradiaXML.serializarAXml(wrapper, "cofradias.xml");
                            System.out.println("Datos guardados en XML correctamente.");
                        } catch (Exception e) {
                            System.err.println("Error al guardar XML: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Primero debe cargar los datos (Opción 1)");
                    }
                    break;

                case 3:
                    if (wrapper != null) {
                        try {
                            CofradiaJSON.serializarAJson(wrapper, "cofradias.json");
                            System.out.println("Datos guardados en JSON correctamente.");
                        } catch (Exception e) {
                            System.err.println("Error al guardar JSON: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Primero debe cargar los datos (Opción 1)");
                    }
                    break;

                case 4:
                    try {
                        CofradiaWrapper xmlWrapper = CofradiaXML.deserializarDesdeXml("cofradias.xml");
                        mostrarCofradias(xmlWrapper.getCofradias());
                    } catch (Exception e) {
                        System.err.println("Error al leer XML: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        CofradiaWrapper jsonWrapper = CofradiaJSON.deserializarDesdeJson("cofradias.json");
                        mostrarCofradias(jsonWrapper.getCofradias());
                    } catch (Exception e) {
                        System.err.println("Error al leer JSON: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            if (opcion != 6) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }

        } while (opcion != 6);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ GESTIÓN DE COFRADÍAS ---");
        System.out.println("1. Leer datos desde el fichero de texto y generar objetos");
        System.out.println("2. Guardar datos en XML");
        System.out.println("3. Guardar datos en JSON");
        System.out.println("4. Leer datos desde XML y mostrarlos");
        System.out.println("5. Leer datos desde JSON y mostrarlos");
        System.out.println("6. Salir de la aplicación");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarCofradias(List<Cofradia> cofradias) {
        if (cofradias.isEmpty()) {
            System.out.println("No hay cofradías para mostrar.");
        } else {
            System.out.println("\nLISTADO DE COFRADÍAS:");
            for (Cofradia cofradia : cofradias) {
                System.out.println(cofradia);
            }
        }
    }
}