public abstract class Usuario {
    protected String nombre;
    protected String id;
    protected String correo;

    public Usuario(String nombre, String id, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
    }

    public abstract void mostrarDetalles();  // Método abstracto para ser implementado por las subclases

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }
}