import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utente } from '../interfaces/utente';
import { environment } from '../environment';
import { Observable, map } from 'rxjs';
import { RequestLogin } from '../interfaces/request-login';
import { InfoUtente } from '../interfaces/info-utente';
import { Carrello } from '../interfaces/carrello';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class GestioneUtenteService {
  constructor(private http: HttpClient, private router: Router) { }
  readonly apiUrl = environment.apiUrl + '/user';
  private loggedIn: boolean = false;

  register(utente: Utente): Observable<any> {
    console.log(this.apiUrl + '/register');
    return this.http.post<{Messaggio: string, Operazione: string, Dto: any}>(
      this.apiUrl + '/register', utente).pipe(map
      (response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Risultato:', response.Dto);
        return response.Dto;
      })
    );
  }

  login(username: string, password: string) {
    console.log(this.apiUrl + '/login');
    let requestLogin = new RequestLogin(
      username? username : '',
      password? password : ''
    );

    return this.http.post<{Messaggio: string, Operazione: string,
      Token: string, UtenteLoggato: InfoUtente, Carrello: Carrello}>(
      this.apiUrl + '/login', requestLogin).pipe(map
      (response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Token:', response.Token);
        console.log('UtenteLoggato:', response.UtenteLoggato);
        console.log('Carrello:', response.Carrello);
        if (response.Token) {
          this.loggedIn = true;
          localStorage.setItem('jwtToken', response.Token);
          localStorage.setItem('usernameLoggato', response.UtenteLoggato.username);
          localStorage.setItem('idCarrello', response.Carrello.idCarrello.toString());
        }else{
          localStorage.removeItem('jwtToken');
        }
        return response.Token;
      })
    );
  }

  getInfoUtente() {
    console.log(this.getUsername());
    return this.http.post<{Messaggio: string, Operazione: string, Dto: Utente}>(
      this.apiUrl + '/getInfoUtente', this.getUsername()).pipe(map
      (response => {
        console.log('Messaggio:', response.Messaggio);
        console.log('Operazione:', response.Operazione);
        console.log('Dto:', response.Dto);
        return response.Dto;
      })
    );
  }

  logout(): void {
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('usernameLoggato');
    localStorage.removeItem('idCarrello');

    this.loggedIn = false;
    this.router.navigate(['/login']);
  }

  getToken(): string {
    return localStorage.getItem('jwtToken')?.toString() || '';

  }

  getUsername(): string{
    return localStorage.getItem('usernameLoggato')?.toString() || '';
  }

  getIdCarrello(): number{
    return Number(localStorage.getItem('idCarrello'));
  }

  isLoggedIn(): boolean {
    return this.loggedIn;
  }
}
