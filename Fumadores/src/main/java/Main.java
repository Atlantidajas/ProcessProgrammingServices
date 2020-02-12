import java.util.ArrayList;

public class Main {

    public static void main( String[] args ) {

        Mesa mesa = new Mesa();
        Agente agente = new Agente( mesa );
        ArrayList<Fumador> fumadores = new ArrayList<Fumador>();

        //Añado tres participantes ( Fumadores )
        fumadores.add( new Fumador(0, mesa) );
        fumadores.add( new Fumador(1, mesa) );
        fumadores.add( new Fumador(2, mesa) );

        new Thread( agente ).start();

        for (int i = 0; i < fumadores.size(); i++) {
            new Thread( fumadores.get(i) ).start();
        }
    }
}