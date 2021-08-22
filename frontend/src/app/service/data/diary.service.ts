import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

export class Comment {
  constructor(
    public user_comment : String,
    public  diary_id : number)
     {}
    public getUser_comment() : String {
      return this.user_comment;
    }
    
    public getDiary_id() : number {
      return this.diary_id;
    }
}

export class Diary {
  constructor(
    public notes_heading : String,
    public notes_detail : String,
    public  userId : number) {}
    public getNotes_heading() : String {
      return this.notes_heading;
    }
    public getNotes_detail() : String {
      return this.notes_detail;
    }
    public getUserId() : number {
      return this.userId;
    }
}

@Injectable({
  providedIn: 'root'
})
export class DiaryService {

  constructor(private http : HttpClient) { }

  executeFindAllUser_Notes(userId) {
    return this.http.get<any[]>(`${APP_URL}/diary_update/${userId}`);
  }

  executeDeleteNote(diaryId: any) {
    return this.http.delete<String>(`${APP_URL}/delete_notes/${diaryId}`);
 }

  executeFindAllUser_CommentsBYnotes_id(diaryId) {
    return this.http.get<any[]>(`${APP_URL}/comment_update/${diaryId}`);
  }
  executeSaveUserComment(comment) {
    return this.http.post(`${APP_URL}/save_comment/`,comment);
  }
  

  executeSaveNotes(diary) {
    return this.http.post(`${APP_URL}/save_diary/`,diary);
  }
}
