package aa5_woodshops;
/**
 * Clase para clasificar los clientes WoodFriend
 */
public class WoodFriend extends Cliente {

    private String codigo;
    /**
     * Constructor objeto WoodFriend
     * @param NIF
     * @param nombre
     * @param tipoCliente
     * @param codigo
     */
    public WoodFriend(String NIF,String nombre,tipo_Cliente tipoCliente,String codigo){
        super(NIF,nombre,tipoCliente);
        this.codigo = codigo;

    }
    /**
     * Getter codigo
     * @return
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Setter codigo
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
