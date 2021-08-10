class Radix {

    static void contador(int[] array, int n, int unidade) {
        int[] resultado = new int[n]; // vetor que recebe os valores arrumados - resultados
        int i;
        int[] contador = new int[10];

//inicializa o count sort
        for (i = 0; i < n; i++) {
            contador[(array[i] / unidade) % 10]++;
        }// contabiliza o numero de ocorrencias

      /*  System.out.println("verificação do numero de ocorrencias");
        for (int j = 0; j < contador.length; j++) {
            System.out.print(contador[j] + ", ");
        }
        System.out.println("\n fim da verificação do numero de ocorrencias");*/


        for (i = 1; i < 10; i++)
            contador[i] += contador[i - 1];
        /*System.out.println("verifica 2 == soma dos contadores");
        for (int j = 0; j < contador.length; j++) {
            System.out.print(contador[j] + ", ");
        }
        System.out.println("\n verifica 2 FIM");
        System.out.println("verifica 3 == como o vetor esta");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + ", ");
        }
        System.out.println("\n verifica 3 FIM");*/

        for (i = n - 1; i >= 0; i--) {
            resultado[contador[(array[i] / unidade) % 10] - 1] = array[i];// resultado do count sort
            contador[(array[i] / unidade) % 10]--;
        }
       /*System.out.println("verifica 4 == como o vetor resultado");
        for (int j = 0; j < resultado.length; j++) {
            System.out.print(resultado[j] + ", ");
        }
        System.out.println("\n verifica 4 FIM");// fim do count sort
*/
        for (i = 0; i < n; i++) {
            array[i] = resultado[i];
        }
    }


    static void radixsort(Arquivo[] vetor) {

        int test[] = new int[vetor.length];

        for (int i = 0; i < vetor.length; i++) {

            test[i] = vetor[i].retornaData();
        }

        int maior = test[0];
        int n = vetor.length;
        for (int i = 1; i < n; i++) {
            if (test[i] > maior)
                maior = test[i];
        }

        //  System.out.println("o maior numero da vez é: " + maior);


        for (int unidade = 1; maior / unidade > 0; unidade = unidade * 10) { // vai rodar por unidade 1, 10, 100 ...
            //System.out.println("verifica unidade: " + unidade);
            contador(test, n, unidade);
        }


        Arquivo[] controle = new Arquivo[vetor.length];
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                if (test[i] == vetor[j].retornaData()) {
                    Arquivo aux = vetor[i];
                    vetor[i]=vetor[j];
                    vetor[j]=aux;

                    }

            }
        }





    }// pensar em uma forma de colocar isso por data


    /*public static void main(String[] args) {
        Arquivo a = new Arquivo("test", "12/10/2019");
        Arquivo a1 = new Arquivo("test1", "12/10/2018");
        Arquivo a2 = new Arquivo("test2", "12/11/2019");
        Arquivo a3 = new Arquivo("test3", "12/01/2019");
        Arquivo a4 = new Arquivo("test4", "12/11/2019");

        Arquivo[] vetor = {a, a1, a2, a3, a4};

        radixsort(vetor);

        System.out.println();
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + ", ");
        }
    }*/
}

