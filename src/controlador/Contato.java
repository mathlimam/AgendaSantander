package controlador;

public class Contato {
    String[][] contatos;
    public Contato() {}

    public void adicionar(String[] contatoPassado) {
        if (contatos==null) { //Faz a verificação da lista. Se a lista estiver como null, nenhum contato foi adicionado. Então, inicializamos a lista e incluímos o valor passado como primeiro do array.
            contatos = new String[1][3];
            contatos[0] = contatoPassado;
        }

        else {
            String[][] contatosAux = new String[contatos.length+1][3];
            for(int i = 0; i<contatos.length; i++) { //Copia a array contatos para uma auxiliar com tamanho contatos.length +1
                contatosAux[i] = contatos[i];
            }

            contatosAux[contatosAux.length -1] = contatoPassado; //Pega a ultima posição da array auxiliar e incrementa o contato passado
            this.contatos = contatosAux; // Digo que minha array contatos agora é igual ao contatosAux, fazendo assim com que a array aumente de tamanho toda vez que precisarmos adicionar informações

        }
    }

    public String[] encontrar(String telefone){
        String[] resultado = new String[contatos.length];

        for(int i =0; i<contatos.length; i++){
            if (contatos[i][1].equals(telefone)){
                resultado = contatos[i];
            }
        }

        return resultado;
    }
}