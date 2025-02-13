import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArticoloComponent } from '../articolo/articolo.component';
import { Articolo } from '../interfaces/articolo';
import { GestioneArticoliService } from '../services/gestione-articoli.service';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { GestioneUtenteService } from '../services/gestione-utente.service';
import { Utente } from '../interfaces/utente';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent,
    RouterModule,
    FormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent implements OnInit {

  articoloList: Articolo[] = [];
  ricercaNome: string = ''
  utente!: Utente;

  constructor(private gestioneArticoliService: GestioneArticoliService,
    private gestioneUtenteService: GestioneUtenteService
  ) { }

  ngOnInit(): void {
    if (this.gestioneUtenteService.getUsername()) {
      this.gestioneUtenteService.getInfoUtente().subscribe(
        (data: Utente) => {
          this.utente = data;

          if (this.utente.acquistiEffettuati && this.utente.acquistiEffettuati.length > 0 && this.utente.idUtente) {
            this.gestioneArticoliService.getReccomendArticoli(this.utente.idUtente).subscribe(
              (data: Articolo[]) => {
                this.articoloList = data;
              },
              error => {
                console.error('Errore durante il recupero degli articoli', error);
              }
            );
          } else {
            this.gestioneArticoliService.getAllArticoli().subscribe(
              (data: Articolo[]) => {
                this.articoloList = data;
              },
              error => {
                console.error('Errore durante il recupero degli articoli', error);
              }
            );
          }
        },
        error => {
          console.error('Errore durante il recupero delle informazioni utente', error);
        }
      );
    }else{
      this.gestioneArticoliService.getAllArticoli().subscribe(
        (data: Articolo[]) => {
          this.articoloList = data;
        },
        error => {
          console.error('Errore durante il recupero degli articoli', error);
        }
      );
    }
  }

  ricercaPerNome(): void{
    if (!this.ricercaNome) {
      console.error('Il nome non può essere vuoto');
      return;
    }

    this.gestioneArticoliService.getArticoliByNome(this.ricercaNome).subscribe(
      (data: Articolo[]) => {
        this.articoloList = data;
      },
      error => {
        console.error('Errore durante il recupero degli articoli', error);
      }
    );
  }
}
