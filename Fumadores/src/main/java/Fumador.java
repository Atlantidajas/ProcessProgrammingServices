import java.util.Random;

public class Fumador implements Runnable {

    private int identificadorFumador;
    private Mesa mesa;

    public Fumador( int identificadorFumador, Mesa mesa ) {
        this.identificadorFumador = identificadorFumador;
        this.mesa = mesa;
    }

    public void run() {

        while ( true ) {
            try {
                Thread.sleep(3000);
                mesa.cogeIngrediente( identificadorFumador );
                mesa.sueltaIngrediente( identificadorFumador );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}