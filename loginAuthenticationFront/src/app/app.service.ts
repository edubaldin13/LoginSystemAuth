import { Injectable } from "@angular/core";
import {
  HttpHeaders,
  HttpClient,
  HttpEvent,
  HttpResponse,
} from "@angular/common/http";
import { Observable } from "rxjs";

const baseUrl = 'http://localhost:8081/users'

@Injectable({
    providedIn: "root",
})
export class AppService{
    constructor(private http: HttpClient){}

    getLogin():Observable<any>{
        return this.http.get( baseUrl )
    }

    register(infos:any):Observable<any>{
        return this.http.post( baseUrl, infos )
    }
}