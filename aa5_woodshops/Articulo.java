package aa5_woodshops;

/**
 * Subclase de producto para gestionar los productos de tipo artículo
 * @author Jordi Hortigüela Estrada
 */
public class Articulo extends Producto{

   private tipo_Articulo tipoArticulo;

    /**
    * enum que nos enumera diferentes tipos de artículo
    */
   public enum tipo_Articulo  {
    
       /**
        *
        */
       Estanteria,

       /**
        *
        */
       Mesa,

       /**
        *
        */
       Silla,

       /**
        *
        */
       Armario,
   }
    /**
     * Metodo constructor de la clase Articulo
     * @param codigo Asignaremos un codigo a cada articulo
     * @param descripcion Haremos una descripcion de cada articulo
     * @param proveedor Añadiremos de qué proveedor viene
     * @param tipoArticulo Especificaremos el tipo de articulo
     */
   public Articulo(String codigo,String descripcion,Proveedor proveedor,tipo_Articulo tipoArticulo){
      super(codigo,descripcion,Producto.tipoProducto.Articulo,  proveedor);
      this.tipoArticulo = tipoArticulo;
   }
   /**
    * Getter de tipoArticulo (enum)
    * @return retorna el tipo de articulo
    */
   public tipo_Articulo getTipoArticulo() {
      return tipoArticulo;
   }
   /**
    * Setter de tipoArticulo(enum)
    * @param tipoArticulo 
    */
   public void setTipoArticulo(tipo_Articulo tipoArticulo) {
      this.tipoArticulo = tipoArticulo;
   }
   
}
 
   
