import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title = "The frontline of E-Sports"
  navBarItemIndex = 0

  constructor() { }

  ngOnInit() {
  }

}
