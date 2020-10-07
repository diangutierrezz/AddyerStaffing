import { Component, OnInit, Input } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { ViewcolabsService } from '../viewcolabs/viewcolabs.service';
import { MatDialog } from '@angular/material/dialog';
import { Router, RouterLink } from '@angular/router';


@Component({
  selector: 'app-viewcolabs',
  templateUrl: './viewcolabs.component.html',
  styleUrls: ['./viewcolabs.component.css'],
})
export class ViewcolabsComponent implements OnInit {

  //Variables
  usuario: Usuario[] = [];
  columnasAMostrar: String[] = ['rol', 'nombre', 'apellido', 'rut', 'correo', 'cargo', 'botonModificar', 'botonEliminar'];
  opened = false;
  cargo: string[] = ["Ayudante", "Coordinador", "Facilitador", "Mentor", "Profesor", "Tutor"];
  rol: string[] = ["Colaborador", "Administrador"];
  index: number = null;
  @Input() data: string[];

  constructor(
    private viewcolabsService: ViewcolabsService,
    public dialog: MatDialog,
    private router: Router
  ) { }

      
  ngOnInit(): void {
    //Cargar datos en la tabla
    this.actualizarTabla();

  }

  //Método Cerrar Sesión
  cerrarsesion() {
    localStorage.removeItem("usuario");

  }

  //Método abrir Sidebar
  toggleSidebar() {
    this.opened = !this.opened;

  }

  //Método para cargar cambios en la tabla
  actualizarTabla() {
    this.viewcolabsService.obtenerUsuarios()
      .subscribe(usuario => this.usuario = usuario);

  }

  //Método guardar ID en indice de la tabla
  guardarIndex(i: number) {
    this.index = i;
    console.log(this.index)
    console.log(this.usuario[this.index].id)
    console.log(this.usuario[this.index])

  }

  //Método borrar usuario de la tabla
  borrarUsuario() {
    this.viewcolabsService.borrarUsuario(this.usuario[this.index].id).subscribe();
    this.usuario = this.usuario.filter(
      (c) => c.rut != this.usuario[this.index].rut
    );
    this.index = null;

  }

  
  //Método modificar datos del usuario
  modificar(ro: string, nombre: string, apellido: string, carg: string) {
    this.viewcolabsService.modificarUsuario(this.usuario[this.index].id, ro, nombre, apellido, carg).subscribe(_ => alert('Usuario actualizado'));
    this.index = null
    window.location.reload();

  }


}


