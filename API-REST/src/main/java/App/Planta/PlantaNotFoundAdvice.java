package App.Planta;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PlantaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PlantaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String plantaNotFoundHandler(PlantaNotFoundException ex) {
        return ex.getMessage();
    }
}