import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    Game thisob;

    //we parse the jframe object so we can call THIS. upon its objects

    MyKeyListener(Game givenOb){
        thisob = givenOb;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        if (KeyEvent.getKeyText(e.getKeyCode())=="Up")
        {
            //set the bool true for the thrust method
            thisob.bowie.engine=true;
        }
        if (KeyEvent.getKeyText(e.getKeyCode())=="Left")
        {
            //bank left
            thisob.bowie.direction=1;
        }
        if (KeyEvent.getKeyText(e.getKeyCode())=="Right")
        {
            //bank right
            thisob.bowie.direction=2;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //used to release the keys imminently
        if (KeyEvent.getKeyText(e.getKeyCode())=="Up")
        {
            thisob.bowie.engine=false;
        }
        if (KeyEvent.getKeyText(e.getKeyCode())=="Left")
        {
            thisob.bowie.direction=0;
        }
        if (KeyEvent.getKeyText(e.getKeyCode())=="Right")
        {
            thisob.bowie.direction=0;
        }
    }
}