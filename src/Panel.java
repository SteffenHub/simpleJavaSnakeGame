import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Panel extends JPanel {

    // ieine serien nummer
    private static final long serialVersionUID = 6503846234122328453L;
    // anzahl Raster Horizontal
    private final int gridHoehe;
    // anzahl Raster Vertikal
    private final int gridBreite;
    // aktuelle hoehe des Fensters
    private final int fensterHoehe;
    // aktuelle Breite des Fensters
    private final int fensterBreite;
    // dies position des Essens
    private Position essenPos;
    // positionen der Snake
    private ArrayList<Position> snakePos;
    //Platz an den seiten des Spielfeldes
    private final int seitenPlatz;
    private int abstandVertikal;
    private int abstandHorizontal;

    /**
     * Konstruktor des Panels
     * 
     * @param hoehe          anzahl der horizontalen Striche im Grid
     * @param breite         anzahl der vertikalen Striche im Grid
     * @param fensterGroesse eingeben mit fenster.getSize()
     */
    public Panel(int hoehe, int breite, JFrame fenster, Position essenPos, ArrayList<Position> snakePos,int fensterBreite, int fensterHoehe) {
        this.gridBreite = breite;
        this.gridHoehe = hoehe;
        this.fensterBreite = fensterBreite;
        this.fensterHoehe = fensterHoehe;
        this.essenPos = essenPos;
        this.snakePos = snakePos;
        this.seitenPlatz = 20;
        this.abstandVertikal = (fensterBreite-(seitenPlatz*2)) / gridBreite;
        this.abstandHorizontal = (fensterHoehe-seitenPlatz*2)/ gridHoehe;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        // das Grid zeichnen
        drawGrid(g);
        // das Essen zeichnen
        drawEat(g);
        // die Snake zeichnen
        drawSnake(g);
    }

    /**
     * Zeichnet das Raster mit g.drawLine 
     * 
     * @param g
     */
    private void drawGrid(Graphics g){
        //Vertikale Linien
        for(int x = seitenPlatz; x < fensterBreite; x += abstandVertikal){
            g.drawLine(x,
                        seitenPlatz,
                        x,
                        fensterHoehe-seitenPlatz);
        }
        //Horizontale Linen
        for(int x = seitenPlatz; x <fensterHoehe; x += abstandHorizontal){
            g.drawLine(seitenPlatz,
                        x,
                        fensterBreite-seitenPlatz,
                        x);
        }
    }

    private void drawEat(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(this.essenPos.getY() * abstandVertikal +seitenPlatz+3,
                    this.essenPos.getX() *abstandHorizontal +seitenPlatz+3,
                    fensterBreite / gridBreite -7,
                    fensterHoehe/ gridHoehe -7);
    }

    private void drawSnake(Graphics g){
        g.setColor(Color.GREEN);
        for(int i = 0; i < snakePos.size()-1; i++){
            g.fillRect((snakePos.get(i).getY() * abstandVertikal) +seitenPlatz+3,
                        (snakePos.get(i).getX() * abstandHorizontal) +seitenPlatz+3,
                        fensterBreite / gridBreite -7,
                        fensterHoehe/ gridHoehe -7);
        }
        g.setColor(Color.MAGENTA);
        g.fillRect(snakePos.get(snakePos.size()-1).getY()*abstandVertikal+seitenPlatz+3,
                    snakePos.get(snakePos.size()-1).getX()*abstandHorizontal+seitenPlatz+3,
                    fensterBreite / gridBreite -7,
                    fensterHoehe/ gridHoehe -7);
    }

    /**
     * Die Komponenten werden beim veraendern der Fenster groesse angepasst
     * 
     * @param fenster
     */
    public void fensterGroesseAendern(JFrame fenster){
        //this.fensterBreite = (int)fenster.getSize().getWidth();
        //this.fensterBreite = (int)fenster.getSize().getHeight();
    }

    /**
     * setter fuer die Position des essens
     * 
     * @param essenPos
     */
    public void setEatPos(Position essenPos){
        this.essenPos = essenPos;
    }
}