package App.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class PedidoController {

    @Autowired
    private final PedidoRepository repository;

    PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pedidos")
    public List<Pedido> findAll(){
        return repository.findAll();
    }

    @GetMapping("/pedidos/{codigo}")
    Pedido one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new PedidoNotFoundException(codigo));
    }
}