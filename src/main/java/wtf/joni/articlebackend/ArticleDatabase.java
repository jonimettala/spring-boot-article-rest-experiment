package wtf.joni.articlebackend;

import org.springframework.data.repository.CrudRepository;

public interface ArticleDatabase extends CrudRepository<Article, Long> {
    public Article findArticleById(Long id);
}
