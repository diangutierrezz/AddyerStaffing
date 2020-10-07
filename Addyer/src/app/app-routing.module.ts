import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddusserComponent  } from "../app/components/addusser/addusser.component";

import { HomeAdminComponent } from "../app/components/home-admin/home-admin.component";
import { HomecolabComponent  } from "../app/components/homecolab/homecolab.component";
import { InicioComponent  } from "../app/components/inicio/inicio.component";
import { LoginComponent  } from "../app/components/login/login.component";
import { ProfilecolabComponent  } from "../app/components/profilecolab/profilecolab.component";
import { ViewprojectsadminComponent  } from "../app/components/viewprojectsadmin/viewprojectsadmin.component";
import { ViewprojectscolabComponent } from "../app/components/viewprojectscolab/viewprojectscolab.component";
import { CreateprojectComponent } from "../app/components/createproject/createproject.component";
import { LogincolabComponent } from "../app/components/logincolab/logincolab.component";
import { ViewcolabsComponent } from "../app/components/viewcolabs/viewcolabs.component";
import { RecoverpassComponent } from "../app/components/recoverpass/recoverpass.component";
import { ProfileadminComponent } from "../app/components/profileadmin/profileadmin.component";
import { validarRutasAdmin  } from "../app/components/inicio/validarRutasAdmin";
import { validarRutasColab } from "../app/components/inicio/validarRutasColab";



const routes: Routes = [
  { path: "", component:InicioComponent},
  { path: "login", component:LoginComponent},
  { path: "homeadmin", component:HomeAdminComponent, canActivate: [validarRutasColab] },
  { path: "addusser", component:AddusserComponent, canActivate: [validarRutasColab]},
  { path: "viewprojectsadmin", component:ViewprojectsadminComponent},
  { path: "homecolab", component:HomecolabComponent, canActivate: [validarRutasAdmin]},
  { path: "profilecolab", component:ProfilecolabComponent, canActivate: [validarRutasAdmin]},
  { path: "viewprojectscolab", component:ViewprojectscolabComponent, canActivate: [validarRutasAdmin]},
  { path: "createproject", component:CreateprojectComponent, canActivate: [validarRutasColab]},
  { path: "logincolab", component:LogincolabComponent},
  { path: "viewcolabs", component:ViewcolabsComponent, canActivate: [validarRutasColab]},
  { path:"recoverpass", component:RecoverpassComponent},
  { path: "viewcolabs", component:ViewcolabsComponent, canActivate: [validarRutasColab]},
  { path: "profileadmin", component:ProfileadminComponent},
 


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
