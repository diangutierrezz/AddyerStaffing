package Proyectof.dtos;

//Clase UsuarioXHabilidad de la tabla intermedia UsuarioXHabilidad en base de datos.
public class UsuarioXHabilidad {

    //Atributos de la clase.
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String cargo;
    private String correo;
    private String habilidad;

    //Constructor
    public UsuarioXHabilidad(int id_usuario, String nombre, String apeliido, String cargo, String correo, String habilidad) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apeliido;
        this.cargo = cargo;
        this.correo = correo;
        this.habilidad = habilidad;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
}
