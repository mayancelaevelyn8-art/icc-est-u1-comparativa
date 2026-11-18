import java.util.ArrayList;
import java.util.List;

public class Generador {
    //Listado tamaño aleatorio 0 - size
    //Con numeros aleatorios entre 0 - size
    public static List<Integer> generate(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * size));
        }
        return list;
    }
}
