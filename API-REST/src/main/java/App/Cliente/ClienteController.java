package App.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
class ClienteController {

    //Inyectamos el repositorio para poder hacer uso de el
    @Autowired
    private final ClienteRepository repository;

    ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public @ResponseBody
    String greeting() {
        return "API Running - PeixePOP";
    }

    @GetMapping("/clientes")
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @GetMapping("/clientes/{codigo}")
    Cliente one(@PathVariable String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new ClienteNotFoundException(codigo));
    }
}