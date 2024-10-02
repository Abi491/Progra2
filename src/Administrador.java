public class Administrador extends Usuario {

    public Administrador(String nombre, String id, String correo) {
        super(nombre, id, correo);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Administrador: " + nombre + ", ID: " + id);
    }

    // Métodos para gestionar solicitudes y asignaciones
    public void aprobarSolicitud(SolicitudCambio solicitud) {
        solicitud.aprobarSolicitud();
        System.out.println("Solicitud aprobada para el cambio de curso.");
    }

    public void rechazarSolicitud(SolicitudCambio solicitud) {
        solicitud.rechazarSolicitud();
        System.out.println("Solicitud rechazada para el cambio de curso.");
    }
}