package com.proyecto.proyecto;


import Proyectof.dao.ProyectoDAO;
import Proyectof.dtos.Proyecto;
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
public class ProyectoResource {
    private ProyectoDAO dao = new ProyectoDAO();

    //El administrador agrega un proyecto nuevo con su respectiva información.
    @RequestMapping(method = RequestMethod.POST, value = "/agregarProyecto/")
    public void agregarProyecto(@RequestBody Proyecto p) {
        try {
            this.dao.agregarProyecto(p);
        } catch (SQLException e) {
            System.out.println(e.toString());

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Se ha producido un error al crear proyecto"
            );
        }
    }

    //Lo creamos pero no lo habilitamos ya que en el requerimiento del proyecto nos pedía un historial.
    /* @RequestMapping(method = RequestMethod.DELETE, value = "/proyecto/{id}")
    public void borrarProyecto(@PathVariable("id") long id) throws SQLException {
    new ProyectoDAO().borrarProyecto(id);
    }*/

    //El Administrador modifica el proyecto según su necesidad.
    @RequestMapping(method = RequestMethod.PUT, value = "/modificarProyecto/{id}")
    public void modificarProyecto(@PathVariable("id") long id,
                                  @RequestBody Proyecto p) throws SQLException {
        new ProyectoDAO().modificarProyecto(id, p);
    }

    //Muestra los proyectos registrados
    @RequestMapping(method = RequestMethod.GET, value = "/obtenerProyectos")
    public List<Proyecto> getProyectos() {
        List<Proyecto> proyectos = new ArrayList<>();

        try {
            proyectos = this.dao.mostrarProyectos();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return proyectos;
    }

    //Muestra los proyectos asignados al colaborador.
    @RequestMapping(method = RequestMethod.GET, value = "/obtenerProyectosPorColab/{id}")
    public List<Proyecto> getProyectosColab(@PathVariable("id") int id) throws SQLException {
        List<Proyecto> proyectos = new ProyectoDAO().obtenerProyectoColab(id);
        return proyectos;
    }

    //Muestra información completa de los proyectos por medio del id del mismo.
    @RequestMapping(method = RequestMethod.GET, value = "/proyectoPorProyecto/{id}")
    public List<Proyecto> getProyectosPorId(@PathVariable("id") int id) throws SQLException {
        List<Proyecto> proyecto = new ProyectoDAO().obtenerProyectoPorId(id);
        {
            return proyecto;
        }
    }

}
