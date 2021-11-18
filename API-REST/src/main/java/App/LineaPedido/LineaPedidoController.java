package App.LineaPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class LineaPedidoController {

    @Autowired
    private final LineaPedidoRepository repository;

    LineaPedidoController(LineaPedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/lineas_pedidos")
    public List<LineaPedido> findAll(){
        return repository.findAll();
    }

    @GetMapping("/lineas_pedidos/{codigo}")
    LineaPedido one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new LineaPedidoNotFoundException(codigo));
    }
}