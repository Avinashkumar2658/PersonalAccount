import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/data/user.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
declare var $: any;
//import { AccountService } from './_services';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  progressInfos: [];
  selectedFiles: FileList;
  profilePhoto: string;
  i = 1;
  @ViewChild("imageName") imageName: ElementRef;
  selectFiles(event): void {
    this.progressInfos = [];
    this.selectedFiles = event.target.files;
  }

  constructor(private basicAuthService : BasicAuthService, private router : Router, private userService : UserService) {

   }

  ngOnInit(): void { 
  $(document).ready(function(){
    // Prepare the preview for profile picture
        $("#selectedFiles").change(function(this: typeof readURL ){
            readURL(this);
        });
    });
    function readURL(input : any) {
      if (input.files && input.files[0]) {
          var reader = new FileReader();
    
          reader.onload = function (e): void {
              $('#wizardPicturePreview').attr('src', e.target!.result).fadeIn('slow');
          }
          reader.readAsDataURL(input.files[0]);
      }
    }
    $('a').on('click', function(){
      $('a').removeClass('selected');
      $(this).addClass('selected');
  });
 this.executeFindProfilePhoto();
  }

  executeSaveProfilePhoto() {
    this.userService.executeupdateProfilePhoto(this.basicAuthService.getAccountAuthenticatedUserId(), this.selectedFiles[0]).subscribe(
      () => {

      }
    )
  }

  onChange(event) {
    var fileName = this.imageName.nativeElement.value
    var idxDot = fileName.lastIndexOf(".") + 1;
    var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
    if (!(extFile=="jpg" || extFile=="jpeg" || extFile=="png"))
        alert("Only jpg/jpeg and png files are allowed!");
    this.selectedFiles = event.srcElement.files
    this.executeSaveProfilePhoto();

}

executeFindProfilePhoto() {
  this.userService.executeFindProfilePhoto(this.basicAuthService.getAccountAuthenticatedUserId()).subscribe(
    (res)=> {
      this.profilePhoto = 'data:image/jpeg;base64,' + res;
    }
  )
}






dataURItoBlob(dataURI) {

  var byteString;
  if (dataURI.split(',')[0].indexOf('base64') >= 0)
      byteString = atob(dataURI.split(',')[1]);
  else
      byteString = unescape(dataURI.split(',')[1]);
  var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

  var ia = new Uint8Array(byteString.length);
  for (var i = 0; i < byteString.length; i++) {
      ia[i] = byteString.charCodeAt(i);
  }

  return new Blob([ia], {type:mimeString});
}

  logout() {
    this.basicAuthService.logout();
    window.history.pushState({}, document.title, "/" + "#");
}
}
