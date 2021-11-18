package Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    // Gracias a esta interfaz extendedida de JPA, tenemos ya creados los métodos de un CRUD básico.
}
