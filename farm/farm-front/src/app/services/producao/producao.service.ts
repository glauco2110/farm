import { Injectable } from '@angular/core';
import {BaseService} from '../base.service';
import {HttpClient} from '@angular/common/http';
import {API_PATH} from '../../app.const';

@Injectable()
export class ProducaoService extends BaseService {

  constructor(http: HttpClient) {
    super(http, '/api/producao');
  }

  findByTalhaoId(page: number, count: number, talhaoId: string) {
    return this.http.get(`${API_PATH}/${this.path}/${page}/${count}/${talhaoId}`);
  }

}
