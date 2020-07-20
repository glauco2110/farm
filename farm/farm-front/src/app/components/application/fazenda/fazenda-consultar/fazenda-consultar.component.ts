import {Component, OnInit} from '@angular/core';
import {FazendaService} from '../../../../services/fazenda/fazenda.service';
import {Fazenda} from '../../../../model/fazenda/fazenda.model';
import {TalhaoService} from '../../../../services/talhao/talhao.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-fazenda-consultar',
  templateUrl: './fazenda-consultar.component.html',
  styleUrls: ['./fazenda-consultar.component.css']
})
export class FazendaConsultarComponent implements OnInit {

  fazenda = new Fazenda(null, '');
  talhoes = [];

  page = 0;
  count = 5;

  constructor(private fazendaService: FazendaService,
              private talhaoService: TalhaoService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    const id: string = this.route.snapshot.params['id'];
    if (id !== void 0) {
      this.findById(id);
    }
  }

  private findById(id: string) {
    this.fazendaService.findById(id).subscribe(response => {
      this.fazenda = new Fazenda(response['data']['id'], response['data']['nome']);
      this.populateTalhoes();
    });
  }

  private populateTalhoes() {
    this.talhaoService.findByFazendaId(this.page, this.count, this.fazenda.id).subscribe(response => {
      this.talhoes = response['data']['content'];
    });
  }

}
