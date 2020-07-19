import {Component, OnInit} from '@angular/core';
import {FazendaService} from '../../../../services/fazenda/fazenda.service';

@Component({
  selector: 'app-fazenda-listar',
  templateUrl: './fazenda-listar.component.html',
  styleUrls: ['./fazenda-listar.component.css']
})
export class FazendaListarComponent implements OnInit {

  page = 0;
  count = 5;
  list = [];

  constructor(private fazendaService: FazendaService) { }

  ngOnInit() {
    this.findAll(this.page, this.count);
  }

  findAll(page: number, count: number) {
    this.fazendaService.findAll(page, count).subscribe((response) => {
      this.list = response['data']['content'];
    });
  }

  delete(id: string) {
    this.fazendaService.excluir(id).subscribe(() => {
      this.findAll(this.page, this.count);
    });
  }

}
