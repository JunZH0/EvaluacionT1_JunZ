package com.dam.evaluaciont1_junz.datos;

import java.util.ArrayList;

public class ListadoResultados {

    private static ArrayList<Resultado> listRes = new ArrayList<Resultado>() {{
        add(new Resultado("Fase de Grupos", "29/11/2022 16:00", "Países Bajos", 1, "Qatar", 1));
        add(new Resultado("Fase de Grupos", "29/11/2022 16:00", "Ecuador", 1, "Senegal", 0));
        add(new Resultado("Fase de Grupos", "29/11/2022 20:00", "Gales", 3, "Inglaterra", 0));
        add(new Resultado("Fase de Grupos", "29/11/2022 20:00", "Irán", 1, "Estados Unidos", 2));
        add(new Resultado("Fase de Grupos", "30/11/2022 16:00\"", "Túnez", 3, "Francia", 1));
        add(new Resultado("Fase de Grupos", "30/11/2022 16:00", "Arabia Saudí", 1, "Dinamarca", 0));
        add(new Resultado("Fase de Grupos", "30/11/2022 20:00", "Polonia", 3, "México", 2));
        add(new Resultado("Fase de Grupos", "30/11/2022 20:00", "Croacia", 1, "Belgica", 0));
        add(new Resultado("Fase de Grupos", "01/12/2022 16:00", "Canadá", 4, "Dinamarca", 1));
        add(new Resultado("Fase de Grupos", "01/12/2022 16:00", "Japón", 0, "España", 1));
        add(new Resultado("Fase de Grupos", "01/12/2022 20:00", "Costa Rica", 0, "Alemania", 1));
        add(new Resultado("Fase de Grupos", "01/12/2022 20:00", "Corea del Sur", 1, "Portugal", 3));
        add(new Resultado("Fase de Grupos", "02/12/2022 16:00", "Ghana", 3, "Uruguay", 0));
        add(new Resultado("Fase de Grupos", "02/12/2022 16:00", "Serbia", 1, "Suiza", 3));
        add(new Resultado("Octavos de final", "04/12/2022 16:00", "Dinamarca", 1, "Croacia", 1));
        add(new Resultado("Octavos de final", "04/12/2022 20:00", "Belgica", 0, "Alemania", 1));
        add(new Resultado("Octavos de final", "05/12/2022 16:00", "España", 3, "Francia", 1));
        add(new Resultado("Octavos de final", "05/12/2022 20:00", "Gales", 0, "Holanda", 1));
        add(new Resultado("Octavos de final", "06/12/2022 16:00", "Brasil", 3, "Argentina", 2));
        add(new Resultado("Octavos de final", "06/12/2022 20:00", "Italia", 1, "Portugal", 1));
        add(new Resultado("Cuartos de final", "09/12/2022 16:00", "Inglaterra", 3, "Suiza", 1));
        add(new Resultado("Cuartos de final", "09/12/2022 20:00", "Holanda", 1, "Argentina", 1));
        add(new Resultado("Cuartos de final", "10/12/2022 16:00", "Alemania", 1, "Portugal", 1));
        add(new Resultado("Cuartos de final", "10/12/2022 20:00", "Francia", 3, "Brasil", 1));
        add(new Resultado("Semifinal", "13/12/2022 20:00", "Argentina", 2, "Portugal", 1));
        add(new Resultado("Semifinal", "14/12/2022 20:00", "Brasil", 1, "Suiza", 0));
        add(new Resultado("Tercer puesto", "17/12/2022 20:00", "Portugal", 3, "Brasil", 2));
        add(new Resultado("Final", "16/12/2022 20:00", "Argentina", 1, "Brasil", 0));

    }};




    public static ArrayList<Resultado> getResultado(String pais) {
        ArrayList<Resultado> listResPais = new ArrayList<>();
        for (Resultado res : listRes) {
            if (res.getEquipo1().equals(pais) || res.getEquipo2().equals(pais)) {
                listResPais.add(res);
            }
        }
        return listResPais;
    }

}
