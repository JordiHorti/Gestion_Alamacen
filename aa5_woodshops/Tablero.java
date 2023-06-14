package aa5_woodshops;
/**
 * Clase que nos servirá para gestionar la subclase de Producto: Tablero.
 * @author Jordi
 */
public class Tablero extends Producto {
    
    private float altura;
    private float anchura;
    private tipo_Tablero tipoTablero;

    /**
     * Enum para enumerar los diferentes tipos de tablero
     */
    public enum tipo_Tablero{

        /**
         *
         */
        AGLOMERADO,

        /**
         *
         */
        CONTRACHAPADO,

        /**
         *
         */
        MDF,
    }
    /** 
     * Constructor clase tablero
     * @param codigo Pasamos el codigo del producto
     * @param descripcion Pasamos la descripcion del producto 
     * @param proveedor Pasamos el proveedor que suministra el producto
     * @param altura Pasamos la altura del tablero
     * @param anchura Pasamos la anchura del tablero
     * @param tipoTablero  Pasamos el tipo de tablero
     */
    public Tablero (String codigo,String descripcion,Proveedor proveedor,float altura, float anchura, tipo_Tablero tipoTablero){
        super(codigo,descripcion,Producto.tipoProducto.Tablero,  proveedor);
        this.altura = altura;
        this.anchura = anchura;
        this.tipoTablero = tipoTablero;
    }
    /**
     * Getter de altura
     * @return 
     */
    public float getAltura() {
        return altura;
    }
    /**
     * Setter de altura
     * @param altura Pasamos la altura para configurar el valor del atributo
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }
    /**
     * Getter de anchura
     * @return Nos devuelve el valor de la anchura del tablero
     */
    public float getAnchura() {
        return anchura;
    }
    /**
     * Setter de anchura
     * @param anchura Pasamos el valor que queremos que tenga el atributo
     */
    public void setAnchura(float anchura) {
        this.anchura = anchura;
    }
    /**
     * Getter de tipo_Tablero
     * @return retorna el valor del enum tipo_Tablero
     */
    public tipo_Tablero getTipoTablero() {
        return tipoTablero;
    }
    /**
     * Setter de tipo tablero
     * @param tipoTablero Pasamos el valor que queremos que tenga tipo_Tablero
     */
    public void setTipoTablero(tipo_Tablero tipoTablero) {
        this.tipoTablero = tipoTablero;
    }
   
}
