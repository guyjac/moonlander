import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    Game thisob;

    //we parse the jframe object so we can call THIS. upon its objects
    MyMouseListener(Game givenOb){
        thisob = givenOb;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        thisob.playing=true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

