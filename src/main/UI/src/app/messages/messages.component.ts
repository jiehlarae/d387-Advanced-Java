import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  messages : string[] = [];
  timeZone : String[] = [];

@Input() showMessage : boolean = true;
@Input() showTimeZone: any; boolean = true;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<string[]>('http://localhost:8080/message')
      .subscribe((data) => {
        this.messages = data;
      })
    this.http.get<string[]>('http://localhost:8080/presentation')
      .subscribe((data) => {
        this.timeZone = data;
      })
  }
}
