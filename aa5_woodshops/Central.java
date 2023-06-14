package aa5_woodshops;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * librería para poder trabajar con ArrayList
 */
import java.util.ArrayList;

/**
 * Clase de la empresa principal que nos servirá para gestionar las tiendas
 * @author Jordi Hortigüela Estrada
 */
public class Central {
    private ArrayList<Tienda> listaTiendas;
    private ArrayList<Cliente> listaClientes;

   
    private String nombre; 
    /**
     * metodo constructor de la clase
     * @param nombre Pasaremos el nombre para identificar la empresa
     */
    public Central(String nombre){
        this.nombre= nombre;
        this.listaTiendas = new ArrayList<Tienda>();
        this.listaClientes = new ArrayList<Cliente>();
    }
    


    
    /**
     * Getter ArrayList de tiendas
     * @return nos retorna la lista de tiendas
     */
    public ArrayList<Tienda> getlistaTiendas() {
        return listaTiendas;
    }
    /**
     *  Metodo para conseguir el nombre de las tiendas y concatenarlos en un mensaje
     * @return 
     */
    public String getListaNombreTiendas() {
        String ret="";
        for(Tienda t : listaTiendas) {
             ret += " " + t.getNombre() + ",";
         }  
         return eliminarUltimoCaracter(ret);  //eliminamos el último caràcter ya que siempre queda una "," al final de todo
    }
    /**
     * Setter ArrayList tiendas
     * @param tiendas 
     */
    public void setlistaTiendas(ArrayList<Tienda> tiendas) {
        this.listaTiendas = tiendas;
    }
    /**
     * Getter de nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Setter de nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Getter lista tiendas
     * @return
     */
    public ArrayList<Tienda> getListaTiendas() {
        return listaTiendas;
    }

    /**
     *
     * @param listaTiendas
     */
    public void setListaTiendas(ArrayList<Tienda> listaTiendas) {
        this.listaTiendas = listaTiendas;
    }
    /**
     * Setter lista tiendas
     * @return
     */
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     *
     * @param listaClientes
     */
    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     * Metodo para crear una tienda nueva
     * @param nombre Pasaremos el nombre de la nueva tienda
     * @param direccion Pasaremos la direccion
     * @return retornará el objeto tienda
     */
    public Tienda crearTienda (String nombre,String direccion){
        
        Tienda t = new Tienda(nombre,direccion);
        this.listaTiendas.add(t);

        return t;
    }
    /**
     * Metodo para añadir tienda al ArrayList tienda
     * @param t Pasaremos el objeto tienda para luego poder añadirlo a la lista
     */
    public void AñadirTienda(Tienda t){
        this.listaTiendas.add(t);
    }
    /**
     * Metodo para seleccionar una tienda
     * @param nombre_tienda Pasamos el nombre de la tienda para poder encontrarla
     * @return retorna la tienda encontrada
     */
    public Tienda seleccionarTienda(String nombre_tienda){
        Tienda tiendaEncontrada = null;
        for(Tienda t : listaTiendas) {
            if (t.getNombre().equalsIgnoreCase(nombre_tienda)  ){
                tiendaEncontrada = t;
                break;
            }
         }     
        return tiendaEncontrada;
    }
    /**
     * Metodo para eliminar el último caracter
     * @param str Pasamos la coma que sabra en el metodo getListaNombreTiendas()
     * @return la longitu del string menos -1
     */
    public static String eliminarUltimoCaracter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }
    /**
     * Método para buscar si existe un cliente
     * @param NIF parametro del nif del cliente
     * @return retorna el cliente o null si no existe 
     */
    public Cliente buscarCliente(String NIF){
        Cliente cl = null;
        boolean encontrado = false;
        if(listaClientes != null){
            for(Cliente c: listaClientes){
                if(c.getNIF().equals(NIF)){
                    cl = c;
                    encontrado = true; 
                    break;
                }
            }
        }
        if(!encontrado){
            return null;
        }
        return cl;
    }
    /**
     * Método para añadir un cliente a la lista de cliente
     * @param c parametro de cliente
     */
    public void addCliente(Cliente c){
        this.listaClientes.add(c);
    }
    /**
     * Método para listar los clientes por el tipo que se quiera
     * @param tipo parametro de tipo de cliente
     * @return retorna la lista de clientes de ese tipo de cliente
     */
    public ArrayList<Cliente> listarClientesBytipo(Cliente.tipo_Cliente tipo){

         ArrayList<Cliente> listarClienteXtipo = new ArrayList<Cliente>();
        for(Cliente c: listaClientes){
            if(c.getTipoCliente().equals(tipo)){
                listarClienteXtipo.add(c);
            }
        }      
        return listarClienteXtipo;
    }
    public void resumenVentasTiendas(Central c,String p_fecha_inicio, String p_fecha_fin){

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate fecha_1 = LocalDate.parse(p_fecha_inicio, formatter);
        LocalDate fecha_2 = LocalDate.parse(p_fecha_fin, formatter);

        double importeTotal_ticket = 0;

        for(Tienda t: c.getListaTiendas()){
            System.out.println("\n Tienda: \n" + t);
            for(Tickets tk: t.getListaTickets()){
                importeTotal_ticket = tk.DatosEconomicos().getImporte();
                importeTotal_ticket += importeTotal_ticket;
            }
            System.out.println("\n Importe total =  \n" + importeTotal_ticket);
        }
    }
}

 