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
  pages: Array<number>;
  list = [];

  constructor(private fazendaService: FazendaService) { }

  ngOnInit() {
    this.findAll(this.page, this.count);
  }

  findAll(page: number, count: number) {
    this.fazendaService.findAll(page, count).subscribe((response) => {
      this.list = response['data']['content'];
      this.pages = new Array(response['data']['totalPages']);
    });
  }

  delete(id: string) {
    this.fazendaService.excluir(id).subscribe(() => {
      this.findAll(this.page, this.count);
    });
  }

  setNextPage(event:any){
    event.preventDefault();
    if(this.page+1 < this.pages.length){
      this.page =  this.page +1;
      this.findAll(this.page,this.count);
    }
  }

  setPreviousPage(event:any){
    event.preventDefault();
    if(this.page > 0){
      this.page =  this.page - 1;
      this.findAll(this.page, this.count);
    }
  }

  setPage(i,event:any){
    event.preventDefault();
    this.page = i;
    this.findAll(this.page, this.count);
  }

}
