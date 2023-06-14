package aa5_woodshops;
/**
 * Clase para almacenar los importes de los tiquets
 */
public class DatosEconomicosTicket {
    private double importe_con_descuneto=0;

    /**
     *
     */
    public double dto;

    /**
     *
     */
    public double importe;

    /**
     *
     */
    public double dtoAplicado;
    
    /**
     *
     * @param importe_con_descuento
     * @param dto
     * @param importe
     */
    public DatosEconomicosTicket(double importe_con_descuento, double dto,double importe) {
        this.importe_con_descuneto = importe_con_descuento;
        this.dto = dto;
        this.importe = importe;
        this.setDtoAplicado (importe * dto);
    }
    
    /**
     * Getter del importe del ticket
     * @return
     */
    public double getImporte() {
        return importe;
    }
    /**
     * Setter del importe del ticket
     * @param importe
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }
    /**
     * Getter del descuento
     * @return
     */
    public double getDto() {
        return dto;
    }
    /**
     * Setter del descuento
     * @param dto
     */
    public void setDto(double dto) {
        this.dto = dto;
    }
    /**
     * Getter del descuento aplicado
     * @return
     */
    public double getDtoAplicado() {
        return dtoAplicado;
    }
    /**
     * setter del descuento aplicado
     * @param dtoAplicado
     */
    public void setDtoAplicado(double dtoAplicado) {
        this.dtoAplicado = dtoAplicado;
    }

    /**
     *
     * @return
     */
    public double getImporte_con_descuento() {
        return importe_con_descuneto;
    }

    /**
     *
     * @param importe_con_descuneto
     */
    public void setImporte_con_descuneto(double importe_con_descuneto) {
        this.importe_con_descuneto = importe_con_descuneto;
    }
}