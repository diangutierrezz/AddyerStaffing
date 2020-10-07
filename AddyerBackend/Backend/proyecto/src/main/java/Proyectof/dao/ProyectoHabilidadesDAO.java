package Proyectof.dao;

import Proyectof.ConnectionManager;
import Proyectof.dtos.ProyectoHabilidades;
import Proyectof.dtos.UsuarioProyecto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//Clase para implementar métodos que relacionan a ProyectoHabilidades.
public class ProyectoHabilidadesDAO {
  private ConnectionManager db = new ConnectionManager();

  //Agrega habilidades que requiere el proyecto.
  public void agregarProyectoHabilidades(int id_proyecto, String habilidad) throws SQLException {
    String query = "insert into proyectohabilidades (id_proyecto, id_habilidades) values " +
      " (?,(select id from habilidades where habilidad = ?))";

    PreparedStatement pstmt = this.db.obtenerConexion().prepareStatement(query);
    pstmt.setLong(1, id_proyecto);
    pstmt.setString(2, habilidad);


    pstmt.executeUpdate();

  }

  //Elimina las habilidades que no necesita en tal proyecto.
  public void borrarHabilidadProyecto(int id_proyecto,int id_habilidad ) throws SQLException {
    String sql = " delete from proyectohabilidades where id_proyecto = ? and  id_habilidades = ? ";
    PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
    ps.setLong(1, id_proyecto);
    ps.setLong(2, id_habilidad);
    ps.executeUpdate();
  }

  //Agrega habilidades requeridas de un proyecto por medio de su nombre.
  public void crearProyectoHabilidadesPorNombre(String nombreproyecto, String fechainicio, String habilidad) throws SQLException {
    String query = "insert into proyectohabilidades (id_proyecto,id_habilidades) values " +
            "((Select id from proyecto where nombreproyecto = ? and fechainicio = ?), (select id from habilidades where habilidad = ?))";

    PreparedStatement pstmt = this.db.obtenerConexion().prepareStatement(query);
    pstmt.setString(1, nombreproyecto);
    pstmt.setString(2, fechainicio);
    pstmt.setString(3, habilidad);
    pstmt.executeUpdate();

  }
}
