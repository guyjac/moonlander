import java.awt.*;
import java.util.Random;


public class Platform {

    int x;
    int y;

    public Platform(){
        setup();
    }

    public void setup(){
        //generate random location for our platform, only on setup
        Random ran = new Random();
        x = ran.nextInt(740) + 10;
        y = ran.nextInt(100) + 550;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){

        //draw a platform of squares. randomly placed but always in unison
        Rectangle plat1 = new Rectangle(x,y,100,10);
        Rectangle plat2 = new Rectangle(x,y,10,40);
        Rectangle plat3 = new Rectangle(x+90,y,10,40);
        plat1.draw(g,Color.orange);
        plat2.draw(g,Color.yellow);
        plat3.draw(g,Color.yellow);
    }
}
