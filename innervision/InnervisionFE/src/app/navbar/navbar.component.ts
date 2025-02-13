import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { DizCategoria } from '../interfaces/diz/diz-categoria';
import { DizMarchio } from '../interfaces/diz/diz-marchio';
import { GestioneDizionariService } from '../services/gestione-dizionari.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ArticoloComponent } from '../articolo/articolo.component';
import { GestioneUtenteService } from '../services/gestione-utente.service';
import { GestioneArticoliService } from '../services/gestione-articoli.service';
import { Articolo } from '../interfaces/articolo';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    CommonModule,
    ArticoloComponent,
    RouterModule,
    FormsModule
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  showDropdown: boolean = false;
  categorieDisponibili!: DizCategoria[];
  marcheDisponibili!: DizMarchio[];
  articoliByCategoria!: Articolo[];
  articoliByMarca!: Articolo[];

  constructor(private gestioneDizionariService: GestioneDizionariService,
    private gestioneUtenteService: GestioneUtenteService,
    private gestioneArticoliService: GestioneArticoliService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.gestioneDizionariService.getCategoria().subscribe(
      (data) => {
        this.categorieDisponibili = data;
      },
      (error) => {
        console.error('Errore durante il recupero delle categorie', error);
      }
    );

    this.gestioneDizionariService.getMarche().subscribe(
      (data) => {
        this.marcheDisponibili = data;

      },
      (error) => {
        console.error('Errore durante il recupero delle marche', error);
      }
    );
  }

  onMouseEnter(): void {
    this.showDropdown = true;
  }

  onMouseLeave(): void {
    this.showDropdown = false;
  }

  logout() {
    this.gestioneUtenteService.logout();
  }

  isLoggedIn(): boolean {
    return this.gestioneUtenteService.isLoggedIn();
  }

  navigateToCategory(idCategoria: number) {
    this.router.navigate(['/brand'], { queryParams: { DizCategoria: idCategoria } })
    this.showDropdown = false;
  }

  navigateToBrand(idMarchio: number) {
    this.router.navigate(['/brand'], { queryParams: { DizMarchio: idMarchio } });
    this.showDropdown = false;
  }

  ricercaPerCategoria(idCategoria: Number){
    this.gestioneArticoliService.getArticoliByCategoria(idCategoria).subscribe(
      (data) => {
        this.articoliByCategoria = data;
      },
      (error) => {
        console.error('Errore durante il recupero del filtro: Categoria', error);
      }
    );
  }

  ricercaPerMarca(idMarca: Number){
    this.gestioneArticoliService.getArticoliByMarca(idMarca).subscribe(
      (data) => {
        this.articoliByMarca = data;
      },
      (error) => {
        console.error('Errore durante il recupero del filtro: Categoria', error);
      }
    );
  }
}
