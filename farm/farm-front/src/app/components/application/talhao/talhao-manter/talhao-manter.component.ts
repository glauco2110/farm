import {Component, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {Talhao} from '../../../../model/talhao/talhao.model';
import {NgForm} from '@angular/forms';
import {TalhaoService} from '../../../../services/talhao/talhao.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Fazenda} from '../../../../model/fazenda/fazenda.model';
import {FazendaService} from '../../../../services/fazenda/fazenda.service';

@Component({
  selector: 'app-talhao-manter',
  templateUrl: './talhao-manter.component.html',
  styleUrls: ['./talhao-manter.component.css']
})
export class TalhaoManterComponent implements OnInit {

  @ViewChild('form')
  form: NgForm;

  talhao = new Talhao();
  permitirProducao = false;

  constructor(private talhaoService: TalhaoService,
              private fazendaService: FazendaService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    const id: string = this.route.snapshot.params['id'];
    const idFazenda: string = this.route.snapshot.params['idFazenda'];
    if (id !== void 0) {
      this.permitirProducao = true;
      this.findById(id);
    } else {
      this.setFazenda(idFazenda);
    }
  }

  private setFazenda(idFazenda: string) {
    this.fazendaService.findById(idFazenda).subscribe(response => {
      this.talhao.fazenda = new Fazenda(response['data']['id'], response['data']['id']);
    });
  }

  private findById(id: string) {
    this.talhaoService.findById(id).subscribe(response => {
      const data = response['data'];
      this.talhao = new Talhao();
      this.talhao.id = data.id;
      this.talhao.codigo = data.codigo;
      this.talhao.area = data.area;
      this.talhao.plantaPorMetro = data.plantaPorMetro;
      this.talhao.espacamentoPorPlanta = data.espacamentoPorPlanta;
      this.talhao.fazenda = new Fazenda(data.fazenda.id, data.fazenda.nome);
    });
  }

  save() {
    if (this.talhao.id === '') {
      this.talhaoService.incluir(this.talhao).subscribe(response => {
        this.router.navigate(['/talhao-alterar', response['data']['id']]);
      });
    } else {
      this.talhaoService.alterar(this.talhao).subscribe(response => {
        this.router.navigate(['/fazenda-alterar', response['data']['fazenda']['id']]);
      });
    }
  }


}
