import javax.swing.JFrame;

public class Field {
    
    JFrame fenster;

    public Field(){

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

    }



}
