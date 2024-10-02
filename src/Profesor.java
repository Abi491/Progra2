import java.util.List;

public class Profesor extends Usuario {
    private String departamento;
    private List<Curso> cursosDictados;

    public Profesor(String nombre, String id, String correo, String departamento) {
        super(nombre, id, correo);
        this.departamento = departamento;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Profesor: " + nombre + ", Departamento: " + departamento);
        mostrarCursosDictados();
    }

    public void mostrarCursosDictados() {
        System.out.println("Cursos dictados: ");
        for (Curso curso : cursosDictados) {
            curso.mostrarDetalles();
        }
    }

    public void asignarCurso(Curso curso) {
        cursosDictados.add(curso);
    }
}