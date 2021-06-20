import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from './service/auth.service';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(public authService: AuthService, public router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const expectedRole = route.data.expectedRole;
    const userRole = this.authService.currentUserValue.userRole;

    if (
      !localStorage.getItem('currentUser') == null || 
      userRole !== expectedRole
    ) {
      alert('Your user doesn\'t have the permission for this tab!\nPlease log in with an admin user.');
      return false;
    }
    return true;
  }  
}
