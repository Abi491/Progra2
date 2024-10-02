import java.time.LocalDate;

public class SolicitudCambio {
    private Curso cursoActual;
    private Curso cursoSolicitado;
    private String estado;
    private LocalDate fechaSolicitud;

    public Curso getCursoActual() {
        return cursoActual;
    }

    public void setCursoActual(Curso cursoActual) {
        this.cursoActual = cursoActual;
    }

    public Curso getCursoSolicitado() {
        return cursoSolicitado;
    }

    public void setCursoSolicitado(Curso cursoSolicitado) {
        this.cursoSolicitado = cursoSolicitado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public SolicitudCambio(Curso cursoActual, Curso cursoSolicitado) {
        this.cursoActual = cursoActual;
        this.cursoSolicitado = cursoSolicitado;
        this.estado = "pendiente";
        this.fechaSolicitud = LocalDate.now();
    }

    public void aprobarSolicitud() {
        this.estado = "aprobado";
    }

    public void rechazarSolicitud() {
        this.estado = "rechazado";
    }

    public void mostrarDetalles() {
        System.out.println("Solicitud: Cambio de " + cursoActual.getNombre() + " a " + cursoSolicitado.getNombre() + ". Estado: " + estado);
    }

    // Getters y setters
}