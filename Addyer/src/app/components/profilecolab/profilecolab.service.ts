import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Usuario } from 'src/app/models/usuario'


@Injectable({
  providedIn: 'root'
})
export class ProfilecolabService {

  //URL
  private api = 'http://localhost:8080/api';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  // ID USUARIO
  dato = JSON.parse(localStorage.getItem("usuario")).id;

  constructor(
    private http: HttpClient
  ) { }

  //Servicio Cambio Clave
  modificarContraseña(usuario: Usuario) {
    const url = '/modificarClave/'
    return this.http.put<Usuario>(this.api + url + this.dato, usuario)
  }

  //Servicio Agregar UsuarioHabilidades
  agregarHabilidades(habilidad: string) {

    const url = 'http://localhost:8080/api/agregarUsuarioHabilidades';
    let apiURL = `${url}/${this.dato}/${habilidad}`;
    return this.http.post(apiURL, this.httpOptions)

  }

  //Servicio cargar datos del Usuario
  retornar(dato) {
    console.log(dato)
    return this.http.get("http://localhost:8080/api/usuario/" + this.dato);

  }

  //Servicio eliminar UsuarioHabilidades
  eliminarUsuarioHabilidad(id_usuario: number, id_habilidad: number) {
    const url = 'http://localhost:8080/api/borrarUsuarioHabilidad'
    let apiURL = `${url}/${id_usuario}/${id_habilidad}`;
    return this.http.delete(apiURL, this.httpOptions);

  }

  //Servicio obtener las habilidades del colaborador
  obtenerColabHabilidades() {
    return this.http.get('http://localhost:8080/api/habilidadesPorColab/' + this.dato);

  }

}
