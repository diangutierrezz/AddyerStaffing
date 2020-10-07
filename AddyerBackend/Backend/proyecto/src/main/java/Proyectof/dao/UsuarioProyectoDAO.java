package Proyectof.dao;

import Proyectof.ConnectionManager;
import Proyectof.dtos.ProyectoHabilidades;
import Proyectof.dtos.UsuarioProyecto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//Clase para implementar métodos que relacionan a UsuarioProyecto.
public class UsuarioProyectoDAO {
    private ConnectionManager db = new ConnectionManager();

    //El administrador agrega colaboradores a los proyectos donde son requeridos.
    public void agregarUsuarioProyecto(int id_usuario, int id_proyecto) throws SQLException {
        String query = "insert into usuarioproyecto (id_usuario, id_proyecto) values" +
                " (?,?)";

        PreparedStatement pstmt = this.db.obtenerConexion().prepareStatement(query);
        pstmt.setLong(1, id_usuario);
        pstmt.setLong(2, id_proyecto);

        pstmt.executeUpdate();
        this.db.cerrarConexion();
    }

    //El administrador elimina los colaboradores que no son requeridos en el proyecto.
    public void borrarColabProyecto(int id_proyecto, int id_usuario) throws SQLException {
        String sql = " delete from usuarioproyecto where  id_proyecto = ? and  id_usuario =  ?";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setInt(1, id_proyecto);
        ps.setInt(2, id_usuario);
        ps.executeUpdate();
    }


    //El administrador agrega colaboradores que son requeridos desde la creación del proyecto.
    public void crearUsuarioProyecto(int id_usuario, String nombreproyecto, String fechainicio) throws SQLException {
        String query =
                "insert into usuarioproyecto (id_usuario, id_proyecto) values" +
                        "       (?,(select id from proyecto where nombreproyecto = ? and fechainicio= ?))";

        PreparedStatement pstmt = this.db.obtenerConexion().prepareStatement(query);
        pstmt.setLong(1, id_usuario);
        pstmt.setString(2, nombreproyecto);
        pstmt.setString(3, fechainicio);

        pstmt.executeUpdate();

    }


}
