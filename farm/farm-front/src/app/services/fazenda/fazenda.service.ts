import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from '../base.service';

@Injectable()
export class FazendaService extends BaseService {

  constructor(http: HttpClient) {
    super(http, '/api/fazenda');
  }

}
