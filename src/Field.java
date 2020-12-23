import javax.swing.JFrame;
import javax.swing.JPanel;

public class Field extends Thread{
    
    //Das erzeugte Fenster
    JFrame fenster;
    //Das Spielfeld mit dem 2-Dim-Array
    SpielFeld spielFeld;
    //Das Panel, zeichnungen
    JPanel panel;

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
        spielFeld = new SpielFeld(10, 15);
        //JPanel erzeugen
        panel = new Panel(spielFeld.getHoehe(),spielFeld.getBreite(),fenster.getSize());
        //Panel dem Fenster hinzufuegen
        fenster.add(panel);
        //run();
    }

    /**
     * Die dauer Schleife mit aktionen waehrend des Spiels
     * 
     */
    public void run(){
        while(true){
            panel.repaint();
            fenster.repaint();

            /*
            try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
            }
            */
        }
    }
}
