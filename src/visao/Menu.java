package visao;
import controlador.Contato;
import utilitario.Util;

public class Menu {
    public void iniciar() {
        Contato contato = new Contato();

        while(true) {
            Util.escrever("##################################################################\n");
            Util.escrever("#                        Agenda telefonica                       #\n");
            Util.escrever("##################################################################\n");
            Util.escrever("__________________________________________________________________\n");
            Util.escrever("I |        Nome        |      Telefone      |        Email       |\n");

            Util.imprimirAgenda(contato);
            Util.escrever("__________________________________________________________________\n");
            Util.escrever("\nMenu de opções\n");
            Util.escrever("1 - Adicionar\n");
            Util.escrever("2 - Remover\n");
            Util.escrever("3 - Editar\n");
            Util.escrever("4 - Detalhar\n");
            Util.escrever("5 - Sair\n");

            String opcao = Util.ler("Digite uma opção: ");

            switch (opcao){
                case "1":
                    while(true) {
                        Util.adicionarContato(contato);
                        if (Util.ler("\nDeseja incluir um novo contato (S/N)?: ").equalsIgnoreCase("n")) break;
                    }
                    break;

                case "2":
                    contato.remover(Util.ler("Digite o número de telefone do contato que quer apagar: "));
                    Util.escrever("\n");
                    break;

                case "3":
                    while(true) {
                        contato.editar(Util.ler("Digite o número de telefone do contato que quer editar: "));
                        if(Util.ler("\nDeseja editar um outro contato (S/N)?: ").equalsIgnoreCase("n")) break;

                    }
                    break;

                case "4":
                    while(true){
                        String telefone = Util.ler("Digite o número de telefone do contato que você quer detalhar: ");
                        Util.escrever("\n\n");
                        Util.escrever("###########################################\n");
                        Util.escrever("#           Detalhes do contato           #\n");
                        Util.escrever("###########################################\n");
                        int indice = Contato.encontrarContato(contato.getTodoObjeto(), telefone);
                        Util.detalharContato(contato,indice);

                        Util.escrever("___________________________________________\n");

                        if(Util.ler("Deseja detalhar outro contato (S/N)?: ").equalsIgnoreCase("n")) break;
                    }
                    break;

                case "5":
                    break;
            }


        }

    }
}
