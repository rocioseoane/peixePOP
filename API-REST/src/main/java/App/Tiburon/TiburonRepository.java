package App.Tiburon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TiburonRepository extends JpaRepository<Tiburon, String> {
    // Gracias a esta interfaz extendedida de JPA, tenemos ya creados los métodos de un CRUD básico.
}
