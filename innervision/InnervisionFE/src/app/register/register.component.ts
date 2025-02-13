import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { GestioneUtenteService } from '../services/gestione-utente.service';
import { CommonModule } from '@angular/common';
import { Utente } from '../interfaces/utente';
import { Router, RouterModule } from '@angular/router';
import { Carrello } from '../interfaces/carrello';
import { Acquisto } from '../interfaces/acquisto';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})

export class RegisterComponent {

  applyForm = new FormGroup({
    nome: new FormControl(''),
    cognome: new FormControl(''),
    username: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    checkPassword: new FormControl('')
  });

  constructor(private gestioneUtenteService: GestioneUtenteService,
    private router: Router
  ){}

  submitRegistration() {

    if(this.applyForm.value.password!= this.applyForm.value.checkPassword){
      alert("Le password non coincidono");
    }else{
      let utente = new Utente(
        this.applyForm.value.nome? this.applyForm.value.nome : '',
        this.applyForm.value.cognome? this.applyForm.value.cognome : '',
        this.applyForm.value.username? this.applyForm.value.username : '',
        this.applyForm.value.username? this.applyForm.value.username : '',
        this.applyForm.value.password? this.applyForm.value.password : '',
        new Carrello(),
        []
      );

      this.gestioneUtenteService.register(utente).subscribe(
        (response: any) => {
          console.log('Registrazione avvenuta con successo!', response);
          this.router.navigate(['/welcome']);
        },
        error => {
          console.error('Errore durante la registrazione', error);
        }
      );
    }
  }

}
