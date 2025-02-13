import { Component, Input, inject } from '@angular/core';
import { Articolo } from '../interfaces/articolo';
import { GestioneArticoliService } from '../services/gestione-articoli.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ArticoloComponent } from '../articolo/articolo.component';
import { HttpClient } from '@angular/common/http';
import { GestioneCarrelloService } from '../services/gestione-carrello.service';
import { GestioneUtenteService } from '../services/gestione-utente.service';

@Component({
  selector: 'app-brand',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent,
    RouterModule,
    FormsModule
  ],
  templateUrl: './brand.component.html',
  styleUrl: './brand.component.css'
})
export class BrandComponent {
    gestioneArticoliService: GestioneArticoliService = new GestioneArticoliService(
    inject(HttpClient),
    inject(GestioneUtenteService)
  );

    gestioneCarrelloService: GestioneCarrelloService = new GestioneCarrelloService(
      inject(HttpClient),
      inject(GestioneUtenteService)
    );

    gestioneUtenteService: GestioneUtenteService = new GestioneUtenteService(
      inject(HttpClient),
      inject(Router)
    );

    articoli!: Articolo[];
    route: ActivatedRoute = inject(ActivatedRoute);

    idCarrello = this.gestioneUtenteService.getIdCarrello();
    usernameLoggato = this.gestioneUtenteService.getUsername();

    constructor() {
      const idMarca = parseInt(this.route.snapshot.params['id']);
      this.gestioneArticoliService.getArticoliByMarca(idMarca).subscribe(
        (data: Articolo[]) => {
          this.articoli = data;
        },
        error => {
          console.error('Errore durante il recupero dell articolo', error);
        }
      );
    }
}
