import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Usuario } from "src/app/models/usuario";
import { StaffingService } from "src/app/staffing.service";
import { MatDialog } from '@angular/material/dialog';
import { RecoverpassComponent } from '../recoverpass/recoverpass.component';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './logincolab.component.html',
  styleUrls: ['./logincolab.component.css']
})
export class LogincolabComponent implements OnInit {

  //Variables
  usuario: Usuario;
  firstFormGroup: FormGroup;
  mensaje;
  usser;
  pass;
  show: boolean;


  constructor(
   @Inject(DOCUMENT) document,
   private router: Router, 
   private service: StaffingService, 
   public dialog: MatDialog, 
   private _formBuilder: FormBuilder) {
   this.show = false;

  }

  //Método sidebar
  togglePassword() {
    this.show = !this.show;

  }

  ngOnInit(): void {
    //Validaciones del formulario
    this.firstFormGroup = this._formBuilder.group({
      pass: [null, [Validators.required, Validators.minLength(5), Validators.maxLength(10)]],
      user: new FormControl('', Validators.compose([
        Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')
      ])),

    });

  }

  //Método que llama a las validaciones del formulario
  get f() {
    return this.firstFormGroup.controls;
  }

  //Metodo para el login del Colaborador
  logincolab(correo: String, contrasena: String) {

    // Ningún campo vacío 
    if (!correo.trim()) {
      alert("Campo correo vacio");
    }
    else if (!contrasena.trim()) {
      alert("Campo contraseña vacio");
    }

    //Validar login y datos
    else {

      let usuarioDatos = JSON.parse(localStorage.getItem("usuario"));
      this.service.logincolab({ correo, contrasena } as Usuario).subscribe(
        userResponse => {
          if (userResponse[0] == "Usuario no existe") {
            alert("Usuario no se encuentra registrado en la base de datos")
          } else {
            localStorage.setItem("usuario", JSON.stringify(userResponse[0]));
            this.router.navigate(['homecolab'])
          }
        },
        error => {
          alert("Los datos no coinciden o no tiene permisos")
        })
    }

  }

  //Método para abrir dialog de recuperar contraseña
  openDialog() {
    const dialogRef = this.dialog.open(RecoverpassComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });

  }

}