import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  images = [180, 2, 4].map((n) => `https://picsum.photos/id/${n}/600/200`);



  constructor( ) { }


  //Eliminar informacion del usuario.
  ngOnInit(): void {
    localStorage.clear()
  }

}
