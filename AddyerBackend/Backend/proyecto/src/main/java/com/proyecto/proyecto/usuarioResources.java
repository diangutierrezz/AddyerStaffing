package com.proyecto.proyecto;

import Proyectof.dao.UsuarioDAO;
import Proyectof.dtos.Usuario;
import Proyectof.dtos.UsuarioPorProyecto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

//Clase para conectar métodos entre ProyectoDAO y ProyectoResource.
public class usuarioResources {

    private UsuarioDAO dao = new UsuarioDAO();

    //Registro de Usuarios por parte del Administrador
    @RequestMapping(method = RequestMethod.POST, value = "/agregarUsuario")
    public Object AgregarUsuario(@RequestBody Usuario n) {
        try {
            return this.dao.agregarUsuario(n);
        } catch (SQLException e) {
            System.out.println(e.toString());

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Se ha producido un error al insertar la usuario"
            );
        }
    }

    //Eliminar usuario por parte del Administrador.
    @RequestMapping(method = RequestMethod.DELETE, value = "/borrarUsuario/{id}")
    public void borrarUsuario(@PathVariable("id") int id) throws SQLException {
        new UsuarioDAO().borrarUsuario(id);
    }

    //Inicio de sesión del Administrador
    @RequestMapping(method = RequestMethod.POST, value = "loginAdmin")
    public Object loginAdmin(@RequestBody Usuario u) throws SQLException {
        return new UsuarioDAO().loginAdmin(u);
    }

    //Inicio de sesión del Colaborador
    @RequestMapping(method = RequestMethod.POST, value = "logincolab")
    public Object loginUsuario(@RequestBody Usuario a) throws SQLException {
        return new UsuarioDAO().logincolab(a);
    }

    //Cambio de contraseña a gusto del usuario.
    @RequestMapping(method = RequestMethod.PUT, value = "/modificarClave/{id}")
    public void cambioDeContraseña(@PathVariable("id") long id,
                                   @RequestBody Usuario u) throws SQLException {
        new UsuarioDAO().modificarContraseña(id, u);
    }

    //Modifica datos de un usuario según sea necesario.
    @RequestMapping(method = RequestMethod.PUT, value = "/modificarUsuario/{id}/{rol}/{nombre}/{apellido}/{cargo}")
    public void putUsuario(@PathVariable("id") long id,
                           @PathVariable("rol") String rol,
                           @PathVariable("nombre") String nombre,
                           @PathVariable("apellido") String apellido,
                           @PathVariable("cargo") String cargo) throws SQLException {
        new UsuarioDAO().modificarUsuario(id, rol, nombre, apellido, cargo);
    }

    //Muestra los datos de usuarios registrados en la base de datos.
    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerUsuarios")
    public List<Usuario> obtenerUsuario() {
        List<Usuario> colab = new ArrayList<>();

        try {
            colab = this.dao.listarUsuarios();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return colab;
    }

    //Envío de contraseña vía email.
    @RequestMapping(method = RequestMethod.GET, value = "/recuperarClave/{correo}")
    public Object recuperarClave(@PathVariable("correo") String correo
    ) throws SQLException {
        return new UsuarioDAO().enviarClave(correo);

    }

    //Muestra datos completos de los usuarios registrados por medio de id.
    @RequestMapping(method = RequestMethod.GET, value = "/usuario/{id}")
    public List<Usuario> obtenerUsuarioPorId(@PathVariable("id") int id) throws SQLException {
        List<Usuario> usuarios = new UsuarioDAO().obtenerUsuarioPorId(id);
        {
            return usuarios;
        }
    }

    //Muestra los colaboradores que fueron asignados a cierto proyecto.
    @RequestMapping(method = RequestMethod.GET, value = "/usuariosPorProyecto/{id}")
    public List<UsuarioPorProyecto> getUsuariosPorProyectos(@PathVariable("id") int id) throws SQLException {
        List<UsuarioPorProyecto> usuarios = new UsuarioDAO().colabPorProyectos(id);
        {
            return usuarios;
        }
    }
}

