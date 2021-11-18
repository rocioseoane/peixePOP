package App.Planta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantaRepository extends JpaRepository<Planta, String> {
    // Gracias a esta interfaz extendedida de JPA, tenemos ya creados los métodos de un CRUD básico.
}
