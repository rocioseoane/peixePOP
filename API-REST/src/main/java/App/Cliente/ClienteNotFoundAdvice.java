package App.Cliente;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ClienteNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ClienteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String clienteNotFoundHandler(ClienteNotFoundException ex) {
        return ex.getMessage();
    }
}