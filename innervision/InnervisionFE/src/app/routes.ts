import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { DetailsComponent } from './details/details.component';
import { ServiceComponent } from './service/service.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BrandComponent } from './brand/brand.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { CarrelloComponent } from './carrello/carrello.component';
import { CategoriesComponent } from './categories/categories.component';

const routeConfig: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'Home page'
  },
  {
    path: 'details/:id',
    component: DetailsComponent,
    title: 'Dettagli articolo'
  },
  {
    path: 'brand/:id',
    component: BrandComponent,
    title: 'Ricerca per Marchi'
  },
  {
    path: 'categories/:id',
    component: CategoriesComponent,
    title: 'Ricerca per Categorie'
  },
  {
    path: 'services',
    component: ServiceComponent,
    title: 'Servizi disponibili'
  },
  {
    path: 'register',
    component: RegisterComponent,
    title: 'Registrazione'
  },
  {
    path: 'login',
    component: LoginComponent,
    title: 'Login'
  },
  {
    path: 'showCart',
    component: CarrelloComponent,
    title: 'Carrello'
  },
  {
    path: 'welcome',
    component: WelcomeComponent,
    title: 'Welcome'
  }
];

@NgModule({
  imports: [
      RouterModule.forRoot(routeConfig),
    ],
  exports: [
    RouterModule
  ]
})

export class AppModule {}

export default routeConfig;
