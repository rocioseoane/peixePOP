package App.Planta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class PlantaController {

    @Autowired
    private final PlantaRepository repository;

    PlantaController(PlantaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/plantas")
    public List<Planta> findAll() {
        return repository.findAll();
    }

    @GetMapping("/plantas/{codigo}")
    Planta one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new PlantaNotFoundException(codigo));
    }
}