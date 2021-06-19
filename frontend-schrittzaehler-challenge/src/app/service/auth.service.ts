import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/model/User';
import { map } from 'rxjs/operators';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<User>;
  public myTestUser: any;
  public areCredentialsCorrect: any;

  constructor(private http: HttpClient) {
    let newUser: string = localStorage.getItem('currentUser')||'{}';
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(newUser));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }

  login(username: string, password : string) {
    return this.http.post<any>('http://localhost:8080/user/login', { username: username, password: password })
    .pipe(map(user => {
      let newUser: User = user;
      localStorage.setItem('currentUser', JSON.stringify(newUser));
      this.currentUserSubject.next(user);
      return user;
    }))
  }
}
