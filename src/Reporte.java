import java.util.List;

public class Reporte {

    public void mostrarSolicitudesPendientes(List<Alumno> alumnos) {
        System.out.println("Solicitudes pendientes:");
        for (Alumno alumno : alumnos) {
            for (SolicitudCambio solicitud : alumno.getSolicitudesCambio()) {
                if (solicitud.getEstado().equals("pendiente")) {
                    solicitud.mostrarDetalles();
                }
            }
        }
    }

    public void mostrarUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            usuario.mostrarDetalles();
        }
    }
}