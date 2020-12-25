import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Panel extends JPanel {

    //anzahl Raster Horizontal
    int gridHoehe;
    //anzahl Raster Vertikal
    int gridBreite;
    //aktuelle hoehe des Fensters
    int fensterHoehe;
    //aktuelle Breite des Fensters
    int fensterBreite;
    //dies position des Essens
    Position essenPos;
    //positionen der Snake
    ArrayList<Position> snakePos;

    /**
     * Konstruktor des Panels
     * 
     * @param hoehe anzahl der horizontalen Striche im Grid
     * @param breite anzahl der vertikalen Striche im Grid
     * @param fensterGroesse eingeben mit fenster.getSize()
     */
    public Panel(int hoehe, int breite, Dimension fensterGroesse,Position essenPos,ArrayList<Position> snakePos) {
        this.gridBreite = breite;
        this.gridHoehe = hoehe;
        this.fensterBreite = (int)fensterGroesse.getWidth();
        this.fensterHoehe = (int)fensterGroesse.getHeight();
        this.essenPos = essenPos;
        this.snakePos = snakePos;
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
        int abstandVertikal = fensterBreite / gridBreite;
        for(int x = abstandVertikal; x < fensterBreite; x += abstandVertikal){
            g.drawLine(x, 0, x, fensterHoehe);
        }
        //Horizontale Linen
        int abstandHorizontal = fensterHoehe/ gridHoehe;
        for(int x = abstandHorizontal; x <fensterHoehe; x += abstandHorizontal){
            g.drawLine(0, x, fensterBreite, x);
        }
    }

    private void drawEat(Graphics g){

        int abstandVertikal = fensterBreite / gridBreite;
        int abstandHorizontal = fensterHoehe/ gridHoehe;

        g.setColor(Color.RED);

        g.fillRect(this.essenPos.getY() * abstandVertikal +2, this.essenPos.getX() *abstandHorizontal +2,
        fensterBreite / gridBreite -3, fensterHoehe/ gridHoehe -3);
    }

    private void drawSnake(Graphics g){
        g.setColor(Color.GREEN);
        int abstandVertikal = fensterBreite / gridBreite;
        int abstandHorizontal = fensterHoehe/ gridHoehe;

        for(int i = 0; i < snakePos.size(); i++){

            g.fillRect(snakePos.get(i).getY() * abstandVertikal +2, snakePos.get(i).getX() * abstandHorizontal +2,
            fensterBreite / gridBreite -3, fensterHoehe/ gridHoehe -3);

        }

    }


}