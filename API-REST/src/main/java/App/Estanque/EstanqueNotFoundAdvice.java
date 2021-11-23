package App.Estanque;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class EstanqueNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EstanqueNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String estanqueNotFoundHandler(EstanqueNotFoundException ex) {
        return ex.getMessage();
    }
}