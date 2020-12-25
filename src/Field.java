import javax.swing.JFrame;
import javax.swing.JPanel;

public class Field extends Thread{
    
    //Das erzeugte Fenster
    private JFrame fenster;
    //Das Spielfeld mit dem 2-Dim-Array
    private SpielFeld spielFeld;
    //Das Panel, zeichnungen
    private JPanel panel;
    //kontroller
    Kontroller kontroller;

    public Field(){
        //JComponents Konstruktor ausfueheren
        super();
        //neues Fenster erstellen
        fenster = new JFrame();
        //groesse des Fensters einstellen
        fenster.setSize(1200, 900);
        //Fenster sichtbar machen
        fenster.setVisible(true);
        //Namen des Fensters
        fenster.setTitle("Snake");
        //fenster schliessen wenn X gedrueckt wird
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fenster ist in der mitte des Bildschirms
        fenster.setLocationRelativeTo(null);

        //spielfeld erzeugen
        spielFeld = new SpielFeld(20, 20);
        //JPanel erzeugen
        panel = new Panel(spielFeld.getHoehe(),spielFeld.getBreite(),fenster.getSize(),spielFeld.getEssenPos(),spielFeld.getSnakePos());
        //Panel dem Fenster hinzufuegen
        fenster.add(panel);
        //panel.doLayout();
        //panel.hasFocus();

        //kontroller erstellen fuer keyListener
        this.kontroller = new Kontroller(this);
        //focus ins fenster, dort ist der keyListener
        fenster.setFocusable(true);    
        fenster.requestFocus();

        //endlosschleife starten
        run();
    }

    /**
     * Die dauer Schleife mit aktionen waehrend des Spiels
     * 
     */
    public void run(){
        while(true){
            //alles aktuallisieren
            fenster.repaint();
            //true wenn essen gegessen
            if(this.spielFeld.nextStep()){
                //neue essenPos zeichnen
                ((Panel) panel).drawEat(spielFeld.getEssenPos());
            }
            //Thread pausieren
            try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
            }
        }
    }

    /**
     * getter fuer das Spielfeld
     * 
     * @return SpielFeld
     */
    public SpielFeld getSpielFeld(){
        return this.spielFeld;
    }

    /**
     * getter fuer das Fenster
     * 
     * @return JFrame
     */
    public JFrame getFenster(){
        return this.fenster;
    }
}
