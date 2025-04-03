import java.util.ArrayList; 
import java.util.Iterator;
import java.util.List;

public class GestorRecetas {
    private List<Receta> recetas = new ArrayList<>();
    
    public void agregarReceta(Receta receta) {
        recetas.add(receta);
    }
    
    public List<Receta> obtenerRecetas() {
        return recetas;
    }
    
    // NUEVO: Método para eliminar una receta por su nombre
    public boolean eliminarReceta(String nombre) {
        Iterator<Receta> iterator = recetas.iterator();
        
        while (iterator.hasNext()) {
            Receta receta = iterator.next();
            if (receta.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove(); // Eliminación segura
                return true; // Se eliminó exitosamente
            }
        }
        
        return false; // No se encontró la receta
    }
}
