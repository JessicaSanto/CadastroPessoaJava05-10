import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        PessoaFisica metodosPf = new PessoaFisica();

        System.out.println("Bem vindo ao sistema de cadastro de Pessoa Física e Pessoa Jurídica");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("Escolha uma opção: 1 - Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoPf;
                    do {

                        System.out.println("Escolha uma opção: 1 - Cadastrar Pessoa Física / 2 - Listar Pessoa Física / 0 - Voltar ao menu anterior ");
                        opcaoPf = scanner.nextInt();

                        switch (opcaoPf){
                            case 1:
                                PessoaFisica novapf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("Digite o nome da pessoa física: ");
                                novapf.nome = scanner.next();

                                System.out.println("Digite o CPF: ");
                                novapf.cpf = scanner.next();

                                System.out.println("Digite o rendimento mensal (Digite somente numero): ");
                                novapf.rendimento = scanner.nextInt();

                                System.out.println("Digite a data de Nascimento (dd/MM/aaaa): ");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                Period periodo = Period.between(date, LocalDate.now());

                                novapf.dataNascimento = date;

                                if (periodo.getYears() >= 18){
                                    System.out.println("A pessoa tem mais de 18 anos");
                                }else {
                                    System.out.println("A pessoa tem menos de 18 anos. Retornando menu...");
                                    break;
                                }

                                System.out.println("Digite o logradouro: ");
                                novoEndPf.logradouro = scanner.next();

                                System.out.println("Digite o número: ");
                                novoEndPf.numero = scanner.next();

                                System.out.println("Este endereço é comercial? S/N: ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")){
                                    novoEndPf.enderecoComercial = true;
                                }else {
                                    novoEndPf.enderecoComercial = false;
                                }

                                novapf.endereco = novoEndPf;

                                listaPf.add(novapf);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;
                            case 2:

                                if(listaPf.size() > 0){

                                    for (PessoaFisica cadaPf : listaPf){
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Endereço: " + cadaPf.endereco.logradouro + ", " + cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento: " + cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println();
                                        System.out.println("Digite 0 para continuar");
                                        scanner.nextLine();
                                    }

                                    opcaoPf = scanner.nextInt();

                                } else {
                                    System.out.println("Lista vazia");
                                }

                                break;
                            case 0:
                                System.out.println("Voltando ao menu anterior");
                                break;
                            default:
                                System.out.println("Opção inválida, por favor digite uma opção válida!");
                                break;
                        }

                    } while (opcaoPf != 0);

                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o nosso sistema! Forte abraço! ");
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite uma opção válida!");
                    break;
            }

        } while (opcao != 0);
    }
}





