package com.proyecto.proyecto;


import Proyectof.dao.UsuarioProyectoDAO;
import Proyectof.dtos.UsuarioHabilidades;
import Proyectof.dtos.UsuarioProyecto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

//Clase para conectar métodos entre UsuarioHabilidadesDAO y UsuarioHabilidadesResource.
public class UsuarioProyectoResource {
    private UsuarioProyectoDAO dao = new UsuarioProyectoDAO();

    //El administrador agrega colaboradores a los proyectos donde son requeridos.
    @RequestMapping(method = RequestMethod.POST, value = "/agregarUsuarioProyecto/{id_usuario}/{id_proyecto}")
    public void postProyectoHabilidades(@PathVariable("id_usuario") int id_usuario,
                                        @PathVariable("id_proyecto") int id_proyecto) {
        try {
            this.dao.agregarUsuarioProyecto(id_usuario, id_proyecto);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    //El administrador elimina los colaboradores que no son requeridos en el proyecto.
    @RequestMapping(method = RequestMethod.DELETE, value = "/borrarUsuarioProyecto/{id_proyecto}/{id_usuario}")
    public void borrarUsuarioProyecto(@PathVariable("id_proyecto") int id_proyecto, @PathVariable("id_usuario") int id_usuario) throws SQLException {
        new UsuarioProyectoDAO().borrarColabProyecto(id_proyecto, id_usuario);


    }

    //El administrador agrega colaboradores que son requeridos desde la creación del proyecto.
    @RequestMapping(method = RequestMethod.POST, value = "/crearUsuarioProyecto/{id_usuario}/{nombreproyecto}/{fechainicio}")
    public void postProyectoHabilidades(@PathVariable("id_usuario") int id_usuario,
                                        @PathVariable("nombreproyecto") String nombreproyecto,
                                        @PathVariable("fechainicio") String fechainicio) {
        try {
            this.dao.crearUsuarioProyecto(id_usuario, nombreproyecto, fechainicio);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}
