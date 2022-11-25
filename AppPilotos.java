package aplicativos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import classes.*;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 2;
        int opcao, qtdCadastrados = 0;
        Piloto pilotos[] = new Piloto[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                //Cadastre seu piloto aqui
                Piloto piloto = new Piloto();
                
                System.out.print("Nome: ");
                piloto.setNome(in.nextLine());
                System.out.print("CPF: ");
                
                try {
                    piloto.setCpf(in.nextLine());
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Programa será encerrado.");
                    System.exit(0);
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Programa será encerrado.");
                    System.exit(0);
                }
                
                System.out.print("Idade: ");

                try {
                    piloto.setIdade(in.nextInt());
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Assumindo idade do piloto para 18 anos.");
                    piloto.setIdade(18);
                }

                System.out.print("Matricula: ");
                piloto.setMatricula(in.nextInt());
                
                in.nextLine();

                pilotos[qtdCadastrados] = piloto;
                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);

            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                for(Piloto piloto : pilotos){
                    if(piloto != null){
                        System.out.printf("\nNome: %s\n", piloto.getNome());
                        System.out.printf("CPF: %s\n", piloto.getCpf());
                        System.out.printf("Idade: %s\n", piloto.getIdade());
                        System.out.printf("Matricula: %s\n", piloto.getMatricula());
                        System.out.println("===========================");
                    }
                }
                voltarMenu(in);

            } else if (opcao == 3) {
                boolean key = false;
                Piloto pilotoEncontrado = null;
                System.out.print("\nBUSCA:> CPF Piloto: ");
                String buscaCpf = in.nextLine();
                
                for(int i=0; !key && i<pilotos.length; i++){
                    key = buscaCpf.equals(pilotos[i].getCpf());
                    pilotoEncontrado = pilotos[i];        
                }

                if(key){
                    System.out.printf("CPF: " + pilotoEncontrado.getCpf() + " cadastrado.");
                } else {
                    System.out.println("Piloto não cadastrado.");
                }
                
            } else if (opcao == 4) {
                System.out.print("Insira nova quantidade de registros: ");
                int newArrayValue = in.nextInt();

                Piloto newPilotos[] = new Piloto[pilotos.length + newArrayValue]; 
                for(int i=0; i<pilotos.length; i++){
                    newPilotos[i] = pilotos[i];
                }

                MAX_ELEMENTOS = newPilotos.length;
                pilotos = newPilotos;
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}