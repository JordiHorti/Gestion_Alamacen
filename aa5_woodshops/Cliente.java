package aa5_woodshops;
/**
 * Clase para gestionar los clientes de toda la empresa 
 */
public abstract class Cliente {

    /**
     *
     */
    protected String NIF;

    /**
     *
     */
    protected String nombre;
    private tipo_Cliente tipoCliente;
    private double descuento = 0;
   
     
    /**
     * Enum de tipo cliente
     */
    public enum tipo_Cliente{

        /**
         *
         */
        Profesionales,

        /**
         *
         */
        WoodFriend
    }
    /**
     * Constructor objeto cliente
     * @param NIF parametro del NIF del cliente
     * @param nombre parametro del nombre del cliente
     * @param tipoCliente parametro del tipo de cliente
     */
    public Cliente(String NIF, String nombre,tipo_Cliente tipoCliente){
        this.setNIF(NIF); 
        this.setNombre(nombre);
        this.setTipoCliente(tipoCliente);
    }
    /**
     * Constructor 2 del objeto cliente
     * @param NIF paramtro de NIF del cliente
     * @param nombre parametro del nombre del cliente
     * @param tipoCliente parametro del tipo de cliente
     * @param descuento parametro del porcentaje de descuento
     */
    public Cliente(String NIF, String nombre,tipo_Cliente tipoCliente, double descuento){
        this.setNIF(NIF); 
        this.setNombre(nombre);
        this.setTipoCliente(tipoCliente);
        this.setDescuento(descuento);
    }
    /**
     * Getter del  nif del cliente
     * @return
     */
    public String getNIF() {
        return NIF;
    }
    /**
     * Setter del nif
     * @param nIF
     */
    public void setNIF(String nIF) {
        NIF = nIF;
    }
    /**
     * Getter del nombre del cliente
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Setter del nombre del cliente
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Getter del tipo de cliente
     * @return
     */
    public tipo_Cliente getTipoCliente(){
        return tipoCliente;
    }
    /**
     * Setter del tipo de cliente
     * @param tipoCliente
     */
    public void setTipoCliente(tipo_Cliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    /**
     * Getter del descuento que tiene el cliente
     * @return
     */
    public double getDescuento() {
        return descuento;
    }
    /**
     * Setter del descuento que tiente el cliente
     * @param descuento
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    /**
     * Método toString del objeto cliente
     */
    @Override
    public String toString() {
        return "\n Cliente [NIF=" + NIF + ", nombre=" + nombre + ", tipoCliente=" + tipoCliente + "] " ;
    }
}
