package Exercicio02;

 import java.util.ArrayList;
 import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int opc = 0;
        ArrayList<Person> pessoas = new ArrayList<Person>();
        //Menu
        while(opc != 6 ) {
            System.out.println("Menu:");
            System.out.println("-------------");
            System.out.println("1 - Criar Pessoa");
            System.out.println("2 - Criar Automóvel");
            System.out.println("3 - Transferir Automóvel");
            System.out.println("4 - Mostrar todas as Pessoas");
            System.out.println("5 - Mostrar Automóvel da Pessoa");
            System.out.println("6 - Sair");
            opc = Integer.parseInt(keyboard.next());

            switch (opc) {
                case 1:
                    Person p = new Person(); // cria pessoa

                    keyboard.nextLine();

                    System.out.println("Digite o código da pessoa:");
                    p.setCodigo(Integer.parseInt(keyboard.nextLine()));
                    System.out.println("Digite o nome da pessoa:");
                    p.setNome(keyboard.nextLine());

                    pessoas.add(p); // adiciona pessoa na lista de pessoas
                    break;

                case 2:
                    Automovel a = new Automovel(); // cria automovel

                    keyboard.nextLine();

                    System.out.println("Qual a marca do automóvel?");
                    a.setMarca(keyboard.nextLine());
                    System.out.println("Qual o modelo do automóvel?");
                    a.setModelo(keyboard.nextLine());

                    // Seleciona a quem o veículo pertence
                    int pessoaEscolhida;
                    System.out.println("Selecione a pessoa a quem este veículo pertence:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        int x = i + 1;
                        System.out.println(x + " - " + pessoas.get(i).getNome());
                    }
                    pessoaEscolhida = Integer.parseInt(keyboard.nextLine()) - 1;
                    pessoas.get(pessoaEscolhida).inserirAutomovel(a); // adiciona o veículo ao proprietário escolhido;
                    break;

                case 3:

                    keyboard.nextLine();

                    // Seleciona o antigo proprietário
                    int antigoProprietario;
                    System.out.println("Selecione o proprietário atual do veículo:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        int x = i + 1;
                        System.out.println(x + " - " + pessoas.get(i).getNome());
                    }
                    antigoProprietario = Integer.parseInt(keyboard.nextLine()) - 1;

                    // Seleciona qual o veículo será transferido
                    int automovelEscolhido;
                    System.out.println("Selecione o veículo que deseja transferir:");
                    for (int i = 0; i < pessoas.get(antigoProprietario).getAutomoveis().size(); i++) {
                        int x = i + 1;
                        System.out.println(x + " - " + pessoas.get(antigoProprietario).getAutomoveis().get(i).getModelo());
                    }
                    automovelEscolhido = Integer.parseInt(keyboard.nextLine()) - 1;

                    // Seleciona o novo proprietário
                    int novoProprietario;
                    System.out.println("Selecione o novo proprietário do veículo:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        int x = i + 1;
                        System.out.println(x + " - " + pessoas.get(i).getNome());
                    }
                    novoProprietario = Integer.parseInt(keyboard.nextLine()) - 1;

                    // Adiciona o automóvel ao novo proprietário
                    pessoas.get(novoProprietario).inserirAutomovel(pessoas.get(antigoProprietario).getAutomoveis()
                            .get(automovelEscolhido));

                    // Remove o automóvel do antigo proprietário
                    pessoas.get(antigoProprietario).removerAutomovel(automovelEscolhido);
                    break;

                case 4:
                    // Imprime todas as pessoas
                    for (Person pessoa : pessoas) {
                        System.out.println(pessoa.imprimir());
                    }
                    break;

                case 5:

                    keyboard.nextLine();

                    // Seleciona a pessoa
                    System.out.println("Selecione quem deseja verificar os veículos:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        int x = i + 1;
                        System.out.println(x + " - " + pessoas.get(i).getNome());
                    }
                    pessoaEscolhida = Integer.parseInt(keyboard.nextLine()) - 1;

                    // Imprime os dados da pessoa escolhida
                    System.out.println(pessoas.get(pessoaEscolhida).imprimirCompleto());
                    break;

                case 6:
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("O número digitado não é válido!");
                    break;
            }
        }
        keyboard.close();
        }
    }

