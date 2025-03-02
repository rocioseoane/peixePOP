package App.LineaFactura;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class LineaFacturaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(LineaFacturaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String lineaFacturaNotFoundHandler(LineaFacturaNotFoundException ex) {
        return ex.getMessage();
    }
}