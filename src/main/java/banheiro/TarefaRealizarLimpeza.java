package banheiro;

public class TarefaRealizarLimpeza implements Runnable {
    private final Banheiro banheiro;

    public TarefaRealizarLimpeza(Banheiro banheiro) {

        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        while (true){
            banheiro.limparBanheiro();
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
