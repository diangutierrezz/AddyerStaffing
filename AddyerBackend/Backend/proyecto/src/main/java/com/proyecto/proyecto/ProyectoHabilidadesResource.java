package com.proyecto.proyecto;

import Proyectof.dao.ProyectoHabilidadesDAO;
import Proyectof.dao.UsuarioProyectoDAO;
import Proyectof.dtos.ProyectoHabilidades;
import Proyectof.dtos.UsuarioProyecto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

//Clase para conectar métodos entre ProyectoHabilidadesDAO y ProyectoHabilidadesResource.
public class ProyectoHabilidadesResource {
  private ProyectoHabilidadesDAO dao = new ProyectoHabilidadesDAO();

  //Agrega habilidades que requiere el proyecto.
  @RequestMapping(method = RequestMethod.POST, value = "/agregarProyectoHabilidades/{id_proyecto}/{habilidad}")
  public void setagregarProyectoHabilidades(@PathVariable("id_proyecto") int id_proyecto,
                                            @PathVariable("habilidad") String habilidad) {
    try {
      this.dao.agregarProyectoHabilidades(id_proyecto,habilidad);
    } catch (SQLException e) {
      System.out.println(e.toString());

      throw new ResponseStatusException(
        HttpStatus.INTERNAL_SERVER_ERROR, "Se ha producido un error al agregar");
    }
  }

  //Elimina las habilidades que no necesita en tal proyecto.
  @RequestMapping(method = RequestMethod.DELETE, value = "/borrarProyectoHabilidades/{id_proyecto}/{id_habilidad}")
  public void borrarHabilidadProyecto(@PathVariable("id_proyecto") int id_proyecto,
                                      @PathVariable("id_habilidad") int id_habilidad)throws SQLException {
    new ProyectoHabilidadesDAO().borrarHabilidadProyecto(id_proyecto,id_habilidad);
  }

  //Agrega habilidades requeridas de un proyecto por medio de su nombre.
  @RequestMapping(method = RequestMethod.POST, value = "/crearProyectoHabilidades/{nombreproyecto}/{fechainicio}/{habilidad}")
  public void crearProyectoHabilidades (@PathVariable ("nombreproyecto") String nombreproyecto,
                                       @PathVariable("fechainicio") String fechainicio,
                                       @PathVariable("habilidad")String habilidad) {
    try {
      this.dao.crearProyectoHabilidadesPorNombre(nombreproyecto, fechainicio, habilidad);
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
  }
}
