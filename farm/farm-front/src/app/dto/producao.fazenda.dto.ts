import {Fazenda} from '../model/fazenda/fazenda.model';
import {ProducaoTalhaoDto} from './producao.talhao.dto';

export class ProducaoFazendaDto {
  public fazenda: Fazenda;
  public ano: number;
  public valor: number;
  public producaoTalhaoDTOList: Array<ProducaoTalhaoDto>;
}
