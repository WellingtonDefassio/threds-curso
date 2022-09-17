package banheiro;

public class PrincipalBanheiro {

    public static void main(String[] args) {

        Banheiro banheiro = new Banheiro();

        Thread thread1 = new Thread(new TarefaNumero1(banheiro), "convidado1");
        Thread thread2 = new Thread(new TarefaNumero2(banheiro), "convidado2");
        Thread limpeza = new Thread(new TarefaRealizarLimpeza(banheiro), "limpeza");
        limpeza.setDaemon(true);
        Thread thread3 = new Thread(new TarefaNumero2(banheiro), "convidado3");
        Thread thread4 = new Thread(new TarefaNumero1(banheiro), "convidado4");

        thread1.start();
        limpeza.start();
        thread2.start();
//        thread3.start();
//        thread4.start();

    }
}
