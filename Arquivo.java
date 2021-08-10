public class Arquivo {
        String nome;
        String data;

        Arquivo(String nome, String data){
            this.nome = nome;
            this.data = data;
        }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public int retornaData() {

            String array[] = new String[3];
            array = data.split("/");

            int dates = Integer.parseInt(array[0]) + Integer.parseInt(array[1])*100+ Integer.parseInt(array[2])*10000;
            return dates;
        }

        @Override
        public String toString(){
            return nome + " - " + data+"\n";
        }
    }

