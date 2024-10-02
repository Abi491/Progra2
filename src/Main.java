import java.util.*;

public class Main {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicialización de datos de ejemplo
        inicializarUsuarios();

        boolean loginExitoso = false;
        Usuario usuarioActual = null;

        // Login
        while (!loginExitoso) {
            System.out.println("===== Bienvenido al sistema de gestión de cursos =====");
            System.out.print("Ingrese su usuario: ");
            String id = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            usuarioActual = autenticarUsuario(id, contrasena);
            if (usuarioActual != null) {
                loginExitoso = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Intente nuevamente.");
            }
        }

        // Redirigir según el rol del usuario
        if (usuarioActual instanceof Alumno) {
            menuAlumno((Alumno) usuarioActual);
        } else if (usuarioActual instanceof Profesor) {
            menuProfesor((Profesor) usuarioActual);
        } else if (usuarioActual instanceof Administrador) {
            menuAdministrador((Administrador) usuarioActual);
        }
    }

    // Método para autenticar al usuario
    private static Usuario autenticarUsuario(String id, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id) && usuario.getCorreo().equals(contrasena)) {  // Simulando contraseña con el campo correo para simplificar
                return usuario;
            }
        }
        return null;
    }

    // Inicialización de usuarios (Ejemplo)
    private static void inicializarUsuarios() {
        usuarios.add(new Alumno("Juan Perez", "alum01", "1234", 3, "Ingeniería"));
        usuarios.add(new Profesor("Dra. Marta Ruiz", "prof01", "abcd", "Ciencias"));
        usuarios.add(new Administrador("Admin1", "admin01", "adminpass"));
    }

    // Menú para Alumnos
    private static void menuAlumno(Alumno alumno) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== Menú Alumno =====");
            System.out.println("1. Ver cursos asignados");
            System.out.println("2. Solicitar cambio de curso");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    alumno.mostrarCursosAsignados();
                    break;
                case 2:
                    realizarCambioCurso(alumno);
                    break;
                case 0:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    // Menú para Profesores
    private static void menuProfesor(Profesor profesor) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== Menú Profesor =====");
            System.out.println("1. Ver cursos dictados");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    profesor.mostrarCursosDictados();
                    break;
                case 0:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    // Menú para Administradores
    private static void menuAdministrador(Administrador administrador) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== Menú Administrador =====");
            System.out.println("1. Ver solicitudes de cambio");
            System.out.println("2. Aprobar/Rechazar solicitud de cambio");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    verSolicitudesCambio();
                    break;
                case 2:
                    gestionarSolicitudCambio(administrador);
                    break;
                case 0:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    // Método para que los alumnos realicen solicitudes de cambio
    private static void realizarCambioCurso(Alumno alumno) {
        System.out.println("Ingrese el código del curso actual: ");
        String cursoActualCodigo = scanner.nextLine();
        System.out.println("Ingrese el código del curso nuevo: ");
        String cursoNuevoCodigo = scanner.nextLine();

        // Aquí se podría hacer una búsqueda de cursos por código (simulada)
        Curso cursoActual = new Curso("Matemáticas", cursoActualCodigo, 3, "obligatorio");
        Curso cursoNuevo = new Curso("Historia", cursoNuevoCodigo, 3, "opcional");

        alumno.realizarSolicitudCambio(cursoActual, cursoNuevo);
        System.out.println("Solicitud de cambio realizada.");
    }

    // Métodos de Administrador para gestionar solicitudes de cambio
    private static void verSolicitudesCambio() {
        System.out.println("Mostrando todas las solicitudes de cambio...");
        // Aquí se simularía mostrar las solicitudes pendientes
    }

    private static void gestionarSolicitudCambio(Administrador administrador) {
        System.out.println("Ingrese el ID de la solicitud a gestionar: ");
        String idSolicitud = scanner.nextLine();

        // Aquí se simularía encontrar la solicitud y permitir aprobar o rechazarla
        System.out.println("Solicitud " + idSolicitud + " aprobada.");
    }
}