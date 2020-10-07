import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioHabilidad } from 'src/app/models/usuariohabilidad';
import { Habilidades } from 'src/app/models/habilidades';
import { Proyecto } from "src/app/models/proyecto";
import { UsuarioxHabilidad } from "src/app/models/UsuarioxHabilidad";

@Injectable({
  providedIn: 'root'
})
export class CreateprojectService {

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  //URL
  api = 'http://localhost:8080/api/';


  //crea un proyecto (paso 1)
  agregarProyecto(proyecto: Proyecto): Observable<Proyecto> {
    const url = 'agregarProyecto/'
    return this.http.post<Proyecto>(this.api + url, proyecto, this.httpOptions);

  }

  //agrega las habilidades al proyecto (paso 2)
  crearProyectoHabilidad(nombreproyecto: string, fechainicio: string, habilidad: string) {
    const url = 'crearProyectoHabilidades';
    let apiURL = `${url}/${nombreproyecto}/${fechainicio}/${habilidad}`;
    return this.http.post(this.api + apiURL, this.httpOptions)

  }
  //obtiene los colab con habilidades (paso 3.1)
  obtenerUsuariosxHabilidad(): Observable<UsuarioxHabilidad[]> {
    const url = 'ObtenerUsuariosHabilidad'
    return this.http.get<UsuarioHabilidad[]>(this.api + url);
  }
  //obtiene las habilidades del select
  obtenerHabilidades(): Observable<Habilidades[]> {
    const url = 'obtenerHabilidades'
    return this.http.get<Habilidades[]>(this.api + url);
  }

  //Agregar los usuarios al proyecto(paso 3)
  crearUsuarioProyecto(id_usuario: number, nombreproyecto: string, fechainicio: string) {
    const url = 'crearUsuarioProyecto'
    let apiURL = `${url}/${id_usuario}/${nombreproyecto}/${fechainicio}`;
    return this.http.post(this.api + apiURL, this.httpOptions)
  }
}