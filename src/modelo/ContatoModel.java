package modelo;
import controlador.Contato;


public class ContatoModel {

    //Regras de negócio
    //RN1: Não é permitido armazenar contatos com telefones já cadastrados
    //RN2: Para detalhar, editar e remover, será necessário informar o telefone do contato

    public static boolean numeroJaInserido(Contato[] contato, String telefone) {
        boolean jaInserido = false;

        for (int i = 0; i < contato.length; i++) {
            if (contato[i].getTelefone().equals(telefone)) {
                jaInserido = true;
            }

        }
        return jaInserido;

    }

    public static boolean quantidadeIdealDigitosTelefone(String telefone) {
        final int QTD_DIGITOS_TELEFONE = 11;

        if (telefone.length() != QTD_DIGITOS_TELEFONE) {
            return false;

        } else {
            String[] telefoneSeparado = telefone.split("");
            for (int i = 0; i < QTD_DIGITOS_TELEFONE; i++) {
                try {
                    Integer.parseInt(telefoneSeparado[i]);
                } catch (NumberFormatException e) {
                    System.err.println("Um caractere inválido foi passado no telefone.");
                    return false;
                }
            }
        }
        return true;
    }
}
