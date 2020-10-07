import { Component, OnInit } from '@angular/core';
import { ViewprojectcolabService } from "src/app/components/viewprojectscolab/viewprojectcolab.service";


@Component({
  selector: 'app-viewprojectscolab',
  templateUrl: './viewprojectscolab.component.html',
  styleUrls: ['./viewprojectscolab.component.css']
})
export class ViewprojectscolabComponent implements OnInit {

  //Variables
  proyectos = null;
  dato;
  opened = false;

  constructor(
    private viewprojectcolabService: ViewprojectcolabService
  ) { }



  ngOnInit(): void {

    //Obtener ID del Usuario
    this.dato = JSON.parse(localStorage.getItem("usuario")).id;
    console.log(this.dato)

    //Cargar los proyectos por colaborador
    this.viewprojectcolabService.retornar(this.dato).subscribe(result => { this.proyectos = result });

  }

  //Método abrir sidebar
  toggleSidebar() {
    this.opened = !this.opened;
  }


  //Método Cerrar Sesión
  cerrarsesion() {
    localStorage.removeItem("usuario");
  }

}
