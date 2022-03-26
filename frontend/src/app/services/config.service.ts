import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Config} from "../models/config";
import {BACKEND_CONFIG_URL} from "../constants/constant";
import {Observable} from "rxjs";

//The @Injectable() decorator specifies that Angular can use this class in the DI system.
@Injectable({
  //The metadata, providedIn: 'root', means that the ConfigService is visible throughout the application.
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) { }

  getConfig(): Observable<Config> {
    return this.http.get<Config>(BACKEND_CONFIG_URL)
  }

  // So this config service ables us to read all the data from the backend.

}
