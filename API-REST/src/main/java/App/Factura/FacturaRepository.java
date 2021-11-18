package App.Factura;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, String> {
    // Gracias a esta interfaz extendedida de JPA, tenemos ya creados los métodos de un CRUD básico.
}
