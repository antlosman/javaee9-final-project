export interface Post {
  header: string,
  content: string,
  author: string,
  creationTimeStamp: Date,
  updateTimeStamp: Date // in case we need to update/edit post
}
