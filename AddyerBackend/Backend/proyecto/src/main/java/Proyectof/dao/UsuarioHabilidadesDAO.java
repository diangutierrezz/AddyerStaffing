package Proyectof.dao;

import Proyectof.ConnectionManager;
import Proyectof.dtos.UsuarioHabilidades;
import Proyectof.dtos.UsuarioHabilidades;
import Proyectof.dtos.UsuarioProyecto;
import Proyectof.dtos.UsuarioXHabilidad;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Clase para implementar métodos que relacionan a UsuarioHabilidades.
public class UsuarioHabilidadesDAO {
    private ConnectionManager db = new ConnectionManager();

    //Agrega habilidades cuando el usuario ya está creado.
    public void agregarUsuarioHabilidades(int uh, String h) throws SQLException {
        String query = "insert into usuariohabilidades (id_usuario, id_habilidades) values " +
                " ((select id from usuario where id = ?),(select id from habilidades where habilidad = ?))";

        PreparedStatement pstmt = this.db.obtenerConexion().prepareStatement(query);
        pstmt.setInt(1, uh);
        pstmt.setString(2, h);


        pstmt.executeUpdate();

    }

    //Elimina las habilidades a gusto del usuario.
    public void borrarHabilidadUsuario(long id_usuario, long id_habilidad) throws SQLException {
        String sql = " delete from usuariohabilidades where id_usuario = ? and id_habilidades = ? ";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setLong(1, id_usuario);
        ps.setLong(2, id_habilidad);
        ps.executeUpdate();
    }

    //Agrega habilidades desde el registro del usuario.
    public void CrearUsuarioHabilidades(String rut, String h) throws SQLException {
        String query = " insert into usuariohabilidades (id_usuario, id_habilidades) values " +
                " ((select id from usuario where rut = ?),(select id from habilidades where habilidad = ?))";

        PreparedStatement pstmt = this.db.obtenerConexion().prepareStatement(query);
        pstmt.setString(1, rut);
        pstmt.setString(2, h);
        pstmt.executeUpdate();

    }

    //Muestra los usuarios que contengan la habilidad requerida.
    public List<UsuarioXHabilidad> mostrarUsuarioxHabilidad() throws SQLException {
        List<UsuarioXHabilidad> usuarioxhabilidad = new ArrayList<>();

        Statement stmt = this.db.obtenerConexion().createStatement();
        ResultSet rs = stmt.executeQuery("select  id_usuario, nombre, apellido, cargo, correo, habilidad " +
                "from  usuario " +
                " join usuariohabilidades as u on usuario.id=u.id_usuario " +
                " join habilidades on u.id_habilidades=habilidades.id");

        while (rs.next()) {
            UsuarioXHabilidad uxh = new UsuarioXHabilidad(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("cargo"),
                    rs.getString("correo"),
                    rs.getString("habilidad")
            );
            usuarioxhabilidad.add(uxh);
        }

        return usuarioxhabilidad;
    }


}
