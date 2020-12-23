import java.awt.*;
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

    /**
     * Konstruktor des Panels
     * 
     * @param hoehe anzahl der horizontalen Striche im Grid
     * @param breite anzahl der vertikalen Striche im Grid
     * @param fensterGroesse eingeben mit fenster.getSize()
     */
    public Panel(int hoehe, int breite, Dimension fensterGroesse) {
        this.gridBreite = breite;
        this.gridHoehe = hoehe;
        this.fensterBreite = (int)fensterGroesse.getWidth();
        this.fensterHoehe = (int)fensterGroesse.getHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        drawGrid(g);
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
}

