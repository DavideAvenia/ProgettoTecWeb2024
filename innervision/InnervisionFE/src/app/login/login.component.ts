import { CommonModule } from '@angular/common';
import { Component, Injectable } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { GestioneUtenteService } from '../services/gestione-utente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {

  constructor(private gestioneUtenteService: GestioneUtenteService,
    private router: Router
  ){}

  applyForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });

  submitLogin() {
    this.gestioneUtenteService.login(
      this.applyForm.value.username ?? '',
      this.applyForm.value.password ?? ''
    ).subscribe(
      (response: any) => {
        console.log('Login avvenuta con successo!', response);
        this.router.navigate(['/welcome']);
      },
      error => {
        console.error('Errore durante la login', error);
      }
    );
  }
}
