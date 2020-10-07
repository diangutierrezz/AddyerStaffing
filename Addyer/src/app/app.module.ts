import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { SidebarModule } from 'ng-sidebar';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { Ng9RutModule } from 'ng9-rut'

import { AppRoutingModule } from './app-routing.module';
import { AppMaterialModule } from './app-material/app-material.module';
import { AppComponent } from './app.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { LoginComponent } from './components/login/login.component';
import { HomeAdminComponent } from './components/home-admin/home-admin.component';
import { AddusserComponent } from './components/addusser/addusser.component';
import { ViewprojectsadminComponent } from './components/viewprojectsadmin/viewprojectsadmin.component';
import { HomecolabComponent } from './components/homecolab/homecolab.component';
import { ProfilecolabComponent } from './components/profilecolab/profilecolab.component';
import { ViewprojectscolabComponent } from './components/viewprojectscolab/viewprojectscolab.component';
import { CreateprojectComponent } from "../app/components/createproject/createproject.component";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FilterPipe } from './pipes/filter.pipe'
import { LogincolabComponent } from './components/logincolab/logincolab.component'
import { HttpClientModule } from '@angular/common/http';

import { RecoverpassComponent } from './components/recoverpass/recoverpass.component';
import { ViewcolabsComponent } from './components/viewcolabs/viewcolabs.component';
import { validarRutasAdmin } from "../app/components/inicio/validarRutasAdmin";
import { validarRutasColab } from './components/inicio/validarRutasColab';
import { MatStepperModule } from '@angular/material/stepper';
import { MatIconModule } from '@angular/material/icon';
import { ProfileadminComponent } from './components/profileadmin/profileadmin.component';




@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    LoginComponent,
    HomeAdminComponent,
    AddusserComponent,
    ViewprojectsadminComponent,
    HomecolabComponent,
    ProfilecolabComponent,
    ViewprojectscolabComponent,
    CreateprojectComponent,
    FilterPipe,
    LogincolabComponent,
    RecoverpassComponent,
    ViewcolabsComponent,
    ProfileadminComponent,
    
   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AppMaterialModule,
    BrowserAnimationsModule,
    SidebarModule.forRoot(),
    FormsModule,
    CommonModule,
    NgbModule,
    HttpClientModule,
    MatCardModule,
    MatFormFieldModule,
    MatStepperModule,
    MatIconModule,
    ReactiveFormsModule,
    ReactiveFormsModule,
    Ng9RutModule,

  ],
  providers: [validarRutasAdmin, validarRutasColab
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
