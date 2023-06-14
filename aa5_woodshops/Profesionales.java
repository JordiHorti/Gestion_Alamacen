package aa5_woodshops;
/**
 * Clase para almacenar a los clientes de tipo profesional (Subclase de cliente) 
 */
public class Profesionales extends Cliente {
    private float descuento;
    /**
     * Constructor de la clase profesionales
     * @param NIF Parametro de NIF del cliente
     * @param nombre Parametro de nombre del cliente
     * @param tipoCliente Parametro de tipo enum de tipo cliente
     * @param descuento Paramtro de descuento
     */
    public Profesionales(String NIF,String nombre,tipo_Cliente tipoCliente,float descuento){
        super(NIF,nombre,tipoCliente);
        this.descuento = descuento;
    }
    /**
     * Constructor 2 de profesionales
     * @param NIF paramtro de nif del cliente
     * @param nombre parametro de nombre del cliente
     * @param tipoCliente parametro de tipo enum de tipo de cliente
     */
    public Profesionales(String NIF,String nombre,tipo_Cliente tipoCliente){
        super(NIF,nombre,tipoCliente);
    }
    /**
     * Getter de descuento
     */
    public double getDescuento() {
        return descuento;
    }
    /**
     * Setter de descuento
     * @param descuento parametro de descuento
     */
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    
}
