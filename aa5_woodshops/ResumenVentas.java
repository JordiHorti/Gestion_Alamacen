package aa5_woodshops;

import java.time.LocalDate;

public class ResumenVentas {

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private double importeTotal;


    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public ResumenVentas(LocalDate fechaInicio,LocalDate fechaFin){
        this.fecha_fin = fechaInicio;
        this.fecha_fin = fechaFin;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
}
