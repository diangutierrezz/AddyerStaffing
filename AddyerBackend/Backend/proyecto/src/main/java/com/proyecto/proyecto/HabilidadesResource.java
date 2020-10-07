package com.proyecto.proyecto;

import Proyectof.dao.HabilidadesDAO;

import Proyectof.dao.UsuarioDAO;
import Proyectof.dtos.Habilidades;
import Proyectof.dtos.UsuarioHabilidades;
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

//Clase para conectar métodos entre HabilidadesDAO y HabilidadesResource.
public class HabilidadesResource {
    private HabilidadesDAO dao = new HabilidadesDAO();


    //Registra habilidades nuevas.
    @RequestMapping(method = RequestMethod.POST, value = "/agregarHabilidades/")
    public void AgregarHabilidad(@RequestBody Habilidades h) {
        try {
            this.dao.agregarHabilidades(h);
        } catch (SQLException e) {
            System.out.println(e.toString());

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Se ha producido un error al agregar");
        }
    }

    //Lo pensamos para eliminar habilidades que ya se encuentren registradas.
  /*@RequestMapping(method = RequestMethod.DELETE, value = "/habilidad/{id}")
  public void borrarHabilidad(@PathVariable("id") long id) throws SQLException {
    new HabilidadesDAO().borrarHabilidad(id);
  }*/

    //Permite ver las habilidades de un colaborador.
    @RequestMapping(method = RequestMethod.GET, value = "/habilidadesPorColab/{id}")
    public List<Habilidades> HabilidadesPorColab(@PathVariable("id") long id) throws SQLException {
        List<Habilidades> habilidades = new HabilidadesDAO().obtenerHabilidadesColab(id);
        return habilidades;
    }

    //Permite ver las habilidades de un proyecto.
    @RequestMapping(method = RequestMethod.GET, value = "/habilidadesPorProyecto/{id}")
    public List<Habilidades> HabilidadesPorProyecto(@PathVariable("id") long id) throws SQLException {
        List<Habilidades> habilidades = new HabilidadesDAO().obtenerHabilidadesProyecto(id);
        return habilidades;
    }

    //Muestra las habilidades registradas.
    @RequestMapping(method = RequestMethod.GET, value = "/obtenerHabilidades")
    public List<Habilidades> obtenerTodasHabilidades() {
        List<Habilidades> Habilidades = new ArrayList<>();

        try {
            Habilidades = this.dao.mostrarHabilidades();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return Habilidades;
    }
}
