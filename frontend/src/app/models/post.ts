// interface can have the same name as in the backend (entity -> Post)
export interface Post {
  id: number,
  header: string,
  content: string,
  author: string,
  creationTimeStamp: string,
  updateTimeStamp: string // in case we need to update/edit post
}
