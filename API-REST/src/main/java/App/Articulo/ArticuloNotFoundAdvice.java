package App.Articulo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ArticuloNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ArticuloNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String articuloNotFoundHandler(ArticuloNotFoundException ex) {
        return ex.getMessage();
    }
}