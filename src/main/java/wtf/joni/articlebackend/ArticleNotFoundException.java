package wtf.joni.articlebackend;

public class ArticleNotFoundException extends IllegalArgumentException {
    private long articleId;

    public ArticleNotFoundException(long id) {
        articleId = id;
    }

    public long getArticleId() {
        return articleId;
    }
}
