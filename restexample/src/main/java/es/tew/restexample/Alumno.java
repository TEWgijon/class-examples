package es.tew.restexample;

public class Alumno {
    private String uo;
    private String name;

    public Alumno() {}

    public Alumno(String uo, String name) {
        this.uo = uo;
        this.name = name;
    }

    public String getUo() {
        return uo;
    }

    public void setUo(String uo) {
        this.uo = uo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "uo='" + uo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
