/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa5_woodshops;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Programa de gestion de tiendas
 * @author Jordi
 * 
 */
public class AA5_WoodShops {

   /**
    * Constante que nos indicará el nombre de la central
    */
    private static final String nombre_empresa = "BricoTienda";
    /**
     * 
     * @param args Main del programa
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        AA5_WoodShops ws = new AA5_WoodShops();
       
        Central central = new Central(nombre_empresa);
        
        /**
         * Llamada al metodo clearScreen para que limpie la pantalla
         */
        ws.clearScreen();
        /**
         * Llamada al metodo objetos para cargar productos,tiendas y proveedores
         * 
         */
        ws.objetos(central,teclado);
        /**
         * Llamada al metodo menu para que salte el menu por pantalla
         */
        ws.menu(central,teclado);

        
    }


    /**
     * Metodo para imprimir y gestionar las opciones del menu
     * @param central Pasamos el nombre de la empresa. Así accedemos a la clase
     * que nos permite gestionar la lista de las tiendas
     * @param teclado Pasamos la variable teclado de tipo Scanner para hacer lecutas
     */
    void menu(Central central, Scanner teclado ){
        /**
         * Booleano de control para el bucle del menú
         */
        boolean salir = false;
        /**
         * Declaracion de variable para pasar el nombre de tienda con la que queremos trabajar
         */

        do{
            this.clearScreen();
            System.out.println("");
            System.out.println("");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("*    1. Añadir productos a una tienda                             *"); 
            System.out.println("*    2. Listar los productos de una tienda por tipo               *");
            System.out.println("*    3. Mostrar stock de codigo producto                          *");
            System.out.println("*    4. Añadir nuevos clientes en WoodShops                       *");
            System.out.println("*    5. Mostrar listado de todos los clientes indicando el tipo   *");
            System.out.println("*    6. Añadir ticket a tienda                                    *");
            System.out.println("*    7. Mostrar resumen de tickets                                *");
            System.out.println("*    8. Mostrar resumen Ventas                                    *");
            System.out.println("*    0. Salir de la aplicación                                    *");

            System.out.println("-------------------------------------------------------------------");
            System.out.println("Seleccione una opción.");
            String res = teclado.nextLine();
            
            switch(res){
                case "1":
                    anyadir_Productos_Tienda(central,teclado);
                    break;
                case "2":
                    listarProdutosTienda( central,teclado);
                    break;
                case "3":
                    mostrarStockProductoEnTiendas( central,teclado);
                    break;
                case "4":
                    anyadirCliente(central,teclado);
                    break;
                case "5":
                    listadoClientes(central,teclado);
                    break;
                case "6":
                    anyadirTicketATienda(central,teclado);
                    break;
                case "7":
                    mostrarResumenTicket(central,teclado);
                    break;
                case "8":
                    mostrarResumenVentas(central, teclado);
                case "0":
                    salir = true;
                    break;
            }
            if(!res.equals("0")){
                pulsarParaContinuar(teclado);
            }
            

        } while (!salir);

    }
    /**
     * Metodo para añadir productos a una tienda y seleccionar de qué tipo
     * @param central Pasamos el nombre de la empresa principal
     * @param teclado Pasamos teclado de tipo Scanner para poder hacer lecturas
     */
    void anyadir_Productos_Tienda(Central central , Scanner teclado ){

        String codigo= "";
        String descripcion ="";
        String nombre_poveedor="";
        String nif_proveedor="";
        String nombreTienda = "";
        double precio_venta;
        int cantidad = 0;
        float anchura = 0.0f;
        float altura = 0.0f;

        this.clearScreen();
        System.out.println("En qué tienda lo quieres añadir? (" + central.getListaNombreTiendas() + ")");
        nombreTienda = teclado.nextLine();

        Tienda tiendaSeleccionada = central.seleccionarTienda(nombreTienda);

        if(tiendaSeleccionada != null){
            this.LineasBlancas(2);
            System.out.println("Escribe el codigo del producto");
            codigo = teclado.nextLine();
            Stock stockActual = tiendaSeleccionada.buscarPorCodigoDeProducto(codigo);
    
            if (stockActual != null) { // en la tienda ya hay stock de este producto, o lo hubo, el objeto existe

                System.out.println("Qué precio le quiere poner al producto?");
                precio_venta = teclado.nextDouble();
                System.out.println("Qué cantidad quieres añadir?");
                cantidad = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Escribe el nombre del proveedor");
                nombre_poveedor = teclado.nextLine();
                System.out.println("Escribe el nif del proveedor");
                nif_proveedor = teclado.nextLine();
                Proveedor prov = new Proveedor(nombre_poveedor,nif_proveedor);  
                tiendaSeleccionada.anyadirStock(stockActual.getProducto(), precio_venta, cantidad, prov);  
                this.LineasBlancas(3);
                System.out.println("Se han actualizado los datos del stockl del producto " + codigo + " en la tienda " + tiendaSeleccionada.getNombre());
                this.LineasBlancas(3);
            }
            else { // se trata de una entrada nueva de stock ya que no estaba en la lista por ello pediremos toda la información necesaria

                System.out.println("Escribe la descripcion del producto");
                descripcion = teclado.nextLine(); 
                System.out.println("Escribe el nombre del proveedor");
                nombre_poveedor = teclado.nextLine();
                System.out.println("Escribe el nif del proveedor");
                nif_proveedor = teclado.nextLine();
                Proveedor prov = new Proveedor(nombre_poveedor,nif_proveedor);  
                System.out.println("¿Qué tipo de producto desea agregar? (1: Barniz, 2: Articulo, 3: Tablero)");
                int tipo = teclado.nextInt();
                    
                if(tipo == 1){  // BARNIZ
                    
                    System.out.println("Introduce los mililitros");
                    float mililitros = teclado.nextFloat();
                    teclado.nextLine();
                    System.out.println("Escribe el tipo de color 1-Incoloro 2-Caoba 3-Nogal " );
                    String tipo_color = teclado.nextLine();
                    Barniz.tipo_Color eTipoColor = Barniz.tipo_Color.Incoloro;
                    switch(tipo_color)
                    {
                        case "1": 
                        eTipoColor = Barniz.tipo_Color.Incoloro;
                        break;
                        case "2": 
                        eTipoColor = Barniz.tipo_Color.Caoba;
                        break;
                        case "3": 
                        eTipoColor = Barniz.tipo_Color.Nogal;
                        break;
                        default: 
                        eTipoColor = Barniz.tipo_Color.Incoloro;
                        break;
                    }
                    System.out.println("Qué precio le quiere poner al producto?");
                    precio_venta = teclado.nextDouble();
                    System.out.println("Qué cantidad quieres añadir?");
                    cantidad = teclado.nextInt();
                    Producto p = new Barniz(codigo,descripcion,prov,mililitros,eTipoColor);
            
                    tiendaSeleccionada.anyadirStock(p, precio_venta, cantidad, prov);  
                }
        
                if(tipo == 2){
                        
                    System.out.println("Introduce los tipo de artículo 1- Estanteria, 2- Mesa, 3- Silla, 4- Armario ");
                    String tipo_articulo = teclado.nextLine();
                    Articulo.tipo_Articulo eTipoArticulo;
                    switch(tipo_articulo)
                    {
                        case "1": 
                        eTipoArticulo = Articulo.tipo_Articulo.Estanteria;
                        break;
                        case "2": 
                        eTipoArticulo = Articulo.tipo_Articulo.Mesa;
                        break;
                        case "3": 
                        eTipoArticulo =Articulo.tipo_Articulo.Silla;
                        break;
                        case "4": 
                        eTipoArticulo =Articulo.tipo_Articulo.Armario;
                        break;
                        default: 
                        eTipoArticulo =Articulo.tipo_Articulo.Estanteria;
                        break;
                    }
        
                    System.out.println("Qué precio le quiere poner al producto?");
                    precio_venta = teclado.nextDouble();
                    System.out.println("Qué cantidad quieres añadir?");
                    cantidad = teclado.nextInt();
                    Producto p = new Articulo(codigo,descripcion,prov,eTipoArticulo );

                    tiendaSeleccionada.anyadirStock(p, precio_venta, cantidad, prov);

                }
                if(tipo == 3){
                    System.out.println("Introduce los tipo de tablero  1-AGLOMERADO, 2-CONTRACHAPADO, 3-MDF");
                    String tipo_tablero = teclado.nextLine();
                    Tablero.tipo_Tablero eTipoTablero;
                    switch(tipo_tablero)
                    {
                        case "1": 
                        eTipoTablero =  Tablero.tipo_Tablero.AGLOMERADO;
                        break;
                        case "2": 
                        eTipoTablero =  Tablero.tipo_Tablero.CONTRACHAPADO;
                        break;
                        case "3": 
                        eTipoTablero =  Tablero.tipo_Tablero.MDF;
                        break;
                        default: 
                        eTipoTablero =  Tablero.tipo_Tablero.AGLOMERADO;
                        break;
                    }
        
                    System.out.println("Introduce la altura del tablero");
                    altura = teclado.nextFloat();
                    System.out.println("Introduce la anchura del tablero");
                    anchura= teclado.nextFloat();
                    System.out.println("Qué precio le quiere poner al producto?");
                    precio_venta = teclado.nextDouble();
                    System.out.println("Qué cantidad quieres añadir?");
                    cantidad = teclado.nextInt();
                    Producto p = new Tablero(codigo,descripcion,prov,altura,anchura,eTipoTablero);
                
                    tiendaSeleccionada.anyadirStock(p, precio_venta, cantidad, prov);
                }

                this.LineasBlancas(3);
                System.out.println("Se ha generado un nuevo stock para el producto " + codigo + " en la tienda " + tiendaSeleccionada.getNombre());
                this.LineasBlancas(3);
            }


    

        }
        else{  // si la tienda que ha seleccionado no existe, lo decimos por pantalla y le pedimos que vuelva a entrar a la opción
            System.out.println("La tienda no existe, ves al menú principal y vuelve a seleccionar la tienda");
        }


    }
    /**
     * Método para listar los productos de una tienda seleccionando el tipo
     * @param central Pasamos el nombre de la empresa principal
     * @param teclado Pasamos teclado de tipo Scanner para poder hacer lecturas
     */
    void listarProdutosTienda( Central central, Scanner teclado  ){

        this.clearScreen();
        System.out.println("En que tienda quieres listar los productos? (" + central.getListaNombreTiendas() + ")");
        String nombreTienda  = teclado.nextLine();  
        this.LineasBlancas(3);   

        System.out.println("Qué tipo de producto quieres listar? 1-Barniz / 2- Articulo / 3-Tablero ");
        int tipoProducto = teclado.nextInt();
        Tienda tiendaSeleccionada = central.seleccionarTienda(nombreTienda);
        ArrayList<Stock> llista;
        if(tipoProducto == 1){
            llista = tiendaSeleccionada.buscarPorTipoProducto(Producto.tipoProducto.Barniz);
        }else if(tipoProducto == 2){
            llista = tiendaSeleccionada.buscarPorTipoProducto(Producto.tipoProducto.Articulo);
        }else{
            llista = tiendaSeleccionada.buscarPorTipoProducto(Producto.tipoProducto.Tablero);
        }

        this.LineasBlancas(3);
        System.out.println("La lista de productos de la tienda" + nombreTienda +" es :");
        this.LineasBlancas(2);

        for (Stock s : llista) {
            System.out.println(s.ToString());    
        }
        this.LineasBlancas(3);
    } 
   /**
     * Metodo para mostrar el stock de un producto introduciendo su código
     * @param central Pasamos el nombre de la empresa principal
     * @param teclado Pasamos teclado de tipo Scanner para poder hacer lecturas
     */
    void mostrarStockProductoEnTiendas(Central central , Scanner teclado ) {
        this.clearScreen();
        System.out.println("Introduce el código del producto:");
        String codigo = teclado.nextLine();
        this.LineasBlancas(1); 
        ArrayList<Tienda> listaTiendas = central.getlistaTiendas();
        
        for(Tienda t : listaTiendas)
        {
          Stock s = t.buscarPorCodigoDeProducto(codigo);
          int quantiat = 0;
          if (s != null )
          {
              quantiat = s.getCantidad();   
              if (quantiat > 0)
              {
                System.out.println("En la tienda " + t.getNombre() + " tenemos un stock de " + quantiat + " unidades del producto con código " + codigo);       
              }   
          }        
        }
        this.LineasBlancas(1);   
    }
    /**
     * Metodo para cargar objetos de producto,tienda,stock y añadirlos a una tineda
     * @param central Pasamos el nombre de la empresa principal
     * @param teclado Pasamos teclado de tipo Scanner para poder hacer lecturas
     */
    void objetos(Central central, Scanner teclado  ){

        Proveedor proveedor1 = new Proveedor( "Proveedor 1","123456789");
        Proveedor proveedor2 = new Proveedor( "Proveedor 2","987654321");

        Producto producto1 = new Barniz("001","Barniz incoloro",proveedor1,500.0f,Barniz.tipo_Color.Incoloro);
        Producto producto2 = new Articulo("002", "ARMARIO",  proveedor2, Articulo.tipo_Articulo.Armario);
        Producto producto3 = new Tablero("003", "Tablero de pino",  proveedor1, 100.0f, 50.0f,Tablero.tipo_Tablero.CONTRACHAPADO);
        Producto producto4 = new Barniz("004", "Barniz Nogal", proveedor1,250.0f,Barniz.tipo_Color.Nogal);
        Producto producto5 = new Articulo("005", "ARMARIO",  proveedor2, Articulo.tipo_Articulo.Mesa);
        Producto producto6 = new Tablero("006", "Tablero Redondo",  proveedor1, 100.0f, 50.0f,Tablero.tipo_Tablero.AGLOMERADO);
        
        Stock p1 = new  Stock(producto1,10.00,70);
        Stock p2 = new  Stock(producto2,350,40);
        Stock p3 = new  Stock(producto3,15.0,60);
        Stock p4 = new  Stock(producto4,25.00,80);
        Stock p5 = new  Stock(producto5,550,90);
        Stock p6 = new  Stock(producto6,15.0,80);

        Tienda t1 = new Tienda("Barcelona", "Calle Gran Via 123");
        Tienda t2 = new Tienda("Madrid", "Calle Alcalà");
        Tienda t3 = new Tienda("Bilbao", "Calle Guipuzcoa");

        t1.anyadirStock(producto1, 20.00, 50, proveedor2);
        t1.anyadirStock(producto2, 200.75, 20, proveedor1);
        t1.anyadirStock(producto5, 250.00, 10, proveedor1);
        t2.anyadirStock(producto3, 150, 40, proveedor2);
        t2.anyadirStock(producto2, 150, 60, proveedor2);
        t2.anyadirStock(producto4, 60, 40, proveedor1);
        t2.anyadirStock(producto6, 60, 30, proveedor1);
        t3.anyadirStock(producto5, 120, 40, proveedor2);
        t3.anyadirStock(producto2, 120, 40, proveedor2);
        t3.anyadirStock(producto6, 200.00, 40, proveedor1);

        central.AñadirTienda(t1);
        central.AñadirTienda(t2);
        central.AñadirTienda(t3);

        Cliente c1 = new Profesionales ("12345678X","Juan Gonzalez",Cliente.tipo_Cliente.Profesionales,10);
        Cliente c2 = new WoodFriend("12345645F","Ramon Perez",Cliente.tipo_Cliente.WoodFriend,"C001");
        Cliente c3 = new Profesionales("23456789A","Rosa Garcia",Cliente.tipo_Cliente.Profesionales,5);
        Cliente c4 = new WoodFriend("34567890","Maria Gutierrez",Cliente.tipo_Cliente.WoodFriend,"C002");


        central.addCliente(c1);
        central.addCliente(c2);
        central.addCliente(c3);
        central.addCliente(c4);
        
        LocalDate fecha1 = LocalDate.of(2022, 4, 27);
        LocalDate fecha2 = LocalDate.of(2023, 1, 18);
        LocalDate fecha3 = LocalDate.of(2010, 4, 10);
        LocalDate fecha4 = LocalDate.of(2021, 3, 20);
        LocalDate fecha5 = LocalDate.of(2011, 6, 02);
        LocalDate fecha6  = LocalDate.of(2022, 2, 04);
        LocalDate fecha7  = LocalDate.of(2021, 4,9);
        LocalDate fecha8  = LocalDate.of(2022, 7,16);
        LocalDate fecha9  = LocalDate.of(2021, 6,13);
        LocalDate fecha10  = LocalDate.of(2020, 7,11);
        LocalDate fecha11  = LocalDate.of(2023, 1,03);
        LocalDate fecha12  = LocalDate.of(2022, 5,22);
        LocalDate fecha13  = LocalDate.of(2021, 8,29);
        LocalDate fecha14  = LocalDate.of(2022, 3,8);
        LocalDate fecha15  = LocalDate.of(2022, 7,9);


        Tickets ticket1 = new Tickets(1,fecha1,c1,10,"Barcelona");
        Tickets ticket2 = new Tickets(2,fecha2,c2,0,"Barcelona");
        Tickets ticket3 = new Tickets(3,fecha3,c3,5,"Madrid");
        Tickets ticket4 = new Tickets(4,fecha4,c4,0,"Bilbao");
        Tickets ticket5 = new Tickets(5,fecha5,c1,10,"Barcelona");
        Tickets ticket6 = new Tickets(6,fecha6,c2,0,"Bilbao");
        Tickets ticket7 = new Tickets(7,fecha7,c3,5,"Barcelona");
        Tickets ticket8 = new Tickets(8,fecha8,c4,0,"Madrid");
        Tickets ticket9 = new Tickets(9,fecha9,c4,0,"Barcelona");
        Tickets ticket10 = new Tickets(10,fecha10,c4,0,"Madrid");
        Tickets ticket11 = new Tickets(11,fecha11,c3,5,"Bilbao");
        Tickets ticket12 = new Tickets(12,fecha12,c4,0,"Barcelona");
        Tickets ticket13 = new Tickets(13,fecha13,c2,0,"Madrid");
        Tickets ticket14 = new Tickets(14,fecha14,c4,0,"Barcelona");
        Tickets ticket15 = new Tickets(15,fecha15,c1,10,"Bilbao");


        t1.anyadirTicketALista(ticket1);
        t1.anyadirTicketALista(ticket2);
        t1.anyadirTicketALista(ticket3);
        t1.anyadirTicketALista(ticket4);
        t1.anyadirTicketALista(ticket5);
        t1.anyadirTicketALista(ticket6);
        t2.anyadirTicketALista(ticket7);
        t3.anyadirTicketALista(ticket9);
        t1.anyadirTicketALista(ticket10);
        t3.anyadirTicketALista(ticket11);
        t2.anyadirTicketALista(ticket12);
        t2.anyadirTicketALista(ticket8);
        t2.anyadirTicketALista(ticket13);
        t2.anyadirTicketALista(ticket14);
        t2.anyadirTicketALista(ticket15);


        ticket1.AnyadirLinea(new LineasTicket(producto1,10.00, 3));
        t1.eliminarStock(producto1, 2);  
        ticket2.AnyadirLinea(new LineasTicket(producto2,200.75, 2));
        t1.eliminarStock(producto2, 2);  
        ticket3.AnyadirLinea(new LineasTicket(producto5,250.00, 5));
        t1.eliminarStock(producto2, 2);  
        ticket4.AnyadirLinea(new LineasTicket(producto5,250.00, 4));
        t1.eliminarStock(producto5, 1); 
        ticket5.AnyadirLinea(new LineasTicket(producto1,10.00, 4));
        t1.eliminarStock(producto1, 3); 
        ticket6.AnyadirLinea(new LineasTicket(producto2,200.75, 2));
        t2.eliminarStock(producto2, 2); 
        ticket7.AnyadirLinea(new LineasTicket(producto3,150.00, 2));
        t2.eliminarStock(producto3, 2);  
        ticket8.AnyadirLinea(new LineasTicket(producto2,150.00, 1));
        t1.eliminarStock(producto2, 1);  
        ticket9.AnyadirLinea(new LineasTicket(producto5,250.00, 1));
        t1.eliminarStock(producto5, 2);  
        ticket10.AnyadirLinea(new LineasTicket(producto2,200.75, 1));
        t1.eliminarStock(producto2, 2);  
        ticket11.AnyadirLinea(new LineasTicket(producto5,250.00, 3));
        t1.eliminarStock(producto5, 2);  
        ticket12.AnyadirLinea(new LineasTicket(producto2,150.00, 1));
        t2.eliminarStock(producto2, 2);  
        ticket13.AnyadirLinea(new LineasTicket(producto1,10.00, 1));
        t1.eliminarStock(producto1, 2);  
        ticket14.AnyadirLinea(new LineasTicket(producto5,120.00, 2));
        t3.eliminarStock(producto5, 2);  
        ticket15.AnyadirLinea(new LineasTicket(producto6,200.00, 2));
        t3.eliminarStock(producto6, 2);  



    }
    /**
     * Metodo para limpiar la pantalla
     */
    private void clearScreen()
    {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }         
    }
    /**
     * Metodo para que el usuario pulse para continuar
     * @param teclado variable para hacer la lecrtura de lo que ponga el usuario
     */
    public void pulsarParaContinuar(Scanner teclado) {
        System.out.print("Pulsa cualquier tecla para continuar...");
        teclado.nextLine();
        
    }
    /**
     * Metodo par añadir lineas en blanco de separación
     * @param quantes parámetro para indicar cuántas lineas blancas queremos
     */
    private void LineasBlancas(int quantes)
    {
        for (int i = 0; i < quantes; i++) {
            System.out.println();
        }         
    }
    /**
     * Método para añadir clientes a la central
     * @param cen Paramentro de la central
     * @param teclado Parametro para ver lo que ingresa el usuario.
     * @return
     */
    public Cliente anyadirCliente(Central cen,Scanner teclado){
        String codigo= "";
        float descuento = 0;

        System.out.println("Introduce el NIF del cliente");
        String NIF = teclado.nextLine();
        System.out.println("Escribe el nombre del cliente");
        String nombre = teclado.nextLine();
        System.out.println("Selecciona el tipo de cliente: 1- Profesionales / 2- WoodFriend");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        if(cen.buscarCliente(NIF) == null){
            if(opcion == 1){
                System.out.println("Qué descuento se le aplicará?");
                descuento = teclado.nextFloat();
                Cliente c =  new Profesionales(NIF,nombre,Cliente.tipo_Cliente.Profesionales,descuento);
                cen.getListaClientes().add(c); 
                return c;

            }else{
                System.out.println(("Introduce el código del cliente"));
                codigo = teclado.nextLine();
                Cliente c = new WoodFriend(NIF, nombre, Cliente.tipo_Cliente.WoodFriend, codigo);
                cen.getListaClientes().add(c); 
                return c;

            }
            
        }else{
            System.out.println("El cliente con el NIF: " + NIF+ "  y el nombre:" +  nombre + " ya está en la base de datos");
            return null;
        }  

    }
    /**
     * Mérodo para listar los clientes y separarlos por tipo
     * @param central parametro de la central
     * @param teclado parametro para poder leer lo que pone el usuario
     */
    public void listadoClientes(Central central, Scanner teclado){
        System.out.println("Los clientes son: \n");

        for(Cliente cl : central.getListaClientes()){
            
          System.out.println(cl.getNIF() + " / " + cl.getNombre()+ "\n");
        }
        System.out.println("\n//////////////////////");
        System.out.println("Clientes Profesionales \n" + central.listarClientesBytipo(Cliente.tipo_Cliente.Profesionales)+ "\n");

        System.out.println("\n//////////////////////");
        System.out.println("Clientes WoodFriend\n" +  central.listarClientesBytipo(Cliente.tipo_Cliente.WoodFriend) + "\n");

    }
    /**
     * Método para añadir un ticket a una tienda determinada
     * @param c parametro de la central
     * @param teclado parametro para poder leer lo que pone el usuario
     */
    public void anyadirTicketATienda(Central c, Scanner teclado){
        boolean encontrado = false;
        String res = "";
        Cliente cliente = null;
        String nombre_tienda = "";
        String nombre_cliente = "";
        String NIF = "";

        System.out.println("En qué tienda quieres generar el ticket?");
        nombre_tienda = teclado.nextLine();

        System.out.println("El cliente tiene ficha?");
        res = teclado.nextLine();

        if(res.equalsIgnoreCase("Si")){

            System.out.println("Introduce el NIF del cliente");
            NIF = teclado.nextLine();

            for(Cliente cl : c.getListaClientes()){
                if(cl.getNIF().equals(NIF)){
                    nombre_cliente = cl.getNombre();
                    cliente = cl;
                    encontrado = true;//Se ha encontrado el cliente en la lista
                }
            }
            if(!encontrado){
            
                System.out.println("El cliente no está en la lista ");
            }
            
        }else{
            System.out.println("Quieres crear ficha de cliente?");
            res = teclado.nextLine();
            if(res.equalsIgnoreCase("Si")){
                cliente = anyadirCliente(c, teclado);
            }
        }


        boolean salir = false;
        Tienda t = c.seleccionarTienda(nombre_tienda);
        LocalDate fecha_actual = LocalDate.now();
     
        int num = t.ultimoNumTicket();

        Tickets ticket = new Tickets(num, fecha_actual, cliente);

        System.out.println("Ticket num: " + num + " fecha: " + fecha_actual + " Cliente: " + nombre_cliente);

        do{
            int opcio = 0;
            System.out.println(t.getListaNombreProductos());
            System.out.println("Qué producto quieres marcar?\n");
            String codigo = teclado.nextLine();
            Stock stock = t.buscarPorCodigoDeProducto(codigo);
            System.out.println("Escribe la cantidad");
            int cantidad = teclado.nextInt();
            t.eliminarStock(stock.getProducto(), cantidad);  /// hemos eliminado la cantidad de productos que venderemos
            ticket.AnyadirLinea(new LineasTicket(stock.getProducto(), stock.getPrecio_venta(), cantidad));

            System.out.println("Quieres marcar más productos? Para seguir marca 1 / Para salir marca 0");
            opcio = teclado.nextInt();
            teclado.nextLine();

            if(opcio == 0){
                salir = true;
                t.anyadirTicketALista(ticket);
            }
            for(Tickets tk : t.getListaTickets()){
                if(tk.getNum_ticket() == num){
                    System.out.println("****************************************************************");
                    System.out.println(" Numero de ticket : " + ticket.getNum_ticket());
                    System.out.println(" Cliente: " + nombre_cliente);
                    System.out.println(" Fecha:" + ticket.getFecha()+"\n");
                    ticket.getLineas().forEach(e -> System.out.println(" " + e + "                      "));
                    System.out.println("");
                    System.out.println("");
                    System.out.println(" Descuento : " + ticket.DatosEconomicos().getDto() * 100);
                    System.out.println(" Importe Descuento : " + ticket.DatosEconomicos().getDtoAplicado());
                    System.out.println("");
                    System.out.println(" Importe Total : " + ticket.DatosEconomicos().getImporte_con_descuento());
                    System.out.println("****************************************************************");
                    break;
                }
                
            }
            
        }while(!salir);   // al salir del bucle tenemos todas las lineas de ticket guardadas en el ticket

   

    } 
    /**
     * Metodo para mostrar el resumen de los tiquets de una tienda entre dos fechas
     * @param c Parametro de la central
     * @param teclado Parametro para poder leer lo que pone el usuario
     */
    public void mostrarResumenTicket(Central c, Scanner teclado){
        
        System.out.println("De que tienda quieres mostar el resumen de los tickets?");
        String res = teclado.nextLine();
        System.out.println("Indica las fechas de inicio y fin");
        System.out.println("Inicio:");
        String fecha_inicio = teclado.nextLine();
        System.out.println("Fin:");
        String fecha_fin = teclado.nextLine();

        Tienda t = c.seleccionarTienda(res);

        t.resumenTickets(c, res, fecha_inicio, fecha_fin);


        System.out.println("****************************************************************");
        t.resumenTickets(c, res, fecha_inicio, fecha_fin).forEach(e -> System.out.println(" " + e                  ));                     
        System.out.println("");
        System.out.println("");
        System.out.println("****************************************************************");
    }
    
    public void mostrarResumenVentas(Central c, Scanner teclado){

        double suma = 0;
        double importeTotal_ticket = 0;

        System.out.println("\nIndica entre qué fechas quieres ver el resumen de ventas");
        System.out.println("Indica la fecha de inicio: \n");
        String fecha_inicio = teclado.nextLine();
        System.out.println("Indica la fecha de fin: \n");
        String fecha_fin = teclado.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate fecha_1 = LocalDate.parse(fecha_inicio, formatter);
        LocalDate fecha_2 = LocalDate.parse(fecha_fin, formatter);
        System.out.println("=========================================================");
        for(Tienda t: c.getListaTiendas()){
            System.out.printf("|%-55s|\n", "Tienda: " + t.getNombre());
            for(Tickets tk: t.getListaTickets()){
                if (tk.getFecha().isAfter(fecha_1) && tk.getFecha().isBefore(fecha_2)){
                    importeTotal_ticket += tk.DatosEconomicos().getImporte_con_descuento();
                }
            }
            System.out.printf("|%-55s|\n", "Importe total = " + importeTotal_ticket);
            suma += importeTotal_ticket;
            importeTotal_ticket = 0;
        }
        System.out.printf("|%-55s|\n","");
        System.out.printf("|%-55s|","La facturación total de las tiendas es : " + suma);
        System.out.println("\n=========================================================");

    }      
}


