import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Usuario  } from "src/app/models/usuario";
import { UsuarioHabilidad } from './models/UsuarioHabilidad';

@Injectable({
  providedIn: 'root'
})
export class StaffingService {

  constructor(private http: HttpClient) { }
  
  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'}) 
  }

  api = "http://localhost:8080/api/";

  //Ingreso colaborador
  logincolab(usuario: Usuario): Observable<any> {
    const url = 'logincolab'
    return this.http.post<any>(this.api + url, usuario);
  }

  //ingreso administrador
  loginAdmin(usuario: Usuario): Observable<any> {
    const url = 'loginAdmin'
    return this.http.post<any>(this.api + url, usuario);
  }

  // Crear un nuevo usuario
  AgregarUsuario(usuario: Usuario): Observable<Usuario> {
    const url = 'agregarUsuario'
    return this.http.post<Usuario>(this.api + url, usuario, this.httpOptions);
  }

  //obtener usuarios y su habilidad
  obtenerUsuariosxHabilidad(): Observable<UsuarioHabilidad[]>{
    const url = 'ObtenerUsuariosHabilidad'
    return this.http.get<UsuarioHabilidad[]>(this.api + url);
  }
  
  //Recuperar contraseña
  recuperarContrasena(correo: string) {
    const url ='recuperarClave/'
    return this.http.get(this.api + url + correo, this.httpOptions);
  }
}
