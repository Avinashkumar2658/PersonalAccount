import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';
import { User } from 'src/app/components/user-registration/user-registration.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient
  ) { }

  executeSaveUser(user) {
    return this.http.post(`${APP_URL}/createUser/`,user);
  }

  executeupdateProfilePhoto(userId, profilePhoto : File) {
    const formData = new FormData();
    formData.append('profilePhoto', profilePhoto);
    return this.http.put(`${APP_URL}/update_profile_photo/${userId}`,formData);
  }

  executeFindProfilePhoto(userId) {
    return this.http.get<any>(`${APP_URL}/profile_photo/${userId}`)
  }

  executeUpdatePassword(userId, resetPassword) {
    return this.http.put(`${APP_URL}/reset-password/${userId}`,resetPassword);
  }
  executeFindUsercredential(userId, pattern_url) {
    return this.http.get<number>(`${APP_URL}/user_credential/${userId}/${pattern_url}`)
  }
  executeForgotPassword(emailId: any) {
    return this.http.post<any>(`${APP_URL}/forgot-password`, emailId);
  }
  executeFindUserByuserId(userId) {
    return this.http.get<any>(`${APP_URL}/user/${userId}`)
  }
  executeUpdateUser(user) {
    return this.http.put(`${APP_URL}/user_update`, user);
  }
}
