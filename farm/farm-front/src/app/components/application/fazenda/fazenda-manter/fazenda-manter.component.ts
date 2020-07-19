import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {Fazenda} from '../../../../model/fazenda/fazenda.model';
import {FazendaService} from '../../../../services/fazenda/fazenda.service';
import {TalhaoService} from '../../../../services/talhao/talhao.service';

@Component({
  selector: 'app-fazenda-manter',
  templateUrl: './fazenda-manter.component.html',
  styleUrls: ['./fazenda-manter.component.css']
})
export class FazendaManterComponent implements OnInit {

  @ViewChild('form')
  form: NgForm;

  fazenda = new Fazenda(null, '');

  page = 0;
  count = 5;
  talhoes = [];

  constructor(private fazendaService: FazendaService,
              private talhaoService: TalhaoService,
              private route: ActivatedRoute,
              private router: Router) { }

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

  save() {
    if (this.fazenda.id === null) {
      this.fazendaService.incluir(this.fazenda).subscribe(response => {
        this.router.navigate(['/fazenda-alterar', response['data']['id']]);
      });
    } else {
      this.fazendaService.alterar(this.fazenda).subscribe(response => {
        this.router.navigate(['/fazenda']);
      });
    }
  }

  private populateTalhoes() {
    this.talhaoService.findByFazendaId(this.page, this.count, this.fazenda.id).subscribe(response => {
      this.talhoes = response['data']['content'];
    });
  }

}
