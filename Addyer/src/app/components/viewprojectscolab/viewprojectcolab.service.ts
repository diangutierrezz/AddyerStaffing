import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ViewprojectcolabService {

  constructor(
    private http: HttpClient
  ) { }  

  //Servicio para cargar los proyectos por colaborador
  retornar(dato) {
    console.log(dato)
    return this.http.get("http://localhost:8080/api/obtenerProyectosPorColab/" + dato);
      
  }     
    
}
