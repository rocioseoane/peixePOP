package App;
;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * El controlador recibe la petición HTTP, acto seguido manda a llamar a un servicio (lógica del programa) la cual conecta a través del repository a la BBDD.
 *
 *  PETICIÓN HTTP -> CONTROLLER -> SERVICE -> REPOSITORY
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
