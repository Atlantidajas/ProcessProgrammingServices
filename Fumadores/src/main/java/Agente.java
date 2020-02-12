import java.util.Random;

public class Agente implements Runnable {

    private Mesa mesa;
    private Random numeroAleatorio = new Random();

    public Agente(Mesa mesa) {
        this.mesa = mesa;
    }

    public void run() {

        while (true) {
            int ingrediente = numeroAleatorio.nextInt(3);
            try {
                Thread.sleep( 3000 );
                mesa.nuevosIngredientes(ingrediente);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
