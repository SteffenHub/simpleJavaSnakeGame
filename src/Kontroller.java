import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Kontroller implements KeyListener {

    Field field;

    public Kontroller(Field field){
       this.field = field;
       //dem fenster diesen keyListener hinzufuegen
       field.getFenster().addKeyListener(this);
    }

    /**
	 * This method will be called, after a key was typed. This means, that the key
	 * was pressed and released, before this method get called.
	 * 
	 * @param e The key event
	 */
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
	 * This method will be called, after a key was pressed down.
	 * 
	 * @param e The key event
	 */
    @Override
    public void keyPressed(KeyEvent e) {      
        //rechts
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            field.getSpielFeld().setRichtung(1);
        }
        //links
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            field.getSpielFeld().setRichtung(-1);
        }
        //oben
        if(e.getKeyCode() == KeyEvent.VK_UP){
            field.getSpielFeld().setRichtung(2);
        }
        //unten
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            field.getSpielFeld().setRichtung(-2);
        }
    }

    /**
	 * This method will be called, after a key was released.
	 * 
	 * @param e The key event
	 */
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}