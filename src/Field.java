import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class Field extends Thread implements ComponentListener {

    //Das erzeugte Fenster
    private JFrame fenster;
    private final int fensterBreite = 900;
    private final int fensterHoehe = 900;

    // Das Spielfeld mit dem 2-Dim-Array
    private SpielFeld spielFeld;
    // Das Panel, zeichnungen
    private JPanel panel;
    // kontroller
    Kontroller kontroller;
    // wurde auf start gedrueckt
    boolean start = false;
    // button zum starten
    private JButton startButton =null;

    public Field() {
        //JComponents Konstruktor ausfueheren
        super();
        //neues Fenster erstellen
        fenster = new JFrame();
        //groesse des Fensters einstellen
        fenster.getContentPane().setPreferredSize(new Dimension(fensterBreite,fensterHoehe));
        // Fenster sichtbar machen
        fenster.setVisible(true);
        //Namen des Fensters
        fenster.setTitle("Snake");
        //fenster schliessen wenn X gedrueckt wird
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fenster ist in der mitte des Bildschirms
        fenster.setLocationRelativeTo(null);
        //Component Listener fuer reaktion auf fenster groesse veraendert
        fenster.addComponentListener(this);
        //fenster groesse laesst sich nicht veraendern
        fenster.setResizable(false);
        //groesse des Fensters anwenden
        fenster.pack();
        

        //spielfeld erzeugen
        spielFeld = new SpielFeld(20, 20);
        //JPanel erzeugen
        panel = new Panel(spielFeld.getHoehe(),
                            spielFeld.getBreite(),
                            this.fenster,
                            spielFeld.getEssenPos(),
                            spielFeld.getSnakePos(),
                            this.fensterBreite,this.fensterHoehe);
        
        // kontroller erstellen fuer keyListener
        this.kontroller = new Kontroller(this);

        //startButton Initialisieren
        //initStartButton();

        //Panel dem Fenster hinzufuegen
        fenster.add(panel);
        //focus ins fenster, dort ist der keyListener
        fenster.setFocusable(true);
        fenster.requestFocus();

        //fenster ein kleines bisschen vergroessern, fehler feld wird nicht angezeigt
        this.fenster.resize((int)fenster.getSize().getWidth(), (int)fenster.getSize().getHeight()+1);
        this.fenster.resize((int)fenster.getSize().getWidth(), (int)fenster.getSize().getHeight()-1);
        fenster.getContentPane().setPreferredSize(new Dimension(fensterBreite,fensterHoehe));

        //endlosschleife starten
        run();
    }

    /**
     * Die dauer Schleife mit aktionen waehrend des Spiels
     * 
     */
    public void run() {
        while (true) {
            fenster.repaint();
            while (start) {
                // alles aktuallisieren
                fenster.repaint();
                // true wenn essen gegessen
                if (this.spielFeld.nextStep()) {
                    // neue essenPos zeichnen
                    ((Panel) panel).setEatPos(spielFeld.getEssenPos());
                }
                // Thread pausieren
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initStartButton() {
        //startButton erstellen
        this.startButton = new JButton("START");
        //sichtbarkeit aktivieren
        startButton.setOpaque(true);
        startButton.setVisible(true);
        //Farbe des Buttons
        startButton.setBackground(Color.GREEN);
        //Button Position und groesse
        startButton.setBounds(fenster.getWidth() / 2 - fenster.getWidth() / 10,
                              fenster.getHeight() / 2 - fenster.getHeight() / 20,
                              fenster.getWidth() / 10,
                              fenster.getHeight() / 20);
        //action Listener um auf druck ztu reagieren
        startButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (!start) {
                    // Spiel starten
                    start = true;
                    // Button unsichtbar machen
                    startButton.setVisible(false);
                }
                // focus wieder in fenster, fuer keyListener
                fenster.requestFocus();
            }
        });
        //button dem fenster hinzufuegen
        fenster.add(startButton);
    }

    /**
     * getter fuer das Spielfeld
     * 
     * @return SpielFeld
     */
    public SpielFeld getSpielFeld() {
        return this.spielFeld;
    }

    /**
     * getter fuer das Fenster
     * 
     * @return JFrame
     */
    public JFrame getFenster() {
        return this.fenster;
    }

    /**
     * startet das Spiel(run()-Schleife) bzw. pausiert, wenn das spiel gerade lauft
     * 
     */
    public void startStop() {
        if (this.start) {
            this.start = false;
            //fenster.remove(startButton);
            //initStartButton();
        } else {
            this.start = true;
            // startButton loeschen, falls mit esc gestartet wurde
            //fenster.remove(startButton);
            //this.startButton = null;
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        //System.out.println("groesse geaendert");
        //((Panel) this.panel).fensterGroesseAendern(this.fenster);

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentShown(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub

    }
}
