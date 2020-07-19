import {Talhao} from '../talhao/talhao.model';

export class Producao {
  public id: string;
  public ano: number;
  public vagensPorPlanta: number;
  public graosPorVagen: number;
  public gramasACadaCem: number;
  public talhao: Talhao;

  constructor() {
  }
}
