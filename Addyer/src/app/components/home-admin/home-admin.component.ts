import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-admin',
  templateUrl: './home-admin.component.html',
  styleUrls: ['./home-admin.component.css']
})
export class HomeAdminComponent implements OnInit {

  //Variables
  opened = false;
  dato;

  //Sidebar
  toggleSidebar() {
    this.opened = !this.opened;
  }

  constructor() { }

  
  
  ngOnInit(): void {
    //Guardar ID del usuario
    this.dato = JSON.parse(localStorage.getItem("usuario")).id;
    console.log(this.dato)
  }

  // Cerrar Sesión
  cerrarsesion() {
    localStorage.removeItem("usuario");
  }

}
