import { Injectable } from '@angular/core';
import { Articolo } from '../interfaces/articolo';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { environment } from '../environment';
import { GestioneUtenteService } from './gestione-utente.service';

@Injectable({
  providedIn: 'root'
})

export class GestioneArticoliService {

  constructor(private http: HttpClient,
    private gestioneUtenteService: GestioneUtenteService
  ) { }

  readonly apiUrl = environment.apiUrl + '/articoli';

  getAllArticoli(): Observable<Articolo[]> {
    console.log(this.apiUrl + '/getAllArticoli');
    return this.http.get<{Messaggio: string, Operazione: string, Dto: Articolo[]}>(
      this.apiUrl + '/getAllArticoli').pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  getArticoliById(id: number): Observable<Articolo>{
    console.log(this.apiUrl + '/getArticoloById?id=' + id);
    return this.http.get<{Messaggio: string, Operazione: string, Dto: Articolo}>(
      this.apiUrl + '/getArticoloById?id='+ id).pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  getArticoliByNome(nome: String): Observable<Articolo[]>{
    console.log(this.apiUrl + '/getArticoliByNome?nome=' + nome);
    return this.http.get<{Messaggio: string, Operazione: string, Dto: Articolo[]}>(
      this.apiUrl + '/getArticoliByNome?nome='+ nome).pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  getArticoliByMarca(idMarca: Number): Observable<Articolo[]>{
    console.log(this.apiUrl + '/getArticoliByMarca?idMarca=' + idMarca);
    return this.http.get<{Messaggio: string, Operazione: string, Dto: Articolo[]}>(
      this.apiUrl + '/getArticoliByMarca?idMarca='+ idMarca).pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  getArticoliByCategoria(idCategoria: Number): Observable<Articolo[]>{
    console.log(this.apiUrl + '/getArticoliByCategoria?idCategoria=' + idCategoria);
    return this.http.get<{Messaggio: string, Operazione: string, Dto: Articolo[]}>(
      this.apiUrl + '/getArticoliByCategoria?idCategoria='+ idCategoria).pipe(map(response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  getReccomendArticoli(idUtente: number) {
    const token = this.gestioneUtenteService.getToken();
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });

    console.log(this.apiUrl + '/getReccomendArticoli');
    return this.http.post<{Messaggio: string, Operazione: string, Dto: Articolo[]}>(
      this.apiUrl + '/getReccomendArticoli', idUtente ,{ headers: headers }
    ).pipe(map(response => {
      console.log('Messaggio:', response.Messaggio);
      console.log('Operazione:', response.Operazione);
      console.log('Risultato:', response.Dto);
      return response.Dto;
    }));
  }
}
