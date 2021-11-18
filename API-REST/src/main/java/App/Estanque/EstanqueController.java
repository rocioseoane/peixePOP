package App.Estanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class EstanqueController {

    @Autowired
    private final EstanqueRepository repository;

    EstanqueController(EstanqueRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/estanques")
    public List<Estanque> findAll(){
        return repository.findAll();
    }

    @GetMapping("/estanques/{codigo}")
    Estanque one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new EstanqueNotFoundException(codigo));
    }
}