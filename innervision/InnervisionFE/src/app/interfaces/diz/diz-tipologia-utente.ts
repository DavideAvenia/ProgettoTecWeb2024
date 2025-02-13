export class DizTipologiaUtente {

  idTipologiaUtente!: number;
  descTipologiaUtente!: string;
  attivo!: string;

  constructor(idTipologiaUtente: number, descTipologiaUtente: string, attivo: string){
    this.idTipologiaUtente = idTipologiaUtente;
    this.descTipologiaUtente = descTipologiaUtente;
    this.attivo = attivo;
  }

}
