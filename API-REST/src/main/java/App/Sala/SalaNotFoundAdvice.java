package App.Sala;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class SalaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SalaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String salaNotFoundHandler(SalaNotFoundException ex) {
        return ex.getMessage();
    }
}