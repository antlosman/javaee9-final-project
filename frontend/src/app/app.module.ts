import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { WelcomeComponent } from './components/welcome/welcome.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule // this import comes from config.service.ts
  ],
  providers: [],
  bootstrap: [WelcomeComponent]
})
export class AppModule { }
