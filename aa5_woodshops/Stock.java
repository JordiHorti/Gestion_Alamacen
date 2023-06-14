package aa5_woodshops;
/**
 * Clase que nos permitirá almacenar los productos y asignarles precio y cantidad
 * @author Jordi
 */
public class Stock {

    private Producto producto;
    private int cantidad;
    private double precio_venta;
    /**
     * Constructor de la clase stock
     * @param producto Pasamos el objeto producto que queremos añadir
     * @param precio_venta Fijamos el precio
     * @param cantidad Fijamos la cantidad que queremos añadir
     */
    public Stock(Producto producto,double precio_venta,int cantidad){
        this.producto = producto;
        this.precio_venta= precio_venta;
        this.cantidad= cantidad;
    }
    /**
     * Getter del objeto Producto
     * @return 
     */
    public Producto getProducto() {
        return producto;
    }
    /**
     * Setter del objeto producto
     * @param producto Pasamos el producto que queremos configurar
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    /**
     * Getter de la cantidad que queremos introducir
     * @return la cantidad introducida
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Setter de la cantidad
     * @param cantidad Pasamos la cantidad que queremos introducir
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Getter de precio
     * @return retorna el precio que tiene el producto
     */
    public double getPrecio_venta() {
        return precio_venta;
    }
    /**
     * Setter de precio
     * @param precio_venta  Pasamos el precio que queremos poner al producto
     */
    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
    /**
     * Metodo toString para imprimir el producto del stock
     * @return 
     */
    public String ToString(){
        String s = "";
        s= "Producto : " + this.producto.getCodigo() +" - " +this.producto.getTipo_Producto() + " - " + this.producto.getDescripcion() + " - del proveedor: "+ this.producto.getProveedor().getNombre() +  "\nCantidad :  " + this.getCantidad() + "\nPrecio : " + this.getPrecio_venta() + "\n----------------------------------------------------------- ";
        return s;
    }
    
    
}
