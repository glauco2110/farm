import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import {ToastrService} from 'ngx-toastr';

@Injectable()
export class NotifyInterceptor implements HttpInterceptor {

  constructor(private toastr: ToastrService) {

  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).do(
      (event: HttpEvent<any>) => {
        if (req.method !== 'GET' && event instanceof HttpResponse && event.status === 200) {
          this.toastr.success('Ação realizada com sucesso!');
        }
      },
      (err: any) => {
        if (req.headers.get('handleError') === 'onService') {
          console.log('Interceptor does nothing...');
        } else {
          this.toastr.error(err.error.errors);
        }
      }
    );
  }
}
