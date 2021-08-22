import { Component, OnInit } from '@angular/core';
import { Comment, DiaryService } from 'src/app/service/data/diary.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-diary',
  templateUrl: './diary.component.html',
  styleUrls: ['./diary.component.css']
})
export class DiaryComponent implements OnInit {
  user_notes : any[] = [];
  user_comments : any[] = [];
  userComment : Comment;
  spinner_status = 0;
  constructor(private diaryService : DiaryService, private basicAuthService : BasicAuthService) { 
    this.userComment = new Comment('', 0);
  }

  ngOnInit(): void {
    this.getAllNotes();
  }

  getAllNotes() {
    this.diaryService.executeFindAllUser_Notes(this.basicAuthService.getAccountAuthenticatedUserId()).subscribe(
      (res) => {
          this.user_notes = res;
          if(this.user_notes.length === 0)
            this.spinner_status = 2;
      }
    )
  }
  showComment(diaryId) {
    this.diaryService.executeFindAllUser_CommentsBYnotes_id(diaryId).subscribe(
      (res) => {
          this.user_comments = res;
      }
    )
  }
  saveComment(id, userCommentOnPage) {
    this.spinner_status = 1;
    this.userComment.diary_id = id;
    this.diaryService.executeSaveUserComment(this.userComment).subscribe(
      () => {
        this.showComment(id);
        userCommentOnPage.reset();
        this.spinner_status = 0;
      }
    )
  }
  deleteNote(diary_id) {
    this.diaryService.executeDeleteNote(diary_id).subscribe(
      () =>  {
        this.getAllNotes();
      }
    )
  }

}
