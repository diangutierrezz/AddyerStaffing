package com.proyecto.proyecto;

import Proyectof.dao.UsuarioDAO;
import Proyectof.dao.UsuarioHabilidadesDAO;
import Proyectof.dao.UsuarioProyectoDAO;
import Proyectof.dtos.UsuarioHabilidades;
import Proyectof.dtos.UsuarioProyecto;
import Proyectof.dtos.UsuarioXHabilidad;
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

//Clase para conectar métodos entre UsuarioHabilidadesDAO y UsuarioHabilidadesResource.
public class UsuarioHabilidadesResource {
    private UsuarioHabilidadesDAO dao = new UsuarioHabilidadesDAO();

    //Agrega habilidades cuando el usuario ya está creado.
    @RequestMapping(method = RequestMethod.POST, value = "/agregarUsuarioHabilidades/{uh}/{h}")
    public void agregarUsuarioHabilidades(@PathVariable("uh") int uh, @PathVariable("h") String h) {
        try {
            this.dao.agregarUsuarioHabilidades(uh, h);
        } catch (SQLException e) {
            System.out.println(e.toString());

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Se ha producido un error al agregar");
        }
    }

    //Elimina las habilidades a gusto del usuario.
    @RequestMapping(method = RequestMethod.DELETE, value = "/borrarUsuarioHabilidad/{id_usuario}/{id_habilidad}")
    public void borrarUsuarioHabilidades(@PathVariable("id_usuario") long id_usuario,
                                         @PathVariable("id_habilidad") long id_habilidad) throws SQLException {
        new UsuarioHabilidadesDAO().borrarHabilidadUsuario(id_usuario, id_habilidad);

    }

    //Agrega habilidades desde el registro del usuario.
    @RequestMapping(method = RequestMethod.POST, value = "/crearUsuarioHabilidades/{rut}/{h}")
    public void crearUsuarioHabilidades(@PathVariable("rut") String rut, @PathVariable("h") String h) {
        try {
            this.dao.CrearUsuarioHabilidades(rut, h);
        } catch (SQLException e) {
            System.out.println(e.toString());

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Se ha producido un error al agregar");
        }

    }


    //Muestra los usuarios que contengan la habilidad requerida.
    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerUsuariosHabilidad")
    public List<UsuarioXHabilidad> obtenerUsuarioxHabilidad() {
        List<UsuarioXHabilidad> usuarioxhabilidad = new ArrayList<>();

        try {
            usuarioxhabilidad = this.dao.mostrarUsuarioxHabilidad();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return usuarioxhabilidad;
    }

}
