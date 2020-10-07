import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Usuario } from 'src/app/models/usuario'


@Injectable({
  providedIn: 'root'
})
export class ProfileadminService {

  //URL
  private api = 'http://localhost:8080/api';
  //ID usuario
  dato = JSON.parse(localStorage.getItem("usuario")).id;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  constructor(
    private http: HttpClient
  ) { }

  //Servicio para cargar datos en la card
  retornar(dato) {
    console.log(dato)
    return this.http.get("http://localhost:8080/api/usuario/" + dato);

  }

  //Servicio para cambiar contraseña
  modificarContraseña(usuario: Usuario) {
    const url = 'http://localhost:8080/api/modificarClave/'
    return this.http.put<Usuario>(url + this.dato, usuario)

  }
  
}