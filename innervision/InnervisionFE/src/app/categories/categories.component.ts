import { Component, OnInit, inject } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { GestioneArticoliService } from '../services/gestione-articoli.service';
import { Articolo } from '../interfaces/articolo';
import { GestioneCarrelloService } from '../services/gestione-carrello.service';
import { GestioneUtenteService } from '../services/gestione-utente.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ArticoloComponent } from '../articolo/articolo.component';

@Component({
  selector: 'app-category',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent,
    RouterModule,
    FormsModule
  ],
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent {

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

  articoli!: Articolo[];
  route: ActivatedRoute = inject(ActivatedRoute);

  idCarrello = this.gestioneUtenteService.getIdCarrello();
  usernameLoggato = this.gestioneUtenteService.getUsername();

  constructor() {
    const idCategoria = parseInt(this.route.snapshot.params['id']);
    this.gestioneArticoliService.getArticoliByCategoria(idCategoria).subscribe(
      (data: Articolo[]) => {
        this.articoli = data;
      },
      error => {
        console.error('Errore durante il recupero dell articolo', error);
      }
    );
  }

}
