import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HeaderComponent} from './components/geral/header/header.component';
import {MenuComponent} from './components/geral/menu/menu.component';
import {FooterComponent} from './components/geral/footer/footer.component';
import {HomeComponent} from './components/geral/home/home.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {routes} from './app.routes';
import {FazendaManterComponent} from './components/application/fazenda/fazenda-manter/fazenda-manter.component';
import {FazendaListarComponent} from './components/application/fazenda/fazenda-listar/fazenda-listar.component';
import {FazendaService} from './services/fazenda/fazenda.service';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {httpInterceptorProviders} from './interceptors';
import {TalhaoManterComponent} from './components/application/talhao/talhao-manter/talhao-manter.component';
import {TalhaoService} from './services/talhao/talhao.service';
import {ProducaoService} from './services/producao/producao.service';
import { ProducaoManterComponent } from './components/application/producao/producao-manter/producao-manter.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuComponent,
    FooterComponent,
    HomeComponent,
    FazendaManterComponent,
    FazendaListarComponent,
    TalhaoManterComponent,
    ProducaoManterComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    routes
  ],
  providers: [
    FazendaService,
    TalhaoService,
    ProducaoService,
    httpInterceptorProviders,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
