import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Metodos m = new Metodos();
        Generador g = new Generador();
        List<Results> resultados = new ArrayList<>();

        //Los arreglos base
        //10000
        int[] list1 = g.generate(10000);
        //50000
        int[] list2 = g.generate(50000);
        //100000
        int[] list3 = g.generate(100000);

        int[] list1c1 = list1.clone();
        int[] list1c2 = list1.clone();
        int[] list1c3 = list1.clone();
        Integer[] list1c4 = boxear(list1);
        Integer[] list1c5 = boxear(list1);

        int[] list2c1 = list2.clone();
        int[] list2c2 = list2.clone();
        int[] list2c3 = list2.clone();
        Integer[] list2c4 = boxear(list2);
        Integer[] list2c5 = boxear(list2);

        int[] list3c1 = list3.clone();
        int[] list3c2 = list3.clone();
        int[] list3c3 = list3.clone();
        Integer[] list3c4 = boxear(list3);
        Integer[] list3c5 = boxear(list3);

    
        int[] ref1 = list1.clone();
        Arrays.sort(ref1);
        int[] ref2 = list2.clone();
        Arrays.sort(ref2);
        int[] ref3 = list3.clone();
        Arrays.sort(ref3);

        //V1 Burbuja
        Results resultaM1S1 = Benchmark.medir(
                () -> m.sortBubble(list1c1), "Burbuja", "10.000");
        verificar(list1c1, ref1);
        resultados.add(resultaM1S1);
        Results resultaM1S2 = Benchmark.medir(
                () -> m.sortBubble(list2c1), "Burbuja", "50.000");
        verificar(list2c1, ref2);
        resultados.add(resultaM1S2);
        Results resultaM1S3 = Benchmark.medir(
                () -> m.sortBubble(list3c1), "Burbuja", "100.000");
        verificar(list3c1, ref3);
        resultados.add(resultaM1S3);

        //V2 Merge sort
        Results resultaM2S1 = Benchmark.medir(
                () -> m.sortMerge(list1c2), "Merge Sort", "10.000");
        verificar(list1c2, ref1);
        resultados.add(resultaM2S1);
        Results resultaM2S2 = Benchmark.medir(
                () -> m.sortMerge(list2c2), "Merge Sort", "50.000");
        verificar(list2c2, ref2);
        resultados.add(resultaM2S2);
        Results resultaM2S3 = Benchmark.medir(
                () -> m.sortMerge(list3c2), "Merge Sort", "100.000");
        verificar(list3c2, ref3);
        resultados.add(resultaM2S3);

        //V3 Arrays.sort
        Results resultaM3S1 = Benchmark.medir(
                () -> m.sortArrays(list1c3), "Arrays.sort", "10.000");
        verificar(list1c3, ref1);
        resultados.add(resultaM3S1);
        Results resultaM3S2 = Benchmark.medir(
                () -> m.sortArrays(list2c3), "Arrays.sort", "50.000");
        verificar(list2c3, ref2);
        resultados.add(resultaM3S2);
        Results resultaM3S3 = Benchmark.medir(
                () -> m.sortArrays(list3c3), "Arrays.sort", "100.000");
        verificar(list3c3, ref3);
        resultados.add(resultaM3S3);

        //V4 Arrays.sort con Comparator
        Results resultaM4S1 = Benchmark.medir(
                () -> m.sortComparator(list1c4), "Arrays.sort Comparator", "10.000");
        verificar(list1c4, ref1);
        resultados.add(resultaM4S1);
        Results resultaM4S2 = Benchmark.medir(
                () -> m.sortComparator(list2c4), "Arrays.sort Comparator", "50.000");
        verificar(list2c4, ref2);
        resultados.add(resultaM4S2);
        Results resultaM4S3 = Benchmark.medir(
                () -> m.sortComparator(list3c4), "Arrays.sort Comparator", "100.000");
        verificar(list3c4, ref3);
        resultados.add(resultaM4S3);

        //Collectors
        Results resultaM5S1 = Benchmark.medir(
                () -> m.sortCollectors(list1c5), "Collectors", "10.000");
        verificar(list1c5, ref1);
        resultados.add(resultaM5S1);
        Results resultaM5S2 = Benchmark.medir(
                () -> m.sortCollectors(list2c5), "Collectors", "50.000");
        verificar(list2c5, ref2);
        resultados.add(resultaM5S2);
        Results resultaM5S3 = Benchmark.medir(
                () -> m.sortCollectors(list3c5), "Collectors", "100.000");
        verificar(list3c5, ref3);
        resultados.add(resultaM5S3);

        for (Results results : resultados) {
            System.out.println(results);
        }
    }

    public static Integer[] boxear(int[] base) {
        Integer[] copia = new Integer[base.length];
        for (int i = 0; i < base.length; i++) {
            copia[i] = base[i];
        }
        return copia;
    }

    public static void verificar(int[] obtenido, int[] ref) {
        if (!Arrays.equals(obtenido, ref)) {
            throw new IllegalStateException("No esta ordenado o faltan elementos");
        }
    }

    public static void verificar(Integer[] obtenido, int[] ref) {
        for (int i = 0; i < ref.length; i++) {
            if (obtenido[i] != ref[i]) {
                throw new IllegalStateException("No esta ordenado o faltan elementos");
            }
        }
    }
}