import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Usuario } from "src/app/models/usuario";
import { StaffingService } from "src/app/staffing.service";
import { MatDialog } from '@angular/material/dialog';
import { RecoverpassComponent } from '../recoverpass/recoverpass.component';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //Variables
  usuario: Usuario;
  firstFormGroup: FormGroup;
  show: boolean;

  constructor(
    @Inject(DOCUMENT) document,
    private router: Router,
    private service: StaffingService,
    public dialog: MatDialog,
    private _formBuilder: FormBuilder) {
    this.show = false;
  }

  //Ver contraseña
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
  //Error campos vaacios
  get f() {
    return this.firstFormGroup.controls;
  }

  loginAdmin(correo: String, contrasena: String) {
    //Validar campos Vacios
    if (!correo.trim()) {
      alert("Campo correo vacio");
    }
    else if (!contrasena.trim()) {
      alert("Campo contraseña vacio");
    }
    //Login
    else {
      let usuarioDatos = JSON.parse(localStorage.getItem("usuario"));
      this.service.loginAdmin({ correo, contrasena } as Usuario).subscribe(
        userResponse => {
          if (userResponse[0] == "Usuario no existe") {
            alert("Usuario no se encuentra registrado en la base de datos")
          } else {
            localStorage.setItem("usuario", JSON.stringify(userResponse[0]));
            this.router.navigate(['homeadmin'])
          }
        },
        error => {
          alert("Los datos no coinciden o no tiene permisos")
        })
    }

  }

  //Dialog para recuperar contraseña
  openDialog() {
    const dialogRef = this.dialog.open(RecoverpassComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}