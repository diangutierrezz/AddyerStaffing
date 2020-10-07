import { Component, Inject, Input, OnInit, ɵConsole } from '@angular/core';
import { ProfilecolabService } from 'src/app/components/profilecolab/profilecolab.service'
import { Usuario } from 'src/app/models/Usuario'
import { DOCUMENT } from '@angular/common';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Habilidades } from "src/app/models/habilidades";
import { ViewprojectsService } from "../viewprojectsadmin/viewprojects.service";

@Component({
  selector: 'app-profilecolab',
  templateUrl: './profilecolab.component.html',
  styleUrls: ['./profilecolab.component.css']
})
export class ProfilecolabComponent implements OnInit {

  constructor(
    @Inject(DOCUMENT) document, 
    private profilecolabService: ProfilecolabService,
    private _formBuilder: FormBuilder, 
    private viewproyectsservice: ViewprojectsService
  ) {
    this.show = false;

  }

  // Variables
  contrasena: String = "";
  dato;
  usuario: Usuario[] = [];
  @Input() usuarioo: Usuario
  mensaje;
  habilidadSeleccionada;
  firstFormGroup: FormGroup;
  usuarios = null;
  mostrarAlerta = false;
  habilidadesColaborador = null;
  habilidades: Habilidades[] = [];
  show: boolean;
  opened = false;
  columnasH: String[] = ['habilidades', 'boton'];
  index: number = null;

   //Método mostrar contraseña
  togglePassword() {
    this.show = !this.show;
    
  }

  //Método para abrir Sidebar
  toggleSidebar() {
    this.opened = !this.opened;

  }

  ngOnInit(): void {
    //Obtener el id del colaborador
    this.dato = JSON.parse(localStorage.getItem("usuario")).id;
    console.log(this.dato);

    //Datos del colaborador
    this.profilecolabService.retornar(this.dato).subscribe(
      result => {
        this.usuarios = result,
        this.habilidadesDelColaborador()
      }

    );
    //Todas las habilidades
    this.viewproyectsservice.obtenerHabilidades().subscribe(result => this.habilidades = result)
    console.log(this.habilidades, "Select")

    //Validaciones del formulario
    this.firstFormGroup = this._formBuilder.group({
      contrasena: [null, [Validators.required, Validators.minLength(5), Validators.maxLength(10)]],
    });

  }

  //Mostrar las habilidades del colaborador
  habilidadesDelColaborador() {
    this.profilecolabService.obtenerColabHabilidades().subscribe(
      result => this.habilidadesColaborador = result,
    )

  }

  //Servicio Agregar Habilidad
  agregarUsuarioHabilidad() {
    console.log(this.habilidadSeleccionada)
    this.profilecolabService.agregarHabilidades(this.habilidadSeleccionada).subscribe
      (habilidad => {
        this.mostrarAlerta = true; this.mensaje = 'Se agrego la habilidad ' + this.habilidadSeleccionada + ' Correctamente'
      }, err => { alert(this.habilidadSeleccionada) }
      );

    setTimeout(() => {
      this.mostrarAlerta = false;
    }, 3000);
    this.habilidadesDelColaborador();
  }

  //Servicio Modificar Clave
  CambioClave(contrasena: String) {
    this.profilecolabService.modificarContraseña({ contrasena } as Usuario).subscribe(usuario => {
      this.usuario.toString()
      alert("La contraseña se modifico correctamente")
    });
    contrasena = null;
  }

  //Servicio borrar habilidad colaborador
  borrarHabilidadUsuario() {
    this.profilecolabService.eliminarUsuarioHabilidad(this.dato, this.habilidadesColaborador[this.index].id)
      .subscribe();
    console.log(this.habilidadesColaborador[this.index].id)
    this.habilidadesColaborador = this.habilidadesColaborador.filter(
      (c) => c.habilidad != this.habilidadesColaborador[this.index].habilidad
    );
  }

  // Guardar Id Habilidad para borrar
  guardarIndex(i: number) {
    this.index = i;
    console.log(this.index);
    console.log(this.habilidadesColaborador[this.index].id)

  }

}