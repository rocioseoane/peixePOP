package App.Factura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class FacturaController {

    @Autowired
    private final FacturaRepository repository;

    FacturaController(FacturaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/facturas")
    public List<Factura> findAll() {
        return repository.findAll();
    }

    @GetMapping("/facturas/{codigo}")
    Factura one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new FacturaNotFoundException(codigo));
    }
}