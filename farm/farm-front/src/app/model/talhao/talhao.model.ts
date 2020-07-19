import {Fazenda} from '../fazenda/fazenda.model';

export class Talhao {
  public id: string;
  public codigo: string;
  public area: number;
  public plantaPorMetro: number;
  public espacamentoPorPlanta: number;
  public fazenda: Fazenda;
}
