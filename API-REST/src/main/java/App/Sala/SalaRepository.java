package App.Sala;

import App.Sala.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, String> {
    // Gracias a esta interfaz extendedida de JPA, tenemos ya creados los métodos de un CRUD básico.
}
