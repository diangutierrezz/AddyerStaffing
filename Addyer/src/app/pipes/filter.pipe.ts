import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, arg: any): any {
    if (arg === '' || arg.length < 2) return value;
    const resultPosts = [];
    for (const usuarioHabilidad of value) {
      if (usuarioHabilidad.habilidad.toLowerCase().indexOf(arg.toLowerCase()) > -1) {
        resultPosts.push(usuarioHabilidad);
      };
      if (usuarioHabilidad.cargo.toLowerCase().indexOf(arg.toLowerCase())  > -1) {
        resultPosts.push(usuarioHabilidad);
      };
      if (usuarioHabilidad.nombre.toLowerCase().indexOf(arg.toLowerCase())  > -1) {
        resultPosts.push(usuarioHabilidad);
      };
      if (usuarioHabilidad.apellido.toLowerCase().indexOf(arg.toLowerCase())  > -1) {
        resultPosts.push(usuarioHabilidad);
      };
    };
    return resultPosts;
  }
}