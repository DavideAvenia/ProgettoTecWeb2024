import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { Articolo } from '../interfaces/articolo';
import { GestioneArticoliService } from '../services/gestione-articoli.service';
import { HttpClient } from '@angular/common/http';
import { GestioneCarrelloService } from '../services/gestione-carrello.service';
import { GestioneUtenteService } from '../services/gestione-utente.service';
import { Carrello } from '../interfaces/carrello';


@Component({
  selector: 'app-details',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})

export class DetailsComponent {

  gestioneArticoliService: GestioneArticoliService = new GestioneArticoliService(
    inject(HttpClient),
    inject(GestioneUtenteService)
  );

  gestioneCarrelloService: GestioneCarrelloService = new GestioneCarrelloService(
    inject(HttpClient),
    inject(GestioneUtenteService));

  gestioneUtenteService: GestioneUtenteService = new GestioneUtenteService(
    inject(HttpClient),
    inject(Router));

  articolo!: Articolo;
  route: ActivatedRoute = inject(ActivatedRoute);

  idCarrello = this.gestioneUtenteService.getIdCarrello();
  usernameLoggato = this.gestioneUtenteService.getUsername();

  constructor() {
    const idArticolo = parseInt(this.route.snapshot.params['id']);
    this.gestioneArticoliService.getArticoliById(idArticolo).subscribe(
      (data: Articolo) => {
        this.articolo = data;
      },
      error => {
        console.error('Errore durante il recupero dell articolo', error);
      }
    );
  }

  aggiungiCarrello(idArticolo: number, usernameLoggato: string, idCarrello: number) {
    this.gestioneCarrelloService.addArticolo(idArticolo, usernameLoggato, idCarrello)
    .subscribe(
      (carrello: Carrello) => {
        console.log('Articolo aggiunto al carrello:', carrello);
      },
      error => {
        console.error('Errore durante l\'aggiunta dell\'articolo al carrello:', error);
      }
    );
  }
}
