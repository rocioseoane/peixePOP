package App.Articulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ArticuloController {

    @Autowired
    private final ArticuloRepository repository;

    ArticuloController(ArticuloRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/articulos")
    public List<Articulo> findAll() {
        return repository.findAll();
    }

    @GetMapping("/articulos/{codigo}")
    Articulo one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new ArticuloNotFoundException(codigo));
    }
}