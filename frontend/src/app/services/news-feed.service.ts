import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable, tap } from 'rxjs';
import { Post } from '../models/post';
import { BACKEND_NEWS_FEED } from '../constants/constant';

@Injectable({
  providedIn: 'root'
})
export class NewsFeedService {

  constructor(private http: HttpClient) { }

  // Observable objects are lazy
  getRecentPosts(): Observable<Array<Post>> {
    return this.http.get<any>(BACKEND_NEWS_FEED)
      .pipe(
        tap(value => console.log('data before processing: ' + JSON.stringify(value))),
        map((value: Array<any>) =>
          value.map(item =>
            <Post> {
              id: item.id,
              header: item.header,
              content: item.content,
              author: item.author,
              creationTimeStamp: item.creation_timestamp,
              updateTimeStamp: item.update_timestamp
            })),
        tap(value => console.log('data after processing: ' + JSON.stringify(value)))
      )
  }
}
