package App.Evento;

public class EventoNotFoundException extends RuntimeException {

    EventoNotFoundException(String codigo) {
        super("Could not find evento "+codigo);
    }
}
