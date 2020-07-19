import { Injectable } from '@angular/core';
import {BaseService} from '../base.service';
import {HttpClient} from '@angular/common/http';
import {API_PATH} from '../../app.const';

@Injectable()
export class TalhaoService extends BaseService {

  constructor(http: HttpClient) {
    super(http, '/api/talhao');
  }

  findByFazendaId(page: number, count: number, fazendaId: string) {
    return this.http.get(`${API_PATH}/${this.path}/${page}/${count}/${fazendaId}`);
  }
}
