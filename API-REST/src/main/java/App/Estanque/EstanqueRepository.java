package App.Estanque;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstanqueRepository extends JpaRepository<Estanque, String> {
    // Gracias a esta interfaz extendedida de JPA, tenemos ya creados los métodos de un CRUD básico.
}
