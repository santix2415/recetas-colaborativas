import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorRecetas gestor = new GestorRecetas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar receta");
            System.out.println("2. Listar recetas");
            System.out.println("3. Eliminar receta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la receta:");
                    String nombre = scanner.nextLine();
                    
                    System.out.println("Ingrese los ingredientes (separados por coma):");
                    String[] ingredientes = scanner.nextLine().split(",");
                    
                    System.out.println("Ingrese las instrucciones:");
                    String instrucciones = scanner.nextLine();
                    
                    Receta nuevaReceta = new Receta(nombre, ingredientes, instrucciones);
                    gestor.agregarReceta(nuevaReceta);
                    
                    System.out.println("Receta agregada: " + nuevaReceta.getNombre());
                    break;

                case 2:
                    System.out.println("Recetas disponibles:");
                    for (Receta receta : gestor.obtenerRecetas()) {
                        System.out.println("- " + receta.getNombre());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre de la receta a eliminar: ");
                    String nombreAEliminar = scanner.nextLine();
                    if (gestor.eliminarReceta(nombreAEliminar)) {
                        System.out.println("Receta eliminada correctamente.");
                    } else {
                        System.out.println("No se encontró una receta con ese nombre.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
