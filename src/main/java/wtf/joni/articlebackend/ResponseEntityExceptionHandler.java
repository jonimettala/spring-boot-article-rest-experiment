package wtf.joni.articlebackend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleConflict(ArticleNotFoundException ex) {
        ErrorInfo e = new ErrorInfo("Customer not found with id " + ex.getArticleId());
        return new ResponseEntity<ErrorInfo>(e, HttpStatus.NOT_FOUND);
    }
}
