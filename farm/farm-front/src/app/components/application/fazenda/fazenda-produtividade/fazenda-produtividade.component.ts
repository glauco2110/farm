import { Component, OnInit } from '@angular/core';
import {FazendaService} from '../../../../services/fazenda/fazenda.service';
import {TalhaoService} from '../../../../services/talhao/talhao.service';
import {ActivatedRoute} from '@angular/router';
import {Fazenda} from '../../../../model/fazenda/fazenda.model';
import {ProdutividadeService} from '../../../../services/produtividade/produtividade.service';
import {ProducaoFazendaDto} from '../../../../dto/producao.fazenda.dto';

@Component({
  selector: 'app-fazenda-produtividade',
  templateUrl: './fazenda-produtividade.component.html',
  styleUrls: ['./fazenda-produtividade.component.css']
})
export class FazendaProdutividadeComponent implements OnInit {

  fazenda = new Fazenda(null, '');
  anoReferencia: number;
  produtividade: ProducaoFazendaDto;
  anos = [];

  constructor(private fazendaService: FazendaService,
              private talhaoService: TalhaoService,
              private route: ActivatedRoute,
              private produtividadeService: ProdutividadeService) { }

  ngOnInit() {
    const id: string = this.route.snapshot.params['id'];
    if (id !== void 0) {
      this.findById(id);
    }

    for (let i = 2010; i <= 2020; i++) {
      this.anos.push(i);
    }

  }

  private findById(id: string) {
    this.fazendaService.findById(id).subscribe(response => {
      this.fazenda = new Fazenda(response['data']['id'], response['data']['nome']);
    });
  }

  findByIdAno() {
    this.produtividadeService.findByIdAno(this.fazenda.id, this.anoReferencia).subscribe((response) => {
          this.produtividade = response['data'];
    });
  }

}
