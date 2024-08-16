package controlador;
import java.util.Scanner;

import exception.AgendaVaziaException;
import exception.NumeroJaInseridoException;
import modelo.ContatoModel;

public class Contato {

    private Contato[] contato;
    private String nome;
    private String telefone;
    private String email;


    //Método construtor
    public Contato() {
        this.nome = null;
        this.telefone = null;
        this.email = null;
    }

    //Getters e Setters
    public String getNome(){
        return this.nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public String getEmail(){
        return this.email;
    }

    public void setDadosContato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public void adicionar(String nome, String telefone, String email){

        if (contato == null){
            contato = new Contato[1];
            contato[0] = new Contato();
            contato[0].setDadosContato(nome, telefone, email);
        }

        else {
            try {
                if (!ContatoModel.numeroJaInserido(contato, telefone)) {

                    Contato[] contatoAux = new Contato[contato.length + 1];
                    contatoAux = Contato.copiarAgenda(contato, contatoAux);
                    contatoAux[contato.length] = new Contato();
                    contatoAux[contato.length].setDadosContato(nome, telefone, email);

                    contato = contatoAux;
                } else {
                    throw new NumeroJaInseridoException("Número já inserido na base de dados");
                }
            }
            catch (NumeroJaInseridoException e) {
                System.err.println(e.getMessage());
            }
        }
        }

    public void remover(String telefone){

        int indice = encontrarContato(contato, telefone);
        if (indice != -1){
            Contato[] contatoAux = new Contato[contato.length - 1];
            if (indice == 0) {
                for (int i = 1; i < contatoAux.length; i++) {
                    contatoAux[i] = contato[i];
                }
            }

            else if (indice == contato.length - 1){
                for (int i = 0; i < contatoAux.length; i++) {
                    contatoAux[i] = contato[i];
                }
            }

            else {
                for( int i=0; i < indice; i++){

                    contatoAux[i] = contato[i];
                }

                for(int i=indice +1; i < contato.length; i++){

                    contatoAux[i-1] = contato[i];
                }

            }
            contato = contatoAux;
        }

    }

    public void editar(String telefone){
        try{
        int indice = encontrarContato(contato, telefone);
        Scanner s = new Scanner(System.in);

        if (indice != -1) {

            try {
                String novoNome = s.nextLine();
                String novoTelefone = s.nextLine();
                String novoEmail = s.nextLine();

                if (encontrarContato(contato, novoTelefone) != -1) {
                    throw new NumeroJaInseridoException("Número já consta na agenda");
                }
                contato[indice].setDadosContato(s.nextLine(), s.nextLine(), s.nextLine());
            } catch (NumeroJaInseridoException e) {
                System.err.println(e.getMessage());
            }
        }
        else{
            throw new NumeroJaInseridoException("Não há contato com esse número para editar");
        }
    }catch(NumeroJaInseridoException e){
            System.err.println(e.getMessage());
        }
    }

    public static int encontrarContato(Contato[] contato, String telefone){

        int indice = -1;
        for (int i=0; i< contato.length; i++){
            if (contato[i].getTelefone().equals(telefone)){
                indice = i;
            }
        }
        return indice;
    }


    public Contato getObjeto(int indice){
        try{
            if (contato != null)  return contato[indice];

            else{
                throw new AgendaVaziaException("Agenda vazia");
            }
        }
        catch (AgendaVaziaException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Contato[]  getTodoObjeto(){
        return contato;
    }


    public static Contato[] copiarAgenda(Contato[] agenda, Contato[] arrayAuxiliar){
        for (int i=0; i< agenda.length; i++){

            arrayAuxiliar[i] = agenda[i];
        }
        return arrayAuxiliar;
    }

    public int tamanhoDaAgenda(){

        try {
            if (contato != null) return contato.length;
            else throw new AgendaVaziaException("Agenda vazia");
        } catch (AgendaVaziaException e) {
            return 0;
        }
    }
}