package App.Estanque;

class EstanqueNotFoundException extends RuntimeException {

    EstanqueNotFoundException(String codigo) {
        super("Could not find estanque " + codigo);
    }
}
