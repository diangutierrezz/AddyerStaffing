package Proyectof.dtos;

import java.util.List;

//Clase USUARIO de la tabla USUARIO en base de datos.
public class Usuario {

    //Atributos de la clase.
    private int id;
    private String rol;
    private String nombre;
    private String apellido;
    private String rut;
    private String correo;
    private String contrasena;
    private String cargo;

    //Constructor
    public Usuario(int id, String rol, String nombre, String apellido, String rut, String correo, String contraseña, String cargo) {
        this.id = id;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.contrasena = contraseña;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rut='" + rut + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contrasena + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
