package App.LineaPedido;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class LineaPedidoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(LineaPedidoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String lineaPedidoNotFoundHandler(LineaPedidoNotFoundException ex) {
        return ex.getMessage();
    }
}