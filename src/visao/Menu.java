package visao;

import controlador.Contato;

import java.util.Arrays;

public class Menu {
    public void iniciar() {
        while(true) {
            System.out.println("#####################");
            System.out.println("# Agenda telefonica #");
            System.out.println("#A###################");
            Contato contato = new Contato();

            contato.adicionar(new String[]{"matheus lima moreira", "117788559966", "math@math.com"});
            contato.adicionar(new String[]{"ricardinho sales barbosa", "1212121212", "ricardinho@math.com"});
            contato.adicionar(new String[]{"sei la man", "00000000000", "seila@math.com"});

            System.out.println(Arrays.toString(contato.encontrar("117788559966")));
            break;
        }


    }
}
