import { DizCategoria } from "./diz/diz-categoria";
import { DizColore } from "./diz/diz-colore";
import { DizGenere } from "./diz/diz-genere";
import { DizMarchio } from "./diz/diz-marchio";

export class Articolo {
  idArticolo!: number;
  nome!: string;
  foto!: string;
  prezzo!: number;
  quantitaDisponibile!: number;
  descrizione!: string;
  marchio!: DizMarchio;
  genere!: DizGenere;
  coloreMontatura!: DizColore;
  coloreLente!: DizColore;
  categoria!: DizCategoria;
}
