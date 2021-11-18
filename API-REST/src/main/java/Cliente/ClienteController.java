package Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Indiciamos que es un controlador rest
@RestController
class ClienteController {

    //Inyectamos el repositorio para poder hacer uso de el
    @Autowired
    private final ClienteRepository repository;

    ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        //retornará todos los usuarios
        return repository.findAll();
    }

    @GetMapping("/clientes/{id}")
    Cliente one(@PathVariable String codigo) {

        return repository.findById(codigo)
                .orElseThrow(() -> new ClienteNotFoundException(codigo));
    }
}
