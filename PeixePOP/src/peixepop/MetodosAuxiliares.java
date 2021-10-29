/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peixepop;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Developer
 */
public class MetodosAuxiliares {
    
    // Genera un array de int con numeros que le pasas por parametro
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
        
        shuffleArray(result);
        
        return result;
    }
    
    // Cambia de posicion el array de numeros generados aleatoriamente
    private void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
