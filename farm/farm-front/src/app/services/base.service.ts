import {HttpClient} from '@angular/common/http';
import {API_PATH} from '../app.const';

export class BaseService {

  constructor(public http: HttpClient, public path: string) {
    this.http = http;
    this.path = path;
  }

  incluir(obj: Object) {
    return this.http.post(`${API_PATH}${this.path}`, obj);
  }

  alterar(obj: Object) {
    return this.http.put(`${API_PATH}/${this.path}`, obj);
  }

  excluir(id: string) {
    return this.http.delete(`${API_PATH}/${this.path}/${id}`);
  }

  findAll(page: number, count: number) {
      return this.http.get(`${API_PATH}/${this.path}/${page}/${count}`);
  }

  findById(id: string) {
    return this.http.get(`${API_PATH}/${this.path}/${id}`);
  }

}
