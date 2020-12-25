import java.util.ArrayList;
import java.util.Random;
import java.awt.Dimension;

public class SpielFeld {
    
    //2 ist essen, 1 ist Snake, 0 ist leer
    private int[][] spielFeld;
    //anzahl an Feldern horizontal
    private final int hoehe;
    //anzahl an Feldern vertikal
    private final int breite;
    //die position des Essens
    private Position essenPos;
    //Speichert alle positionen auf der die Snake gerade ist
    private ArrayList<Position> snakePos;

    /**
     * Konstruktor des Spielfeldes
     * 
     * @param hoehe anzahl an Feldern horizontal
     * @param breite anzahl an Feldern vertikal
     */
    public SpielFeld(int hoehe,int breite){

        this.hoehe = hoehe;
        this.breite = breite;
        //spielfeld als 2-Dim-int-Array erstellen
        spielFeld = new int[hoehe][breite];
        //spielfeld mit 0-len fuellen
        for(int x = 0; x < hoehe; x++){
            for(int y = 0; y < breite; y++){
                spielFeld[x][y] = 0;
            } 
        }
        //Liste fuer die Snake erstellen und erste Postition festlegen
        snakePos = new ArrayList<>();
        spielFeld[1][1] = 1;
        snakePos.add(new Position(1,1));
        spielFeld[1][2] = 1;
        snakePos.add(new Position(1,2));
        spielFeld[1][3] = 1;
        snakePos.add(new Position(1,3));
        //zufaellige Pos fuer Essen suchen und in 2-Dim-Array einsetzen
        EssenRandomPlazieren();
        //Das aktuelle Feld in der Konsolle ausgeben
        FeldInKonsolleAusgeben();

    }

    /**
     * Gibt den aktuellen Zustand des Feldes in der Konsolle aus
     * 0 := Leer
     * 1 := Snake
     * 2 := Essen
     * 
     */
    private void FeldInKonsolleAusgeben(){
        for(int x = 0; x < hoehe; x++){
            for(int y = 0; y < breite; y++){
                System.out.print(spielFeld[x][y] +" ");
            } 
            System.out.println();
        }
    }

    /**
     * Berechnet eine Zufaellige Position auf dem Spielfeld 
     * und fuegt hier ein Essen(2) ein
     * Diese Position ist nicht bereits durch eine 1(Snake) besetzt
     * 
     */
    private void EssenRandomPlazieren(){
        boolean posGefunden = false;
        int x;
        int y;
        //Solange suchen bis freie Pos gefunden
        while(!posGefunden){
            Random ran = new Random();
            //Zahl 0 <= x < breite
            x = Math.abs(ran.nextInt()) % breite;
            //Zahl 0 <= y < hoehe
            y = Math.abs(ran.nextInt(hoehe)) % hoehe;
            if(spielFeld[y][x] != 1){
                posGefunden = true;
                //diese zufaellige position mit essen(2) fuellen
                spielFeld[y][x] = 2;
                essenPos = new Position(y,x);
            }
        }
    }

    /**
     * getter fuer breite
     * @return itn breite, anzahl an Feldern vertikal
     */
    public int getBreite(){
        return this.breite;
    }


    /**
     * getter fuer hoehe
     * @return itn hoehe, anzahl an Feldern horizontal
     */
    public int getHoehe(){
        return this.hoehe;
    }

    /**
     * getter fuer das Spielfeld
     * @return int[][] spielFeld, aktuellen Zustand als 2-Dim-int-Array
     */
    public int[][] getSpielFeld(){
        return this.spielFeld;
    }

    /**
     * getter fuer position des essens
     * @return Position essenPos, die position des essens als Dimension
     */
    public Position getEssenPos(){
        return this.essenPos;
    }

    /**
     * getter fuer Liste alle Positionen an der die Snake sich gerade befindet
     * 
     * @return ArrayList<Position>
     */
    public ArrayList<Position> getSnakePos(){
        return this.snakePos;
    }
}