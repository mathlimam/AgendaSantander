package controlador;

import java.util.Arrays;

public class Contato {
    String[][] contatos;
    public Contato() {}

    public void setContatos(String[] contatoPassado) {

        if (contatos==null) {
            contatos = new String[1][3];
            contatos[0] = contatoPassado;

        }

        else{
            String[][] contatosAux = new String[contatos.length+1][3];
            for(int i = 0; i<contatos.length; i++) {
                contatosAux[i] = contatos[i];
            }
            contatosAux[contatosAux.length -1] = contatoPassado;
            this.contatos = contatosAux;

        }
    }

    public String getContato(){
        for (int i =0; i<contatos.length; i++){
            System.out.println(Arrays.toString(this.contatos[i]));

        }
        return Arrays.toString(this.contatos[1]);
    }
}
