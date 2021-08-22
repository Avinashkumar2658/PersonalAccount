import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { APP_URL } from 'src/app.constants';
import { map } from 'rxjs/operators';

export const ACCOUNT_AUTHENTICATED_USER = 'account_authenticatedUser';
export const ACCOUNT_TOKEN = 'account_user_token';
export const ACCOUNT_PAGE_ID = 'account_user_pageId';
export const ACCOUNT_USER_ID = 'account_user_userId';

export class AuthenticationBean {
  constructor(public userId: number) { }
}

@Injectable({
  providedIn: 'root'
})

export class BasicAuthService {

  constructor(private http: HttpClient) { }

  executeAuthencationService(username, password) {
    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ":" + password);
    let headers = new HttpHeaders(
      {
        Authorization: basicAuthHeaderString
      }
    );
    return this.http.get<AuthenticationBean>(`${APP_URL}/user/basicauth`, { headers }).pipe(
      map(
        data => {
          localStorage.setItem(ACCOUNT_USER_ID, "" + data.userId);
          localStorage.setItem(ACCOUNT_AUTHENTICATED_USER, username);
          localStorage.setItem(ACCOUNT_TOKEN, basicAuthHeaderString);
          return data;
        }
      )
    );
  }

  getAccountAuthenticatedUserId(): number {
    return parseInt(localStorage.getItem(ACCOUNT_USER_ID));
  }

  getAccountAuthenticatedUser() {
    return localStorage.getItem(ACCOUNT_AUTHENTICATED_USER);
  }

  getAccountAuthenticatedToken() {
     return localStorage.getItem(ACCOUNT_TOKEN);
  }

  isAccountUserLoggedIn() {
    let user = localStorage.getItem(ACCOUNT_AUTHENTICATED_USER);
    return !(user == null);
  }

  logout() {
    localStorage.removeItem(ACCOUNT_AUTHENTICATED_USER);
    localStorage.removeItem(ACCOUNT_TOKEN);
    localStorage.removeItem(ACCOUNT_PAGE_ID);
    localStorage.removeItem(ACCOUNT_USER_ID);
  }

  AccountPageId(): string {
    var pageId = localStorage.getItem(ACCOUNT_PAGE_ID);
    if (pageId === null) {
      localStorage.setItem(ACCOUNT_PAGE_ID, 'login');
    }
    return pageId;
  }

  setAccountPageId(pageId: string) {
    localStorage.setItem(ACCOUNT_PAGE_ID, pageId);
  }

}
