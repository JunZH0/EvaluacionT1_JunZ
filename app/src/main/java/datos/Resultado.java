package datos;

public class Resultado {
    private String fase;
    private String fecha;
    private String equipo1;
    private int gol1;
    private String equipo2;
    private int gol2;

    public Resultado(String fase, String fecha, String equipo1, int gol1, String equipo2, int gol2) {
        this.fase = fase;
        this.fecha = fecha;
        this.equipo1 = equipo1;
        this.gol1 = gol1;
        this.equipo2 = equipo2;
        this.gol2 = gol2;
    }

    @Override
    public String toString() {
        return "Resultados: " +
                "Fase = " + fase + '\'' +
                ", Fecha = " + fecha + '\'' +
                ", Equipo 1='" + equipo1 + '\'' +
                ", Goles Equipo 1 = " + gol1 +
                ", Equipo 2 = '" + equipo2 + '\'' +
                ", Goles Equipo 2 = " + gol2;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }


}
