package App.Entrada;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntradaController {

    @Autowired
    private final EntradaRepository repository;

    EntradaController(EntradaRepository repository) { this.repository = repository; }

    @GetMapping("/entradas")
    List<Entrada> findAll() {
        return repository.findAll();
    }

    @GetMapping("/entradas/{codigo}")
    Entrada one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new EntradaNotFoundException(codigo));
    }
}
