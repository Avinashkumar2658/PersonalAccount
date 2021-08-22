import { Component, OnInit } from '@angular/core';
import { Diary, DiaryService } from 'src/app/service/data/diary.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-create-page',
  templateUrl: './create-page.component.html',
  styleUrls: ['./create-page.component.css']
})
export class CreatePageComponent implements OnInit {

  diary : Diary
  message : String;
  spinner_status = 0;
  constructor(private diaryService : DiaryService, private basicAuthService : BasicAuthService) {
    this.diary = new Diary('', '', this.basicAuthService.getAccountAuthenticatedUserId());
   }
  saveDiary(createPage) {
    this.message;
    this.spinner_status = 1;
    this.diaryService.executeSaveNotes(this.diary).subscribe(
      ()=>  {
        this.message = "notes saved successfully";
        createPage.reset();
        this.spinner_status = 0;
      }
    )
  }
  ngOnInit(): void {
  }

}
