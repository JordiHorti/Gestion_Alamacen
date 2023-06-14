package aa5_woodshops;

/**
 * Importamos la libreria para poder trabajar con ArrayList
 */
/**
 * Clase que gestiona los proveedores
 * @author Jordi
 */
public class Proveedor {
    private String nombre;
    private String nif;

    /**
     * Constructor de la clase Proveedor
     * @param nif Pasamos el nf del proveedor
     * @param nombre Pasamos el nombre del proveedor
     */
   public Proveedor(String nombre,String nif){
        this.nombre = nombre;
        this.nif = nif;
        
   }
    /**
     * Getter de nif
     * @return 
     */
    public String getNif() {
        return nif;
    }
    /**
     * Settter de nif
     * @param nif 
     */
    public void setNif(String nif) {
        this.nif = nif;
    }
    /**
     * Getter de nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Settter de nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
   
}
