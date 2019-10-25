import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = ""
  currNavBarItemIndex = -1
  navBarItems = [ new NavBarItem("Home", "home"),
                  new NavBarItem("Catalog", "catalog"),
                  new NavBarItem("About", "about")]

  componentAdded(component) {
    this.title = component.title;
    if (component.navBarItemIndex === undefined) {
      this.currNavBarItemIndex = -1;
    }
    else {
      this.currNavBarItemIndex = component.navBarItemIndex;
    }
  }
}

class NavBarItem {
  title: string
  route: string
  constructor(title: string, route: string) {
    this.title = title;
    this.route = route;
  }
}
