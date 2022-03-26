import { Component, OnInit } from '@angular/core';
import {ConfigService} from "../../services/config.service";

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  applicationName: string = "";

  // by adding configService to the constructor we are making dependency infection, so we are injecting config service
  // in to welcome component(controller)
  constructor(private configService: ConfigService) { }

  ngOnInit(): void {
    this.configService.getConfig().subscribe(value => this.applicationName = value.applicationName);
  }
  // when the component is created, it's going to create service (which is inside the Angular application), that's means
  // that Angular application run into browser, that application is going to connect to Spring backend, read that
  // application name and put that application name to applicationName field inside this component

}
