
import java.io.File;
import java.util.Scanner;

public class Main {


    public static String[] comando() {
        Scanner scn = new Scanner(System.in);


        System.out.print("Digite um comando: ");
        String comando = scn.nextLine();
        String[] array;
        array = comando.split(" ");

        return array;
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String dir = "dir";
        String lst = "lst";
        String lstOrd = "lst ord";
        String bn = "bn";
        String bc = "bc";
        String aa = "aa";
        String ea = "ea";
        String fa = "ea";
        Integer exit = 1;
        String comando = "";
        String controleDir = "";
        String local;
        File file;


        while (!comando.equals("exit")) {


            try {
                System.out.println(
                        "\n" +
                                "Digite 'dir' para abri um diretório\n" +
                                "Digite 'exit' para encerrar a execução\n"
                );

                String[] a = comando();
                if (a[0].equals("exit")) {
                    comando = "exit";
                }
                //comando dir
                if (a[0].equals(dir)) {
                    if (a.length > 1) {
                        local = a[1];
                    } else {
                        System.out.println("Infore o local do diretório");
                        local = scn.nextLine();
                    }

                    System.out.println("Diretório: " + local);
                    controleDir = " ";
                    FileManager.abrirDiretorio(local);

                    //comandos diretorio
                    while (!controleDir.equals("sair") || controleDir.equals("exit")) {
                        System.out.println(
                                "\n\n" +
                                        "Digite 'lst' para listar os arquivos do diretório\n" +
                                        "Digite 'lst ord' para ordernar a lsita\n" +
                                        "Digite 'bn' para buscar pelo nome\n" +
                                        "Digite 'bc' para buscar por conteúdo\n" +
                                        "Digite 'aa' para abrir um arquivo pelo indice\n" +
                                        "Digite 'ea' para editar um arquivo pelo indice\n" +
                                        "Digite 'sair' para sair do diretório!"
                        );

                        String[] cmd = comando();
                        controleDir = cmd[0];

                        //lst
                        if (cmd[0].equals(lst)) {
                            //lst ord
                            if (cmd.length > 1) {

                                System.out.print("Ordenação por data digite 'd'\n" +
                                        "Ordenação por nome digite 'n'\n");
                                System.out.print("Informe o tipo de Ordenação");
                                String check = scn.nextLine();
                                if (check.equals("D") || check.equals("d")) {
                                    FileManager.ListarArquivosData(local);
                                } else {
                                    FileManager.ListarArquivos(local);
                                }

                                //lst
                            } else {
                                //Pegando local e listando os arquivos
                                FileManager.ListarArquivos(local);
                            }

                        }//Fim lst

                        //BN
                        if (cmd[0].equals(bn)) {
                            //bn nome arquivo
                            String nomeArquivo;

                            if (cmd.length > 1) {
                                System.out.println("BN NOME DO ARQUIVO");
                                nomeArquivo = cmd[1];

                            } else {
                                System.out.println("QUAL O NOME DO ARQUIVO?");
                                nomeArquivo = scn.nextLine();

                                System.out.println(nomeArquivo);
                            }
                            FileManager.buscaArquivo(nomeArquivo);

                        }//Fim BN

                        //BC
                        if (cmd[0].equals(bc)) {
                            //bc nome arquivo
                            String conteudo;

                            if (cmd.length > 1) {
                                System.out.println("Conteúdo");
                                conteudo = cmd[1];

                            } else {
                                System.out.println("QUAL O CONTEUDO A SER BUSCADO?");
                                conteudo = scn.nextLine();

                            }
                            FileManager.buscarConteudo(local, conteudo);
                        }//Fim BC

                        //AA
                        if (cmd[0].equals(aa)) {
                            //aa nome arquivo
                            int indice;

                            FileManager.exibir();
                            System.out.println("QUAL O indice A SER aberto?");
                            indice = scn.nextInt();

                            FileManager.abrirArquivo(indice, local = a[1]);


                            //Executar busca aqui
                        }//Fim AA

                        // inicio ea
                        if (cmd[0].equals(ea)) {
                            //aa nome arquivo
                            int indice;
                            FileManager.exibir();

                            System.out.println("Qual o texto a ser inserido");
                            String texto = scn.nextLine();

                            System.out.println("QUAL O indice A SER editado?");
                            indice = scn.nextInt();



                            System.out.println("inserindo conteudo no arquivo");

                            FileManager.editar(local, texto, indice);


                        }//Fim ea


                        if (controleDir.equals("sair")) {

                            System.out.println("Tela Principal - diretório Fechado\n");
                        }


                    }


                } else if (!comando.equals("exit"))
                    System.out.println("\n Diretório não inicializado!");
                //fim comando dir


            } catch (Exception e) {
                System.out.println("Erro: " + e);
            }


            if (comando.equals("exit") || controleDir.equals("exit")) {

                System.out.println("FIM\n");
            }

        }

    }
}
