import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {HomeComponent} from './components/geral/home/home.component';
import {FazendaManterComponent} from './components/application/fazenda/fazenda-manter/fazenda-manter.component';
import {FazendaListarComponent} from './components/application/fazenda/fazenda-listar/fazenda-listar.component';
import {TalhaoManterComponent} from './components/application/talhao/talhao-manter/talhao-manter.component';
import {FazendaProdutividadeComponent} from './components/application/fazenda/fazenda-produtividade/fazenda-produtividade.component';

export const ROUTES: Routes = [
  { path: '', component: HomeComponent},

  // Fazenda
  { path: 'fazenda', component: FazendaListarComponent},
  { path: 'fazenda-incluir', component: FazendaManterComponent},
  { path: 'fazenda-alterar/:id', component: FazendaManterComponent},
  { path: 'fazenda-produtividade/:id', component: FazendaProdutividadeComponent},

  // Talhao
  { path: 'talhao-incluir/:idFazenda', component: TalhaoManterComponent},
  { path: 'talhao-alterar/:id', component: TalhaoManterComponent},
];

export const routes: ModuleWithProviders = RouterModule.forRoot(ROUTES);
