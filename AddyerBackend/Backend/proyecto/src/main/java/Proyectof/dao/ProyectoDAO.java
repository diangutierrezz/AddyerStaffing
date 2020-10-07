package Proyectof.dao;

import Proyectof.ConnectionManager;
import Proyectof.dtos.Proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Clase para implementar métodos que relacionan a Proyecto.
public class ProyectoDAO {
    private ConnectionManager db = new ConnectionManager();

    //El administrador agrega un proyecto nuevo con su respectiva información.
    public void agregarProyecto(Proyecto p) throws SQLException {

        String query = "insert into proyecto (nombreproyecto, descripcion, fechainicio, fechafinal) " +
                "values (?, ?, ?, ?)";
        PreparedStatement pstmt = this.db.obtenerConexion().prepareStatement(query);
        pstmt.setString(1, p.getNombreproyecto());
        pstmt.setString(2, p.getDescripcion());
        pstmt.setString(3, p.getFechainicio());
        pstmt.setString(4, p.getFechafinal());
        pstmt.executeUpdate();
    }

    //Lo creamos pero no lo habilitamos ya que en el requerimiento del proyecto nos pedía un historial.
    public void borrarProyecto(long id) throws SQLException {
        String sql = "delete from proyecto where id = ? ";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();

    }

    //El Administrador modifica el proyecto según su necesidad.
    public void modificarProyecto(long id, Proyecto p) throws SQLException {
        String sql = "update proyecto set  nombreproyecto=?, descripcion = ?, fechainicio = ?, " +
                "fechafinal = ?  where id = ? ";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setString(1, p.getNombreproyecto());
        ps.setString(2, p.getDescripcion());
        ps.setString(3, p.getFechainicio());
        ps.setString(4, p.getFechafinal());
        ps.setLong(5, id);
        ps.executeUpdate();
    }

    //Muestra los proyectos registrados
    public List<Proyecto> mostrarProyectos() throws SQLException {
        List<Proyecto> proyectos = new ArrayList<>();

        Statement stmt = this.db.obtenerConexion().createStatement();
        ResultSet rs = stmt.executeQuery("select * from proyecto");

        while (rs.next()) {
            Proyecto p = new Proyecto(
                    rs.getInt("id"),
                    rs.getString("nombreproyecto"),
                    rs.getString("descripcion"),
                    rs.getString("fechainicio"),
                    rs.getString("fechafinal")
            );
            proyectos.add(p);
        }


        return proyectos;
    }

    //Muestra los proyectos asignados al colaborador.
    public List<Proyecto> obtenerProyectoColab(int id) throws SQLException {

        List<Proyecto> proyectosColab = new ArrayList<>();
        String sql = " select id_proyecto, nombreproyecto, descripcion, fechainicio, fechafinal" +
                " from  usuario join usuarioproyecto as u on usuario.id = u.id_usuario join" +
                " proyecto on u.id_proyecto = proyecto.id where usuario.id = " + Long.toString(id);
        Statement stmt = this.db.obtenerConexion().createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Proyecto p = new Proyecto(
                    rs.getInt("id_proyecto"),
                    rs.getString("nombreproyecto"),
                    rs.getString("descripcion"),
                    rs.getString("fechainicio"),
                    rs.getString("fechafinal")
            );
            proyectosColab.add(p);
        }


        return proyectosColab;
    }

    //Muestra información completa de los proyectos por medio del id del mismo.
    public List<Proyecto> obtenerProyectoPorId(int id) throws SQLException {
        String sql = "select id, nombreproyecto, descripcion, fechainicio, fechafinal from proyecto where id = ? ";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<Proyecto> resultado = new LinkedList<>();
        while (rs.next()) {
            Proyecto p = new Proyecto(
                    rs.getInt("id"),
                    rs.getString("nombreproyecto"),
                    rs.getString("descripcion"),
                    rs.getString("fechainicio"),
                    rs.getString("fechafinal")
            );
            resultado.add(p);
        }
        return resultado;
    }


}
