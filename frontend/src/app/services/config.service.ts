import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Config} from "../models/config";
import {BACKEND_CONFIG_URL} from "../constants/constant";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) { }

  getConfig(): Observable<Config> {
    return this.http.get<Config>(BACKEND_CONFIG_URL)
  }

}
