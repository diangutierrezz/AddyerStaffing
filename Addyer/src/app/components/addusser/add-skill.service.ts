import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})
export class AddSkillService {

  constructor(private http: HttpClient) { }

  httpOptions={
    headers:new HttpHeaders({'Content-Type':'application/json'}) 
  }

  //URL
  api = "http://localhost:8080/api/";
  

  //Servicio Agregar Habilidades al usuario creado
  crearUsuarioHabilidades(rut: string, habilidad:string){
    const url = 'crearUsuarioHabilidades';
    let apiURL = `${url}/${rut}/${habilidad}`;
    return this.http.post(this.api+apiURL, this.httpOptions)

  }

}
