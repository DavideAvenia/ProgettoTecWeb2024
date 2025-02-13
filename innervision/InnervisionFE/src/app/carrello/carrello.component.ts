import { Component, OnInit } from '@angular/core';
import { Articolo } from '../interfaces/articolo';
import { GestioneCarrelloService } from '../services/gestione-carrello.service';
import { Carrello } from '../interfaces/carrello';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { ArticoloComponent } from '../articolo/articolo.component';
import { GestioneUtenteService } from '../services/gestione-utente.service';

@Component({
  selector: 'app-carrello',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent,
    RouterModule,
    FormsModule
  ],
  templateUrl: './carrello.component.html',
  styleUrl: './carrello.component.css'
})
export class CarrelloComponent implements OnInit{

  carrello!: Carrello;

  constructor(private gestioneCarrelloService: GestioneCarrelloService,
    private gestioneUtenteService: GestioneUtenteService,
    private router: Router){}

  usernameLoggato = this.gestioneUtenteService.getUsername();
  idCarrello = this.gestioneUtenteService.getIdCarrello();

  ngOnInit(): void {
    if(this.gestioneUtenteService.getIdCarrello()){
      let idCarrelloAttuale = this.gestioneUtenteService.getIdCarrello()!;
      this.gestioneCarrelloService.showCarrello(idCarrelloAttuale).subscribe(
        (data: Carrello) => {
          console.log(data);
          this.carrello = data;
        },
        error => {
          console.error('Errore durante il recupero del carrello', error);
        }
      );
    }else{
      this.carrello = new Carrello();
    }
  }

  rimuoviCarrello(idArticolo: number) {
    this.gestioneCarrelloService.removeArticolo(idArticolo, this.usernameLoggato, this.idCarrello)
    .subscribe(
      (carrello: Carrello) => {
        console.log('Articolo rimosso dal carrello:', carrello);
        this.aggiornaCarrello();
      },
      error => {
        console.error('Errore durante l\'aggiunta dell\'articolo al carrello:', error);
      }
    );
  }

  aggiornaCarrello() {
    this.gestioneCarrelloService.showCarrello(this.idCarrello)
      .subscribe(
        (carrello: Carrello) => {
          this.carrello = carrello;
          console.log('Dati carrello aggiornati:', carrello);
        },
        error => {
          console.error('Errore durante l\'aggiornamento del carrello:', error);
        }
      );
    }

  acquistaArticoli() {
    this.gestioneCarrelloService.acquistaArticoli(this.usernameLoggato, this.idCarrello)
    .subscribe(
      (carrello: Carrello) => {
        console.log('Articolo rimosso dal carrello:', carrello);
        this.router.navigate(['/']);
      },
      error => {
        console.error('Errore durante l\'aggiunta dell\'articolo al carrello:', error);
      }
    );
  }
}
