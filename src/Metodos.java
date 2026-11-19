import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Metodos {
    public void sortBubble(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int aux = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = aux;
                    swap = true;
                }
            }
            if (!swap)
                return;
        }
    }

    public void sortMerge(int[] list) {
        if (list.length < 2)
            return;
        mergeSort(list, 0, list.length - 1);
    }

    private void mergeSort(int[] list, int izq, int der) {
        if (izq >= der)
            return;
        int medio = (izq + der) / 2;
        mergeSort(list, izq, medio);
        mergeSort(list, medio + 1, der);
        merge(list, izq, medio, der);
    }

    private void merge(int[] list, int izq, int medio, int der) {
        int[] aux = new int[der - izq + 1];
        int i = izq;
        int j = medio + 1;
        int k = 0;
        while (i <= medio && j <= der) {
            if (list[i] <= list[j]) {
                aux[k++] = list[i++];
            } else {
                aux[k++] = list[j++];
            }
        }
        while (i <= medio) {
            aux[k++] = list[i++];
        }
        while (j <= der) {
            aux[k++] = list[j++];
        }
        for (int x = 0; x < aux.length; x++) {
            list[izq + x] = aux[x];
        }
    }

    public void sortArrays(int[] list) {
        Arrays.sort(list);
    }

    public void sortComparator(Integer[] list) {
        Comparator<Integer> comparador = (a, b) -> Integer.compare(a, b);
        Arrays.sort(list, comparador);
    }

    public void sortCollectors(Integer[] list) {
        Arrays.stream(list).sorted().collect(Collectors.toList()).toArray(list);
    }
}