package App.Tiburon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class TiburonController {

    @Autowired
    private final TiburonRepository repository;

    TiburonController(TiburonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tiburones")
    public List<Tiburon> findAll(){
        return repository.findAll();
    }

    @GetMapping("/tiburones/{codigo}")
    Tiburon one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new TiburonNotFoundException(codigo));
    }
}