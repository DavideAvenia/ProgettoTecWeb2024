import { Articolo } from "./articolo";
import { DizStatoCarrello } from "./diz/diz-stato-carrello";

export class Carrello {

  idCarrello! : number;
  articoli! : Articolo[];
  statoCarrello! : DizStatoCarrello;

}
