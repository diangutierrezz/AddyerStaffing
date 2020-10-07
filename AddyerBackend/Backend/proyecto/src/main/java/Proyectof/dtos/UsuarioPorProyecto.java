package Proyectof.dtos;

//Clase UsuarioPorProyecto de la tabla intermedia UsuarioPorProyecto en base de datos.
public class UsuarioPorProyecto {

    //Atributos de la clase.
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String cargo;

    //Constructor
    public UsuarioPorProyecto(int id_usuario, String nombre, String apellido, String cargo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
