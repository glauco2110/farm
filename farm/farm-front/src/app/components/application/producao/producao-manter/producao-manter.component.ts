import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Producao} from '../../../../model/producao/producao.model';
import {ProducaoService} from '../../../../services/producao/producao.service';
import {NgForm} from '@angular/forms';
import {Talhao} from '../../../../model/talhao/talhao.model';

@Component({
  selector: 'app-producao-manter',
  templateUrl: './producao-manter.component.html',
  styleUrls: ['./producao-manter.component.css'],

})
export class ProducaoManterComponent implements OnInit {

  @Input() idTalhao: string;

  @ViewChild('form')
  form: NgForm;

  producao = new Producao();

  page = 0;
  count = 5;
  list = [];
  anos = [];

  constructor(private producaoService: ProducaoService) { }

  ngOnInit() {
    this.findByTalhaoId();
    for (let i = 1990; i <= 2020; i++) {
      this.anos.push(i);
    }
  }

  incluirProducao() {
    this.producao.talhao = new Talhao();
    this.producao.talhao.id = this.idTalhao;
    this.producaoService.incluir(this.producao).subscribe(() => {
      this.findByTalhaoId();
    });
  }

  findByTalhaoId() {
    this.producaoService.findByTalhaoId(this.page, this.count, this.idTalhao).subscribe((response => {
      this.producao = new Producao();
      this.list = response['data']['content'];
    }));
  }

  excluir(id) {
    this.producaoService.excluir(id).subscribe(() => {
      this.findByTalhaoId();
    });
  }

}
