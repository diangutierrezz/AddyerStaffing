package Proyectof.dtos;

//Clase PROYECTO de la tabla PROYECTO en base de datos.
public class Proyecto {

    //Atributos de la clase.
    private int id;
    private String nombreproyecto;
    private String descripcion;
    private String fechainicio;
    private String fechafinal;

    //Constructor
    public Proyecto(int id, String nombreproyecto, String descripcion, String fechainicio, String fechafinal) {
        this.id = id;
        this.nombreproyecto = nombreproyecto;
        this.descripcion = descripcion;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreproyecto() {
        return nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }
}
