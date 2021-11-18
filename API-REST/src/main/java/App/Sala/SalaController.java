package App.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class SalaController {

    @Autowired
    private final SalaRepository repository;

    SalaController(SalaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/salas")
    public List<Sala> findAll(){
        return repository.findAll();
    }

    @GetMapping("/salas/{codigo}")
    Sala one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new SalaNotFoundException(codigo));
    }
}