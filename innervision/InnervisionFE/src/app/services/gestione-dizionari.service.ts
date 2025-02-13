import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environment';
import { Observable, map } from 'rxjs';
import { DizMarchio } from '../interfaces/diz/diz-marchio';
import { DizCategoria } from '../interfaces/diz/diz-categoria';

@Injectable({
  providedIn: 'root'
})
export class GestioneDizionariService {

  constructor(private http: HttpClient) { }

  readonly apiUrl = environment.apiUrl + '/dizionari';

  getMarche(): Observable<DizMarchio[]>{
    console.log(this.apiUrl + '/getDizMarchio');
    return this.http.get<{Messaggio: string, Operazione: string, Dto: DizMarchio[]}>(
      this.apiUrl + '/getDizMarchio').pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  getCategoria(): Observable<DizCategoria[]>{
    console.log(this.apiUrl + '/getDizCategoria');
    return this.http.get<{Messaggio: string, Operazione: string, Dto: DizCategoria[]}>(
      this.apiUrl + '/getDizCategoria').pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }
}
