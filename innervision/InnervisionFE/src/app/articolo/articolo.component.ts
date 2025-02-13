import { Component, Input } from '@angular/core';
import { Articolo } from '../interfaces/articolo';
import { GestioneUtenteService } from '../services/gestione-utente.service';
import { GestioneCarrelloService } from '../services/gestione-carrello.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-articolo',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent,
    RouterModule,
    FormsModule
  ],
  templateUrl: './articolo.component.html',
  styleUrl: './articolo.component.css'
})
export class ArticoloComponent {
  @Input() articolo!: Articolo;
  idCarrello = Number(this.gestioneUtenteService.getIdCarrello()!);
  usernameLoggato = this.gestioneUtenteService.getUsername();

  constructor(private gestioneUtenteService: GestioneUtenteService,
    private gestioneCarrelloService: GestioneCarrelloService
  ){}
}
