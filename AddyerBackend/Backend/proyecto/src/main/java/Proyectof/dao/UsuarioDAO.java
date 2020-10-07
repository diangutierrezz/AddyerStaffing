package Proyectof.dao;

import Proyectof.ConnectionManager;
import Proyectof.dtos.Proyecto;
import Proyectof.dtos.Usuario;
import Proyectof.dtos.UsuarioPorProyecto;


import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

//Clase para implementar métodos que relacionan a Usuario.
public class UsuarioDAO {
    private ConnectionManager db = new ConnectionManager();

    //Registro de Usuarios por parte del Administrador
    public Object agregarUsuario(Usuario u) throws SQLException {
        String validarExiste = "select COUNT(*) as cantidad " +
                "from usuario where correo = ? and rut = ? ";
        PreparedStatement validar = this.db.obtenerConexion().prepareStatement(validarExiste);
        validar.setString(1, u.getCorreo());
        validar.setString(2, u.getRut());
        ResultSet rs = validar.executeQuery();
        rs.next();
        int cantidad = rs.getInt(1);

        if (cantidad > 0) {
            return new Object[]{"Usuario Existe"};
        } else {


            String query = "insert into usuario (rol, nombre, apellido, rut, correo, contrasena, cargo) " +
                    "values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = this.db.obtenerConexion().prepareStatement(query);
            pstmt.setString(1, u.getRol());
            pstmt.setString(2, u.getNombre());
            pstmt.setString(3, u.getApellido());
            pstmt.setString(4, u.getRut());
            pstmt.setString(5, u.getCorreo());
            pstmt.setString(6, u.getContrasena());
            pstmt.setString(7, u.getCargo());
            pstmt.executeUpdate();


            String remitente = "addyer.staffing.project@gmail.com";
            String clave = "paraelproyecto321";
            String destino = u.getCorreo();

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", clave);

            Session session = Session.getDefaultInstance(props);
            MimeMessage mensaje = new MimeMessage(session);

            try {
                mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
                mensaje.setSubject("Acceso al Sistema Staffing de Forge");

                BodyPart parteTexto = new MimeBodyPart();
                parteTexto.setContent("¡Hola " + u.getNombre() + "! <br><br> " +
                        "Bienvenido al Sistema de Staffing de Fundación Forge Chile. <br><br> " +
                        "Tu contraseña provisoria de acceso es: " + "<b>" + u.getContrasena() + "</b> . " +
                        "Una vez dentro del sistema tendrás la opción de cambiarla. <br><br>" +
                        "<b>Nos une el compromiso con el futuro de millones de jóvenes. <b> ", "text/html"


                );

                MimeMultipart todasLasPartes = new MimeMultipart();
                todasLasPartes.addBodyPart(parteTexto);

                mensaje.setContent(todasLasPartes);

                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", remitente, clave);
                transport.sendMessage(mensaje, mensaje.getAllRecipients());
                transport.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return new Object[]{"Usuario Creado"};
    }

    //Eliminar usuario por parte del Administrador.
    public void borrarUsuario(int id) throws SQLException {
        String sqls = "delete from usuario where id = ?";
        PreparedStatement psp = this.db.obtenerConexion().prepareStatement(sqls);
        psp.setInt(1, id);
        psp.executeUpdate();
    }

    //Inicio de sesión del Administrador
    public Object loginAdmin(Usuario u) throws SQLException {
        String sql = "SELECT * FROM USUARIO WHERE CORREO = '" + u.getCorreo() + "' AND CONTRASENA = '" + u.getContrasena() +
                "' AND ROL = 'Administrador'";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String correoUsuario = "";
        String contrasenaUsuario = "";

        int idu = 0;
        String rolu = "";
        String nombreu = "";
        String apellidou = "";
        String rutu = "";
        String correou = "";
        String contrasenau = "";
        String cargou = "";

        while (rs.next()) {
            correoUsuario = rs.getString("correo");
            contrasenaUsuario = rs.getString("contrasena");

            idu = rs.getInt(1);
            rolu = rs.getString(2);
            nombreu = rs.getString(3);
            apellidou = rs.getString(4);
            rutu = rs.getString(5);
            correou = rs.getString(6);
            contrasenau = rs.getString(7);
            cargou = rs.getString(8);
        }


        if (correoUsuario == null || correoUsuario.isEmpty()) {
            this.db.cerrarConexion();
            return new Object[]{"Usuario no existe"};

        }
        if (contrasenaUsuario == null || contrasenaUsuario.isEmpty()) {
            this.db.cerrarConexion();
            return new Object[]{"Usuario no existe"};

        } else {
            Usuario retorno = new Usuario(idu, rolu, nombreu, apellidou, rutu, correou, contrasenau, cargou);
            this.db.cerrarConexion();
            return new Object[]{retorno};
        }
    }

    //Inicio de sesión del Colaborador
    public Object[] logincolab(Usuario a) throws SQLException {
        String sql = "SELECT * FROM USUARIO WHERE CORREO = '" + a.getCorreo() + "' AND CONTRASENA = '" + a.getContrasena() +
                "' AND ROL = 'Colaborador'";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String correoUsuario = "";
        String contrasenaUsuario = "";

        int idu = 0;
        String rolu = "";
        String nombreu = "";
        String apellidou = "";
        String rutu = "";
        String correou = "";
        String contrasenau = "";
        String cargou = "";

        while (rs.next()) {
            correoUsuario = rs.getString("correo");
            contrasenaUsuario = rs.getString("contrasena");

            idu = rs.getInt(1);
            rolu = rs.getString(2);
            nombreu = rs.getString(3);
            apellidou = rs.getString(4);
            rutu = rs.getString(5);
            correou = rs.getString(6);
            contrasenau = rs.getString(7);
            cargou = rs.getString(8);
        }


        if (correoUsuario == null || correoUsuario.isEmpty()) {
            this.db.cerrarConexion();
            return new Object[]{"Usuario no existe"};

        }
        if (contrasenaUsuario == null || contrasenaUsuario.isEmpty()) {
            this.db.cerrarConexion();
            return new Object[]{"Usuario no existe"};

        } else {
            Usuario retorno = new Usuario(idu, rolu, nombreu, apellidou, rutu, correou, contrasenau, cargou);
            this.db.cerrarConexion();
            return new Object[]{retorno};
        }
    }

    //Cambio de contraseña a gusto del usuario.
    public void modificarContraseña(long id, Usuario u) throws SQLException {

        String sql = "update Usuario set contrasena=? where id=? ";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setString(1, u.getContrasena());
        ps.setLong(2, id);
        ps.executeUpdate();

    }

    //Modifica datos de un usuario según sea necesario.
    public void modificarUsuario(long id, String rol, String nombre, String apellido, String cargo) throws SQLException {
        String sql = "update usuario set rol = ?, nombre = ?, apellido = ?, cargo = ?  where id = ? ";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setString(1, rol);
        ps.setString(2, nombre);
        ps.setString(3, apellido);
        ps.setString(4, cargo);
        ps.setLong(5, id);
        ps.executeUpdate();

    }

    //Muestra los datos de usuarios registrados en la base de datos.
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> COLABORADORES = new ArrayList<Usuario>();

        Statement stmt = this.db.obtenerConexion().createStatement();
        ResultSet rs = stmt.executeQuery("select ID, ROL, NOMBRE, APELLIDO, RUT, " +
                " CORREO, CONTRASENA, CARGO from USUARIO");

        while (rs.next()) {
            Usuario n = new Usuario(
                    rs.getInt("ID"),
                    rs.getString("ROL"),
                    rs.getString("NOMBRE"),
                    rs.getString("APELLIDO"),
                    rs.getString("RUT"),
                    rs.getString("CORREO"),
                    rs.getString("CONTRASENA"),
                    rs.getString("CARGO")
            );
            COLABORADORES.add(n);
        }

        return COLABORADORES;
    }

    //Envío de contraseña vía email.
    public Object enviarClave(String correo) throws SQLException {
        String sql = "Select contrasena from usuario  where correo = ?";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();
        String contrasenaUsuario = "";
        while (rs.next()) {
            contrasenaUsuario = rs.getString("contrasena");
        }


        if (contrasenaUsuario == null || contrasenaUsuario.isEmpty()) {
            return new Object[]{"Usuario no existe"};
        }

        String remitente = "addyer.staffing.project@gmail.com";
        String clave = "paraelproyecto321";
        String destino = correo;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);

        Session session = Session.getDefaultInstance(props);
        MimeMessage mensaje = new MimeMessage(session);

        try {
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            mensaje.setSubject("Acceso al Sistema Staffing de Forge");

            BodyPart parteTexto = new MimeBodyPart();
            parteTexto.setContent("Estimado(a)" + " <br><br><br> " +
                    "Su contraseña para acceder al sistema es: " + "<b>" + contrasenaUsuario + "</b> " +
                    ".Una vez dentro del sistema le recomendamos cambiar su contraseña.", "text/html");

            MimeMultipart todasLasPartes = new MimeMultipart();
            todasLasPartes.addBodyPart(parteTexto);

            mensaje.setContent(todasLasPartes);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(mensaje, mensaje.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Object[]{"usuario Existe"};
    }

    //Muestra datos completos de los usuarios registrados por medio de id.
    public List<Usuario> obtenerUsuarioPorId(int id) throws SQLException {
        String sql = "select id, rol, nombre, apellido, rut, correo, contrasena, cargo from usuario where id = ? ";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<Usuario> resultado = new LinkedList<>();
        while (rs.next()) {
            Usuario n = new Usuario(
                    rs.getInt("id"),
                    rs.getString("rol"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("rut"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getString("cargo")
            );
            resultado.add(n);
        }
        return resultado;
    }


    //Muestra los colaboradores que fueron asignados a cierto proyecto.
    public List<UsuarioPorProyecto> colabPorProyectos(int id) throws SQLException {
        String sql = "select distinct id_usuario, nombre, apellido, cargo, id_proyecto " +
                "from  usuario " +
                "join usuarioproyecto as u on usuario.id=u.id_usuario  " +
                "join proyecto as p  on u.id_proyecto=p.id " +
                "where id_proyecto = ? ";
        PreparedStatement ps = this.db.obtenerConexion().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<UsuarioPorProyecto> resultado = new LinkedList<>();
        while (rs.next()) {
            UsuarioPorProyecto n = new UsuarioPorProyecto(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("cargo")
            );
            resultado.add(n);
        }

        return resultado;
    }
}
