package utilitario;
import controlador.Contato;
import exception.AgendaVaziaException;
import exception.QtdDigitosTelefoneException;
import modelo.ContatoModel;

import java.util.Scanner;



public  class Util {

    Scanner s = new Scanner(System.in);
    private static final int TAMANHO = 20;

    public static void escrever(String texto){

        System.out.printf("%s", texto);
    }

    public static void escrever(Contato contato, int indice){
        System.out.printf("%d |", indice+1);
        System.out.print(verificarTamanho(contato.getNome()));
        System.out.print(verificarTamanho(contato.getTelefone()));
        System.out.println(verificarTamanho(contato.getEmail()));
    }

    public static void adicionarContato(Contato contato){
        try {
            String nome = Util.ler("Digite o nome: ");
            String telefone = Util.ler("Digite o telefone: ");
            String email = Util.ler("Digite o email: ");
            if (ContatoModel.quantidadeIdealDigitosTelefone(telefone)) contato.adicionar(nome, telefone, email);
            else throw new QtdDigitosTelefoneException("A agenda só aceita telefones com 11 digitos");

        } catch (QtdDigitosTelefoneException e){
            System.err.println(e.getMessage());

        }
    }

    public static void imprimirAgenda(Contato contato){
        for (int i =0; i<contato.tamanhoDaAgenda(); i++){
            try {
                Util.escrever(contato.getObjeto(i), i);
            } catch (AgendaVaziaException e) {
                Util.escrever("Agenda vazia");
            }
        }

    }

    public static void detalharContato(Contato contato, int indice){
        try{
            Util.escrever(String.format("Nome: %s\n", contato.getObjeto(indice).getNome()));
            Util.escrever(String.format("Telefone: %s\n", contato.getObjeto(indice).getTelefone()));
            Util.escrever(String.format("Email: %s\n", contato.getObjeto(indice).getEmail()));

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static String ler(String mensagem){

        escrever(mensagem);
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        return input;

    }

    public static String verificarTamanho(String parametro){


        if (parametro.length() >= TAMANHO){
            parametro = parametro.substring(0, TAMANHO-5).concat("...");
        }

        if (parametro.length() < TAMANHO) {
            int espacosParaIncluir = (int) (TAMANHO - parametro.length())/2;
            String resultado = "";
            for (int i=0; i < (espacosParaIncluir); i++){
                resultado = resultado.concat(" ");
            }
            resultado = resultado.concat(parametro);
            for (int i = resultado.length(); i< TAMANHO; i++){

                if(i == TAMANHO-1){
                    resultado = resultado.concat(" |");
                }
                else {
                    resultado = resultado.concat(" ");
                }

            }
            parametro = resultado;
        }

     return parametro;
    }

    public void fecharScanner(){
        this.s.close();
    }


}
