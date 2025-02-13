import { Articolo } from "./articolo";
import { DizMarchio } from "./diz/diz-marchio";
import { Utente } from "./utente";

export class Acquisto {
  idAcquisto!: number;
  utente!: Utente;
  articolo!: Articolo;
  marchio!: DizMarchio;
}
