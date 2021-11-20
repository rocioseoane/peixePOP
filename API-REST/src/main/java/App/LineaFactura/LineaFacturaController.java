package App.LineaFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class LineaFacturaController {

    @Autowired
    private final LineaFacturaRepository repository;

    LineaFacturaController(LineaFacturaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/lineas_facturas")
    public List<LineaFactura> findAll() {
        return repository.findAll();
    }

    @GetMapping("/lineas_facturas/{codigo}")
    LineaFactura one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new LineaFacturaNotFoundException(codigo));
    }
}