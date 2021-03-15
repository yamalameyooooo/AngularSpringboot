import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import {FormGroup} from '@angular/forms'
import { ReturnBean } from '../returnBean';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-excelconversion',
  templateUrl: './excelconversion.component.html',
  styleUrls: ['./excelconversion.component.css']
})
export class ExcelconversionComponent implements OnInit {
  serverData: String;
  file : File;
  enableUpload: boolean = false;
  time: Date;
  responseMessage:String
  @ViewChild('myInput')
  myInputVariable: ElementRef;
  returnBean: ReturnBean;

  constructor(private httpClient: HttpClient,private toastr: ToastrService) {
  }

  ngOnInit() {
  }


  apiCall(fileObj: File){
    let formData = new FormData();
    formData.append('file',fileObj);
    return this.httpClient.post('excel/upload',formData);
  }

  upload(event : EventTarget){
    this.responseMessage = "";
    this.time = new Date();
    let eventObj: MSInputMethodContext = <MSInputMethodContext>event;
    let target: HTMLInputElement = <HTMLInputElement>eventObj.target;
    let files: FileList = target.files;
    if(files.length==1){
      this.file = target.files.item(0);
    }
    this.enableUpload = true;
  }

  uploadNow(){
    this.apiCall(this.file).subscribe(
      data =>{
        this.returnBean = data;
        this.responseMessage = this.returnBean.message;
        if(this.returnBean.status=="Failure"){
          this.toastr.error(this.returnBean.message,this.returnBean.status);
        }
        else{
          this.toastr.success(this.returnBean.message,this.returnBean.status);
        }
        this.enableUpload = false;
        this.myInputVariable.nativeElement.value = "";
      },
      error => {
        this.responseMessage = this.returnBean.message;
        this.toastr.error(this.returnBean.message,this.returnBean.status);
        this.enableUpload = false;
      }
    );
  }

}
