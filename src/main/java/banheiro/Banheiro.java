package banheiro;

public class Banheiro {

    private boolean ehSujo = true;

    public void limparBanheiro() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            if(!ehSujo) {
                System.out.println(nome + " banheiro está limpo sair ");
                return;
            }

            System.out.println(nome + " limpando banheiro");
            this.ehSujo = false;
            dormeUmPouco(12000);
            this.notifyAll();
            System.out.println(nome + " terminou a limpeza");
        }
    }

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (ehSujo) {
                esperaLaFoora(nome);
            }

            System.out.println(nome + " fazendo coisa rapida");
            dormeUmPouco(5000);
            this.ehSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " saindo banheiro");

        }

    }


    public void fazNumero2() {

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {
            System.out.println(nome + " entrando no banheiro");

            while (ehSujo) {
                esperaLaFoora(nome);
            }

            System.out.println(nome + " fazendo coisa demorada");

            dormeUmPouco(10000);

            this.ehSujo = true;

            System.out.println(nome + " dando descarga");
            System.out.println(nome + " saindo banheiro");

        }
    }

    private void dormeUmPouco(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void esperaLaFoora(String nome) {
        System.out.println(nome + ", eca, banheiro tá sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
