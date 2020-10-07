package Proyectof.dtos;

//Clase HABILIDADES de la tabla HABILIDADES en base de datos.
public class Habilidades {

  //Atributos de la clase.
    private int id;
    private String habilidad;

  //Constructor
  public Habilidades(int id, String habilidad) {
    this.id = id;
    this.habilidad = habilidad;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getHabilidad() {
    return habilidad;
  }

  public void setHabilidad(String habilidad) {
    this.habilidad = habilidad;
  }

  @Override
  public String toString() {
    return "Habilidades{" +
      "id=" + id +
      ", habilidad='" + habilidad + '\'' +
      '}';
  }
}
