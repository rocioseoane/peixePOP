package App.Evento;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EventoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EventoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String eventoNotFoundHandler(EventoNotFoundException ex) {
        return ex.getMessage();
    }
}
