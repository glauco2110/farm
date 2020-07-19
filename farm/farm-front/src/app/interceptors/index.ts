import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {NotifyInterceptor} from './notify.interptor';

export const httpInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: NotifyInterceptor, multi: true },
];
