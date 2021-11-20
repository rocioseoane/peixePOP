package App.Trabajador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class TrabajadorController {

    @Autowired
    private final TrabajadorRepository repository;

    TrabajadorController(TrabajadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/trabajadores")
    public List<Trabajador> findAll() {
        return repository.findAll();
    }

    @GetMapping("/trabajadores/{codigo}")
    Trabajador one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new TrabajadorNotFoundException(codigo));
    }
}