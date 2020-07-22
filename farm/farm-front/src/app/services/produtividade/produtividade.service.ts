import { Injectable } from '@angular/core';
import {BaseService} from '../base.service';
import {HttpClient} from '@angular/common/http';
import {API_PATH} from '../../app.const';

@Injectable()
export class ProdutividadeService extends BaseService {

  constructor(http: HttpClient) {
    super(http, '/api/produtividade-consultar');
  }

  findByIdAno(id: string, ano: number) {
    return this.http.get(`${API_PATH}${this.path}/${id}/${ano}`);
  }

}
