package aa5_woodshops;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Clase para crear tickets
 */
public  class Tickets {
    private int num_ticket;
    private LocalDate fecha;
    private Cliente cliente;
    private float descuento;
    private String nombre_tienda;    
    private ArrayList<LineasTicket> lineas;
    private ArrayList<ResumenTicket> listaResumenTickets;
    /**
     * Constructor de ticket
     * @param num_ticket
     * @param fecha
     * @param c parametro de cliente
     */
    public Tickets(int num_ticket,LocalDate fecha,Cliente c){
        this.num_ticket = num_ticket++;
        this.fecha = fecha;
        this.cliente = c;
        this.lineas = new ArrayList<LineasTicket>();
        this.listaResumenTickets= new ArrayList<ResumenTicket>();


    }
    /**
     * Constructor dos de la clase ticket
     * @param num_ticket
     * @param fecha
     * @param c
     * @param descuento
     * @param nombre nombre de la tienda
     */
    public Tickets(int num_ticket,LocalDate fecha,Cliente c,float descuento,String nombre){
        this.num_ticket = num_ticket++;
        this.fecha = fecha;
        this.cliente = c;
        this.descuento = descuento;
        this.nombre_tienda = nombre;
        this.lineas = new ArrayList<LineasTicket>();
        this.listaResumenTickets= new ArrayList<ResumenTicket>();
    }
    /**
     * Getter de numero de ticket
     * @return
     */
    public int getNum_ticket() {
        return num_ticket;
    }
    /**
     * Setter de numero de ticket
     * @param num_ticket
     */
    public void setNum_ticket(int num_ticket) {
        this.num_ticket = num_ticket;
    }
    /**
     * Getter de numero de ticket
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
     * Getter de cliente
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
     * Metodo para añadir linea al arraylist lineas
     * @param l
     */
    public void AnyadirLinea(LineasTicket l ){
        lineas.add(l);
    }
    /**
     * Metodo para guardar los datos economicos del ticket
     * @return retorna el objeto Datos economicos con los datos de importe y descuento del ticket
     */
    public DatosEconomicosTicket DatosEconomicos(){

       double dto = 0;
       double importe = 0;
       double importe_descuento = 0; 
       for (LineasTicket e : lineas) {
        importe +=  e.ImporteTotal();
       }

       if (this.cliente != null )
       {
         if (this.cliente.getTipoCliente().equals(Cliente.tipo_Cliente.Profesionales)) {
            dto = this.cliente.getDescuento() / 100;
            importe_descuento = importe - (importe * dto );
         }else{
            importe_descuento = importe;
         }
       }else{
        importe_descuento = importe;
       }
       
       return new DatosEconomicosTicket(importe_descuento,dto,importe);
   }
   
    /**
     * Getter del arraylist lineas
     * @return
     */
    public ArrayList<LineasTicket> getLineas() {
        return lineas;
    }
    /**
     * Setter del arraylist de lineas
     * @param lineas
     */
    public void setLineas(ArrayList<LineasTicket> lineas) {
        this.lineas = lineas;
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
     * getter de listaResumenTicket
     * @return listaresumenTicket
     */
    public ArrayList<ResumenTicket> getListaResumenTickets() {
        return listaResumenTickets;
    }
    /**
     * Setter de listaResumenTicket
     * @param listaResumenTickets ArrayList
     */
    public void setListaResumenTickets(ArrayList<ResumenTicket> listaResumenTickets) {
        this.listaResumenTickets = listaResumenTickets;
    }
    /**
     * Método para añadir un resumen de ticket al ArrayList listaResumenTicket
     * @param rt objeto de Resumen Ticket
     * @return listaResumenTicket
     */
    
    /**
     * Getter nombre de tienda
     * @return
     */
    public String getNombre_tienda() {
        return nombre_tienda;
    }
    /**
     * Setter de nombre tienda
     * @param nombre_tienda
     */
    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }
     
}


    
