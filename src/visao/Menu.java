package visao;

import controlador.Contato;

public class Menu {
    public void iniciar() {
        while(true) {
            System.out.println("#####################");
            System.out.println("# Agenda telefonica #");
            System.out.println("#A###################");
            Contato contato = new Contato();

            contato.setContatos(new String[]{"matheus lima moreira", "117788559966", "math@math.com"});
            contato.setContatos(new String[]{"ricardinho sales barbosa", "1212121212", "ricardinho@math.com"});
            contato.setContatos(new String[]{"sei la man", "00000000000", "seila@math.com"});

            System.out.println(contato.getContato());
            break;
        }


    }
}
