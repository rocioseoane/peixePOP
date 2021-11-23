package App.Trabajador;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TrabajadorNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TrabajadorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String trabajadorNotFoundHandler(TrabajadorNotFoundException ex) {
        return ex.getMessage();
    }
}