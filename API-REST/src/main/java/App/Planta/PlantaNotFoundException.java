package App.Planta;

class PlantaNotFoundException extends RuntimeException {

    PlantaNotFoundException(String codigo) {
        super("Could not find planta " + codigo);
    }
}
