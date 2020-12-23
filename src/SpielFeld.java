import java.util.Random;

public class SpielFeld {
    
    //2 ist essen, 1 ist Snake, 0 ist leer
    private int[][] spielFeld;
    private int hoehe;
    private int breite;


    public SpielFeld(int hoehe,int breite){

        this.hoehe = hoehe;
        this.breite = breite;
        //spielfeld als 2-Dim byte Array erstellen
        spielFeld = new int[hoehe][breite];
        //spielfeld mit 0-len fuellen
        for(int x = 0; x < hoehe; x++){
            for(int y = 0; y < breite; y++){
                spielFeld[x][y] = 0;
            } 
        }
        EssenRandomPlazieren();
        FeldInKonsolleAusgeben();

    }



    private void FeldInKonsolleAusgeben(){
        for(int x = 0; x < hoehe; x++){
            for(int y = 0; y < breite; y++){
                System.out.print(spielFeld[x][y] +" ");
            } 
            System.out.println();
        }
    }

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
        }
        }

    }

}
