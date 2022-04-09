import { Component, OnInit } from '@angular/core';
import { NewsFeedService } from '../../services/news-feed.service';
import { Post } from '../../models/post';

@Component({
  selector: 'app-news-feed',
  templateUrl: './news-feed.component.html',
  styleUrls: ['./news-feed.component.css']
})
export class NewsFeedComponent implements OnInit {

  news: Array<Post> = []

  constructor(private newsFeedService: NewsFeedService) {
  }

  ngOnInit(): void {
    this.newsFeedService
      .getRecentPosts()
      .subscribe(
        // inside subscribe method we're directly inside Observable,
        // so we've got access to Array<Post>
        value => this.news = value
        )
  }
}
