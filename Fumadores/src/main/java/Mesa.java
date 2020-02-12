import java.util.ArrayList;

public class Mesa {

    private int idIngrediente;
    private ArrayList<String> ingredientes = new ArrayList<String>();
    private boolean fumar = false;
    private boolean cogeIngrediente = false;

    public Mesa(){

    }

    public synchronized void nuevosIngredientes( int idIngrediente ) throws InterruptedException {

        while ( fumar || cogeIngrediente )
            wait();
        this.idIngrediente = idIngrediente;
        cogeIngrediente = true;

        //Añado los ingredientes
            this.ingredientes.add( "Tabaco" );
            this.ingredientes.add( "Papel" );
            this.ingredientes.add( "Mechero" );

        System.out.println("Agente pone sobre la mesa " + ingredientes.get( idIngrediente ));

        notifyAll();//<-- Notifico que agente pone ingrdiente
        this.idIngrediente = idIngrediente;

    }

    public synchronized void cogeIngrediente( int identificadorFumador ) throws InterruptedException {

        while ( !cogeIngrediente || fumar )
            wait();//<- paro
            System.out.println( "Fumador número: " + identificadorFumador + " fuma" );
            cogeIngrediente = false;
            fumar = true;
    }

    public synchronized void sueltaIngrediente( int identificadorFumador ) {

        fumar = false;
        System.out.println("Fumador número: " + identificadorFumador + " deja de fumar");
        notifyAll();//-- Notifico que fumador suelta componente.

    }
}