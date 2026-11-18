public class Benchmark {
    public static Results medir(Runnable accion, String nombre, String sample) {
        System.out.println("Funcion: " + nombre);
        //Tiempo actual
        long startTime = System.nanoTime();
        //Accion
        accion.run();
        //Tiempo Final
        long endTime = System.nanoTime();

        Results resultado = new Results(nombre, (endTime - startTime), sample);
        //Return el tiempo de duracion
        return resultado;
    }
}
