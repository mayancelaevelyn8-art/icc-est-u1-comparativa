public class Results {
    private String nombre;
    private long duration;
    private String sample;

    public Results(String nombre, long duration, String sample) {
        this.nombre = nombre;
        this.duration = duration;
        this.sample = sample;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {
        double segundos = duration / 1_000_000_000.0;
        return "Results [nombre=" + nombre + ", duration=" + duration + "ns, " + segundos + "s, sample=" + sample + "]";
    }

    
}
