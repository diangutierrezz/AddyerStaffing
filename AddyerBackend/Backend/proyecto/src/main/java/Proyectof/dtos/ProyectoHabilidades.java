package Proyectof.dtos;

//Clase ProyectoHabilidades de la tabla intermedia ProyectoHabilidades en base de datos.
public class ProyectoHabilidades {

  //Atributos de la clase.
  private int id;
  private int id_proyecto;
  private int id_habilidades;

  //Constructor
  public ProyectoHabilidades(int id, int id_proyecto, int id_habilidades) {
    this.id = id;
    this.id_proyecto = id_proyecto;
    this.id_habilidades = id_habilidades;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId_proyecto() {
    return id_proyecto;
  }

  public void setId_proyecto(int id_proyecto) {
    this.id_proyecto = id_proyecto;
  }

  public int getId_habilidades() {
    return id_habilidades;
  }

  public void setId_habilidades(int id_habilidades) {
    this.id_habilidades = id_habilidades;
  }

  @Override
  public String toString() {
    return "ProyectoHabilidades{" +
      "id=" + id +
      ", id_proyecto=" + id_proyecto +
      ", id_habilidades=" + id_habilidades +
      '}';
  }
}
