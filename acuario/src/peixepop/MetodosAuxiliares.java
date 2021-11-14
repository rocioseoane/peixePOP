package peixepop;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase auxiliar para el acuario
 * @author Angel, Jose, Miguel, Paulo
 */
class MetodosAuxiliares {
    
    /**
     * Método que genera números aleatorios ordenados entre un rango 
     * @param start Donde empieza el rango, incluyendo ese número
     * @param end Donde acaba el rango, incluyendo ese número
     * @param count De ese rango definido coje x números
     * @return 
     */
    public int[] numerosAleatoriosNoRepetidos(int start, int end, int count) {
        Random rng = new Random();

        int[] result = new int[count];
        int cur = 0;
        int remaining = end - start;
        for (int i = start; i < end && count > 0; i++) {
            double probability = rng.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                result[cur++] = i;
            }
            remaining--;
        }
        
        // Desordenamos los numeros que nos dió;
        // e.g no devuelve esto (0, 3, 7, 8) => con shuffle (7, 3, 9, 0)
        shuffleArray(result);
        
        return result;
    }
    
    /**
     * Método que recoge un array por parámetro y cambia de posición los
     * contenidos de ese array
     * @param array El array que quieres desordenar
     */
    private void shuffleArray(int[] array) {
        Random rnd = ThreadLocalRandom.current();
        
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }
}
