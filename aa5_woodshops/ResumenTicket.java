package aa5_woodshops;

import java.time.LocalDate;
/**
 * Clase para guardar un resumen de cada ticket
 */
public class ResumenTicket {

    private Tickets ticket;
    private int num_ticket;
    private LocalDate fecha;
    private Cliente cliente;
    private float descuento;
    private double importe;
     /**
      * Constructor de ResumenTicket
      * @param num_ticket
      * @param fecha
      * @param cliente
      * @param descuento
      */
    public ResumenTicket(int num_ticket,LocalDate fecha,Cliente cliente,float descuento){
        this.num_ticket = num_ticket;
        this.fecha = fecha;
        this.cliente = cliente;
        this.descuento = descuento;
        
    } 
    /**
     * Contstructor 2 de resumen ticket 
     * @param num_ticket 
     * @param fecha
     * @param cliente
     * @param descuento
     * @param importe
     */  
    public ResumenTicket(int num_ticket,LocalDate fecha,Cliente cliente,float descuento,double importe){
        this.num_ticket = num_ticket;
        this.fecha = fecha;
        this.cliente = cliente;
        this.descuento = descuento;
        this.importe = importe;
        
    }
    /**
     * Getter de importe
     * @return
     */
    public double getImporte() {
        return importe;
    }
    /**
     * Setter de importe
     * @param importe
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }
    /**
     * Getter de ticket
     * @return
     */
    public Tickets getTicket() {
        return ticket;
    }
    /** 
     * Setter de ticket
     * @param ticket
     */
    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }
    /**
     * Getter de numero de ticket
     * @return
     */
    public int getNum_ticket() {
        return num_ticket;
    }
    /**
     * setter de numero de ticket
     * @param num_ticket
     */
    public void setNum_ticket(int num_ticket) {
        this.num_ticket = num_ticket;
    }
    /**
     * Getter de fecha
     * @return
     */
    public LocalDate getFecha() {
        return fecha;
    }
    /**
     * Setter de fecha
     * @param fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    /**
     * Getter de fecha
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Setter de cliente
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * Getter de descuento
     * @return
     */
    public float getDescuento() {
        return descuento;
    }
    /**
     * Setter de descuento
     * @param descuento
     */
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    /**
     * Método toString de ResumenTicket
     */
    @Override
    public String toString() {
        return "\n---------------------\n ResumenTicket: \n [num_ticket=" + num_ticket + ", fecha=" + fecha + ", cliente=" + cliente + ", descuento="
                + descuento + ", importe total:"  + importe + "]\n";
    }
    
}
