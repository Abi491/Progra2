public class Curso {
    private String nombre;
    private String codigo;
    private int creditos;
    private String tipo;  // Obligatorio u opcional

    public Curso(String nombre, String codigo, int creditos, String tipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.tipo = tipo;
    }

    public void mostrarDetalles() {
        System.out.println("Curso: " + nombre + " (" + codigo + "), Créditos: " + creditos + ", Tipo: " + tipo);
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}