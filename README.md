# spring-boot-article-restful-experiment
A simple RESTful experiment which uses memory-based H2 database.

Articles can be added to the system. An article has a title, content, an author, and a date.

### GET all articles

`curl -X GET http://localhost:8080/articles/`

### GET an article

`curl -X GET http://localhost:8080/articles/1`

### DELETE an article

`curl -X DELETE http://localhost:8080/articles/1`

### POST an article

`curl -X POST -H "Content-type: application/json" -d "{\"title\": \"My Confession\", \"content\": \"I absolutely love Game of Thrones.\", \"author\": \"Jon Forest\"}" http://localhost:8080/articles/`

Date is generated automatically and won't be given when POSTing.
