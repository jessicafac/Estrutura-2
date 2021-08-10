import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/***
 * Classe responsável por ler arquivos.
 * @author Luis Araujo
 * */
public class LeitorArquivo {
	FileReader fileReader;
	BufferedReader bufferedReader;


	LeitorArquivo(String file){
		abrir(file);
	}

	public void abrir(String file){
		//colocar o arquivo na raiz do projeto
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedReader = new BufferedReader(fileReader);
	}


	public String proximaLinha() {
		String linha;
		try {
			linha = bufferedReader.readLine();
			return linha;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}


	public void fechar() {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
