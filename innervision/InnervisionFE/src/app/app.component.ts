import { Component, OnInit } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';

import { RouterModule } from '@angular/router';
import { HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    HomeComponent,
    RouterModule,
    NavbarComponent,
    HttpClientModule
  ],
  providers: [],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit{
  title = 'Innervision';

  ngOnInit() {
    this.resetLocalStorage();
  }

  resetLocalStorage() {
    localStorage.clear();
  }
}
