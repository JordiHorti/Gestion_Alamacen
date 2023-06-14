package aa5_woodshops;

/**
 * Clase para gestionar los productos.
 * De ella nacen las clases ARTICULO,BARNIZ Y TABLERO
 * @author Jordi Hortigüela Estrada
 */
public abstract class Producto {

    /**
     *
     */
    protected String codigo;

    /**
     *
     */
    protected String descripcion;

    /**
     *
     */
    protected Proveedor proveedor;
    private tipoProducto tipo_Producto;
    
    /**
     * Enum que nos dirá el tipo de prodcuto(Tablero,Barniz,Articulo)
     */
    public enum tipoProducto{

        /**
         *
         */
        Tablero,

        /**
         *
         */
        Barniz,

        /**
         *
         */
        Articulo
    }
    /**
     * Metodo constructor para la clase producto
     * @param codigo Añadiremos el codigo del producto
     * @param descripcion Añadiremos la descripcion del producto 
     * @param tipo_Producto Especificaremos el tipo de producto
     * @param proveedor Especificaremos el proveedor que lo suministra
     */
   public Producto(String codigo,String descripcion,tipoProducto tipo_Producto, Proveedor proveedor){
        this.codigo =codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.tipo_Producto = tipo_Producto;
   }
   /**
    * Getter del codigo
    * @return 
    */
    public String getCodigo() {
        return codigo;
    }
    /**
     *  Setter del codigo
     * @param codigo pasamos el codigo como argumento para configurar la variable
     */
   
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Getter de descripcion
     * @return el valor de la descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Setter de descripcion
     * @param descripcion pasamos el parametro de descripcion para configurar la variable
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Getter de proveedor
     * @return nos retorna el proveedor del producto
     */
    public Proveedor getProveedor() {
        return proveedor;
    }
    /**
     * Setter del proveedor 
     * @param proveedor pasamos el parametro proveedor para configurar la variable 
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    /**
     * Getter tipo producto
     * @return devuelve el valor del enum tipo_Producto
     */
    public tipoProducto getTipo_Producto() {
        return tipo_Producto;
    }
    /**
     * Setter tipo producto
     * @param tipo_Producto pasamos el parametro para poder configurarlo en la variable 
     */
    public void setTipo_Producto(tipoProducto tipo_Producto) {
        this.tipo_Producto = tipo_Producto;
    }


}

