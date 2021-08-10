


import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class FileManager {

    static Arquivo[] listaArquivos;
    static String diratual = "";

    static ArrayList arrayList = new ArrayList<String>();

    public static Arquivo[] abrirDiretorio(String dir) {
        File d;

        SimpleDateFormat sdf;
        int i = 0;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        d = new File(dir);
        String[] arqs = d.list();
        listaArquivos = new Arquivo[arqs.length];


        if ((!dir.equals(diratual)) || (dir.equals(""))) {

            if (d.isDirectory()) {


                for (String nome : arqs) {
                    //System.out.println(sdf.format(d.lastModified()) + "  " + nome); // nome salva nome do arquivo não lembro como pega a data
                    String data = sdf.format(d.lastModified());
                    Arquivo a = new Arquivo(nome, data);
                    listaArquivos[i] = a;
                    i++;


                }

                //return true; -- versão de luis
                // cria o arquivo.. mas não esta colocando na lista os objetos nem recuperando o nome nem a data
            }


            // versão anterior

        }

        return listaArquivos;

    }


    static void abrirArquivo(int i, String s) {

        LeitorArquivo leitorArquivo = new LeitorArquivo(s + "\\" + listaArquivos[i].getNome());
        String a = null;
        while ((a = leitorArquivo.proximaLinha()) != null) {

            System.out.print(a + " - ");

        }


    }

    static void buscarConteudo(String s, String conteudo) {
        int controle = 0;


        for (int i = 0; i < listaArquivos.length; i++) {



            LeitorArquivo leitorArquivo = new LeitorArquivo(s + "\\" + listaArquivos[i].getNome());
            String a = null;
            while ((a = leitorArquivo.proximaLinha()) != null) {

                if (a.equals(conteudo)) {
                    buscaArquivo(listaArquivos[i].getNome());
                    controle++;
                }
            }


        }
        if (controle==0){
            System.out.println("conteudo não localizado");
        }
    }

    public static void editar(String local, String texto, int indice){
        try{
            FileWriter escritor =new FileWriter(local + "\\" + listaArquivos[indice].getNome());
            escritor.write(texto);
            escritor.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("alteração realizada");
    }


    public static Arquivo buscaArquivo(String nomeBusca) {

        for (int i = 0; i < listaArquivos.length; i++) {

            if (nomeBusca.equals(listaArquivos[i].getNome())) {
                System.out.println("arquivo encontrado na posição: " + i);
                return listaArquivos[i];
            }

        }
        System.out.println("arquivo não foi encontrado");
        return null;


    }


    public static void ListarArquivos(String dir) {

        abrirDiretorio(dir);
        exibir();
    }

    public static void exibir() {

        int i = 0;
        System.out.println("Arquivos: ");

        for (Arquivo arquivos : listaArquivos) {
            System.out.print("[" + i + "] " + arquivos);
            i++;
        }
    }

    public static void ListarArquivosData(String dir) {

        abrirDiretorio(dir);
        Radix a = new Radix();//

        a.radixsort(listaArquivos);// ordena a lista do mais antigo para o mais recente

        exibir();

    }

    public static void main(String[] args) {

    }

}
