import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {
    private final String nomeArquivo;
    private final String nomeBuscardo;

    public TarefaBuscaTextual(String nomeArquivo, String nomeBuscardo) {

        this.nomeArquivo = nomeArquivo;
        this.nomeBuscardo = nomeBuscardo;
    }

    @Override
    public void run() {

        try {
            Scanner scanner = new Scanner(new File(nomeArquivo));
            int numeroLinha = 1;
            while (scanner.hasNext()) {
                String linha = scanner.nextLine();
                if(linha.toLowerCase().contains(nomeBuscardo.toLowerCase())) {
                    System.out.println(nomeArquivo + " - " + linha + " numeroLinha = " + numeroLinha);
                }
                numeroLinha++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
