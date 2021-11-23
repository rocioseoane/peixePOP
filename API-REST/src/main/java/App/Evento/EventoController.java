package App.Evento;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventoController {

    @Autowired
    private final EventoRepository repository;

    EventoController(EventoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/eventos")
    List<Evento> findAll() {
        return repository.findAll();
    }

    @GetMapping("/eventos/{codigo}")
    Evento one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new EventoNotFoundException(codigo));
    }
}
