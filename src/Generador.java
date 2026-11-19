import java.util.ArrayList;
import java.util.List;

public class Generador {

    //Listado tamaño aleatorio 0 - size
    //Con numeros aleatorios entre 0 - size
    public static int[] generate(int size) {
        if (size < 0)
            throw new IllegalArgumentException("size negativo");
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int) (Math.random() * (size + 1L));
        }
        return list;
    }
}