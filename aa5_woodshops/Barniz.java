package aa5_woodshops;
/**
 * Subclase de la clase Producto 
 * @author Jordi Hortigüela Estrada
 */
public class Barniz extends Producto{

    private float mililitros;
    private tipo_Color tipoColor; 
    /**
     * Enum que nos servirá para enumerar los tipos de color
     */
     public enum tipo_Color {

        /**
         *
         */
        Incoloro,

        /**
         *
         */
        Caoba,

        /**
         *
         */
        Nogal
    }
     /**
      * Metodo constructor de la clase Barniz
     * @param codigo Asignaremos un codigo a cada articulo
     * @param descripcion Haremos una descripcion de cada articulo
     * @param proveedor Añadiremos de qué proveedor viene
      * @param mililitros Añadiremos los ml del producto 
      * @param tipoColor Añadiremos el tipo de color
      */
    public Barniz(String codigo,String descripcion,Proveedor proveedor,float mililitros,tipo_Color tipoColor){
        super(codigo,descripcion,Producto.tipoProducto.Barniz,proveedor);
        this.mililitros = mililitros;
        this.tipoColor = tipoColor;
    }
    /**
     * Getter de mililitros
     * @return militros
     */
    public float getMililitros() {
        return mililitros;
    }
    /**
     * Setter de mililitros
     * @param mililitros nos configura los mililitros
     */
    public void setMililitros(float mililitros) {
        this.mililitros = mililitros;
    }
    /**
     * Getter de tipo_Color
     * @return nos dará el tipo de color
     */
    public tipo_Color getTipoColor() {
        return tipoColor;
    }
    /**
     * Setter del tipoColor
     * @param tipoColor configurará el tipoColor
     */
    public void setTipoColor(tipo_Color tipoColor) {
        this.tipoColor = tipoColor;
    }

}
   

