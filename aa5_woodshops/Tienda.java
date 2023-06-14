package aa5_woodshops;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Importamos la librería para poder trabajar con ArrayList
 */
import java.util.ArrayList;

/**
 *
 * @author Jordi
 */
public class Tienda {

    private String nombre;
    private String direccion;
    private ArrayList<Stock> listaStock = new ArrayList<Stock>();
    private ArrayList<Tickets> listaTickets = new ArrayList<Tickets>();
 
    /**
     * Constructor clase Tienda
     * @param nombre Pasamos el nombre de la tienda
     * @param dirección Pasamos la direccion de la tienda
     */
    public Tienda(String nombre,String dirección){
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public ArrayList<Tickets> getListaTickets() {
        return listaTickets;
    }

    /**
     *
     * @param listaTickets
     */
    public void setListaTickets(ArrayList<Tickets> listaTickets) {
        this.listaTickets = listaTickets;
    }

    /**
     *
     * @param t
     * @return
     */
    public ArrayList<Tickets> anyadirTicketALista(Tickets t){
        
        listaTickets.add(t);
        
        return listaTickets;
    }
    /**
     * Getter de nombre
     * @return El nombre de la tienda
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Setter de nombre
     * @param nombre Pasamos el nombre que queremos que tenga el atributo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Getter de direccion
     * @return La dirección de la tienda
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Setter de dirección
     * @param direccion Pasamos la direccion de la tienda
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Getter de la lista de stock
     * @return La lista actual de stock
     */
    public ArrayList<Stock> getlistaStock() {
        return listaStock;
    }
    /**
     * Setter de la lista stock
     * @param listaStock Pasamos la lista 
     */
    public void setlistaStock(ArrayList<Stock> listaStock) {
        this.listaStock = listaStock;
    }
    
    /**
     * Metodo para buscar un producto en el stock
     * @param p Pasamos el objeto producto
     * @return el stockEncontrado en caso de encontrarlo o null si no lo encuentra
     */
    public Stock buscarXProdcuto(Producto p) {
        Stock stockEncontrado = null;
        boolean encontrado = false;
        String codi = p.getCodigo();
        if (listaStock != null) {
            for (Stock s : listaStock) {
                Producto producto = s.getProducto();
                if (producto != null && producto.getCodigo().equals(codi)) {
                    stockEncontrado = s;
                    encontrado = true;
                    break;
                }
            }
        }
        if (!encontrado) {
            return null;
        }
        return stockEncontrado;
    }
    /**
     * Metodo para añadir stock
     * @param p Pasamos el objeto producto
     * @param precio Pasamos el precio del producto
     * @param cantidad Pasamos la cantidad que queremos añadir
     * @param proveedor Pasamos el objeto proveedor
     */
    public void anyadirStock(Producto p, double precio, int cantidad, Proveedor proveedor) {
        if (listaStock != null) {
            Stock s = buscarXProdcuto(p);
            if (s != null) {
                if (s.getPrecio_venta() != 0.0) {
                    s.setPrecio_venta(precio);
                }
                s.setCantidad(s.getCantidad() + cantidad);
            } else {
                listaStock.add(new Stock(p, precio, cantidad));
            }
        }
    }  

    /**
     *
     * @param p
     * @param cantidad
     */
    public void eliminarStock(Producto p,int cantidad) {
        if (listaStock != null) {
            Stock s = buscarXProdcuto(p);
            if (s.getCantidad() - cantidad >= 0) {
                s.setCantidad(s.getCantidad() - cantidad);
            } else{
                throw new IllegalArgumentException("La cantidad a eliminar es inválida.");            }
        } else {
            throw new IllegalArgumentException("La lista de stock es nula.");
        }
    }  

    /**
     * Metodo para buscar por codigo un determinado producto
     * @param codigo Pasamos el codigo del producto
     * @return Retorna el stock del producto y si no lo encuentra devuelve null
     */
    public Stock buscarPorCodigoDeProducto(String codigo) {
        

        if (listaStock != null) {
            for (Stock s : listaStock) {
                Producto producto = s.getProducto();
                if (producto != null && producto.getCodigo().equals(codigo)) {
                    return s; // si lo encontramos lo retornamos y salimos de la función. 
                }
            }
        }
        return null;
    }
    /**
     * Metodo para buscar por tipo de producto
     * @param tipo Pasamos el tipo que queremos buscar
     * @return el ArrayList del Stock
     */
    public ArrayList<Stock> buscarPorTipoProducto(Producto.tipoProducto tipo) {
        
        ArrayList<Stock>  ret= new ArrayList<Stock>();

        if (listaStock != null) {
            for (Stock s : listaStock) {
                Producto producto = s.getProducto();
                if (producto != null && producto.getTipo_Producto().equals(tipo)) {
                    ret.add(s);    
                  
                }
            }
        }
        return ret;
    }
    /**
     * Metodo para añadir un ticket al arraylist de listaTickets
     * @param t ticket
     * @param tienda 
     * @return Arraylist listaTcikets
     */
    public ArrayList<Tickets> addTicket(Tickets t,Tienda tienda){
        boolean encontrado = false;
        for(Tickets tk: listaTickets){
            if(tk.getNum_ticket() == t.getNum_ticket()){
                encontrado = true;
            }
        }
        if(!encontrado){
        listaTickets.add(t);
        return listaTickets;//si no estaba repetido el número de ticket lo añadimos a la lista y lo retornamos
        }

        return null;
    }
    /**
     * Metodo para conseguir el numero del último tiquet y añadirle uno 
     * @return el numero del siguiente ticket
     */
    public int ultimoNumTicket(){
        
        int ultimoNumTicket = listaTickets.size() + 1;
        
        return ultimoNumTicket;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public Producto seleccionarProducto(String codigo){
        for(Stock s : listaStock){
            Producto p = s.getProducto();
            if(p.getCodigo().equalsIgnoreCase(codigo)){
                p = s.getProducto();
                return p;
            }
        }
        return null;
    }
    /**
     * Metodo para imprimir el codigo de producto y la descripcion de todos los productos en el stock
     * @return metodo para eliminar caracter
     */
    public String getListaNombreProductos(){
        String ret = "";
        for(Stock s : listaStock){
            Producto p = s.getProducto();
            System.out.println(p.getCodigo() + " - " +  p.getDescripcion());

        }
        return Central.eliminarUltimoCaracter(ret);

    }
    /**
     * Método para seleccionar un ticket y ver si existe
     * @param num
     * @return el ticket si existe y null si no existe
     */
    public Tickets seleccionarTicket(int num){
        
        for(Tickets tk: listaTickets ){
            if(tk.getNum_ticket() == num){
                return tk;
            }
        }
        return null;

    }
    /**
     * Metodo para crear un objeto de Resumen ticket y almacenarlo en el arraylist listaResumenTickets
     * @param c central
     * @param nombre_tienda
     * @param fecha_inicio
     * @param fecha_fin
     * @return ArrayList listaResumenTickets
     */
    public ArrayList<ResumenTicket> resumenTickets(Central c, String nombre_tienda, String fecha_inicio, String fecha_fin){
           
        ArrayList<ResumenTicket> listaResumenTickets = new ArrayList<>();
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
        LocalDate fecha_1 = LocalDate.parse(fecha_inicio, formatter);
        LocalDate fecha_2 = LocalDate.parse(fecha_fin, formatter);
           
        for (Tienda tienda: c.getListaTiendas()){
            if (tienda.getNombre().equalsIgnoreCase(nombre_tienda)){
                for (Tickets tk: tienda.getListaTickets()){
                    if (tk.getFecha().isAfter(fecha_1) && tk.getFecha().isBefore(fecha_2)){
                        ResumenTicket rt = new ResumenTicket(tk.getNum_ticket(), tk.getFecha(), tk.getCliente(), tk.getDescuento(), tk.DatosEconomicos().getImporte());
                        listaResumenTickets.add(rt);
                    }
                }
            }
        }
        
        return listaResumenTickets;
    }
    
}  

        

