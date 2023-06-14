package aa5_woodshops;
/**
 * Clase para almacenar cada linea del ticket
 */

public class LineasTicket {

    private double precio=0;
    private Producto producto;
    private int cantidad=0;

    /**
     * Constructor del objeto LineasTicket
     * @param producto Objeto de producto
     * @param precio Parametro de precio del producto
     * @param cantidad parametro de la cantidad que se compra
     */
    public LineasTicket(Producto producto,double precio, int cantidad ){
        this.precio = precio; 
        this.cantidad = cantidad;
        this.producto = producto;
    }
    /**
     * Getter del precio
     * @return
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Setter del precio
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Getter de producto
     * @return
     */
    public Producto getProducto() {
        return producto;
    }
    /**
     * Setter de producto
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    /**
     * getter de cantidad
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Setter de cantidad
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Método para calcular el importe total
     * @return
     */
    public double ImporteTotal(){
        return getPrecio() * getCantidad();
    }
    /**
     * Método toString de la clase LineasTicket
     */
    @Override
    public String toString() {
        return "LineasTicket [precio=" + precio + ", producto=" + producto.getDescripcion() + ", Cantidad=" + cantidad + "]";
    }



}

