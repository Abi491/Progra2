import java.util.List;

public class Alumno extends Usuario {
    private int semestre;
    private String carrera;
    private List<Curso> cursosAsignados;
    private List<SolicitudCambio> solicitudesCambio;

    public Alumno(String nombre, String id, String correo, int semestre, String carrera) {
        super(nombre, id, correo);
        this.semestre = semestre;
        this.carrera = carrera;
    }

    // Métodos propios del alumno
    public void asignarCurso(Curso curso) {
        cursosAsignados.add(curso);
    }

    public void realizarSolicitudCambio(Curso cursoActual, Curso cursoNuevo) {
        SolicitudCambio solicitud = new SolicitudCambio(cursoActual, cursoNuevo);
        solicitudesCambio.add(solicitud);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Alumno: " + nombre + ", Semestre: " + semestre + ", Carrera: " + carrera);
        mostrarCursosAsignados();
    }

    public void mostrarCursosAsignados() {
        System.out.println("Cursos asignados: ");
        for (Curso curso : cursosAsignados) {
            curso.mostrarDetalles();
        }
    }

    public List<SolicitudCambio> getSolicitudesCambio() {
        return solicitudesCambio;
    }
}