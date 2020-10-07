import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from'@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario  } from "src/app/models/usuario";

@Injectable({
  providedIn: 'root'
})
export class ViewcolabsService {

  constructor(
    private http: HttpClient
  ) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  //URL
  api = "http://localhost:8080/api/ObtenerUsuarios";

  //Servicio cargar todos los usuarios
  obtenerUsuarios(): Observable<Usuario[]>{
    const url = 'ObtenerUsuarios'
    return this.http.get<Usuario[]>(this.api);
    
  }

  //Servicio para borrar usuario
  borrarUsuario(id: number): Observable<number>{
    const url = 'http://localhost:8080/api/borrarUsuario'
    let apiUrl = `${url}/${id}`
    return this.http.delete<number>(apiUrl,this.httpOptions)

  }

  //Servicio modificar datos usuario
  modificarUsuario(id:number, ro:string, nombre:string, apellido:string, carg:string) {
    const url = 'http://localhost:8080/api/modificarUsuario'
    let apiURL = `${url}/${id}/${ro}/${nombre}/${apellido}/${carg}/`;
    return this.http.put(apiURL, this.httpOptions);

  }

}