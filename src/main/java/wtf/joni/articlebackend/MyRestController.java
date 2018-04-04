package wtf.joni.articlebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

@RestController
public class MyRestController {

    @Autowired
    ArticleDatabase db;

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public Iterable<Article> fetchArticles() {
        Iterable<Article> articles = db.findAll();
        articles.forEach(System.out::println);
        return articles;
    }

    @RequestMapping(value = "/articles/{articleId}", method = RequestMethod.GET)
    public Article findArticle(@PathVariable long articleId) {
        Article article = db.findArticleById(articleId);
        if (article != null) {
            return article;
        } else {
            throw new ArticleNotFoundException(articleId);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public ResponseEntity<?> saveCustomer(@RequestBody Article article, UriComponentsBuilder b) {
        article.setDate(new Date());
        db.save(article);
        UriComponents uriComponents =
                b.path("/articles/{id}").buildAndExpand(article.getId());

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @RequestMapping(value = "/articles/{articleId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable long articleId) {
        Article article = db.findArticleById(articleId);
        if (article != null) {
            db.deleteById(articleId);
        } else {
            throw new ArticleNotFoundException(articleId);
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void saveTestArticle() {
        db.save(new Article("Hello World", "Hodor jne moikkamoi", "dggr", new Date()));
    }
}
