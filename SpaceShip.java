import java.awt.*;
import java.awt.geom.Arc2D;


public class SpaceShip extends Shape{

    //essentially a square class, but modified.

    boolean engine=false;
    int direction;

    Integer fuel=150;
    Double gravity = 0.0;
    Double burst = 0.0;

    public SpaceShip(Integer x, Integer y, Integer xl, Integer yl,boolean engine){
        //calls super to shape
        super(x,y,xl,yl);
        this.engine = engine;
    }

    public void setup(Integer x, Integer y, Integer xl, Integer yl ){
        this.x = x;
        this.y = y;
        this.xl = xl;
        this.yl = yl;
    }

    public void move(Integer x,Integer y)
    {
        //we can pass null if we dont want to change the values.
        if(x!=null)
            this.x = x;
        if(y!=null)
            this.y = y;
    }

    public void thrust(){

        if(!engine){
            //If we are not using the engine, slowly release momentum
            if(this.burst<0)
                this.y +=(int)Math.round(this.burst+=0.3);
        }

        //If boolean engine is on we thrust and decrement fuel
        if(engine) {
            if (this.fuel > 0) {
                this.engine = true;
                this.fuel--;

                //We slowly increase the amount of thrust
                this.y += (int)Math.round(this.burst);
                this.burst-=0.2;

                //And decrease gravity unless its less than 0
                if(gravity>0)
                    this.gravity-=0.4;
            }
        }

    }

    public void bank(){
        //currently I am letting the ship turn with no fuel
        //bank left or right depending on 1 or 2
            if (direction == 1 && fuel>0) {
                //turn right
                this.x -= 5;
                this.fuel--;
            }
            if (direction == 2 && fuel>0) {
                //turn left
                this.x += 5;
                this.fuel--;
            }
    }

    public void draw(Graphics g, Color r){

        Pie wings = new Pie(this.x-13,this.y,40,this.yl,0,180);
        Rectangle ship = new Rectangle(this.x, this.y, this.xl, this.yl);
        Polygon nose = new Polygon(this.x,this.x+this.xl,this.x+(this.xl/2),this.y,this.y,this.y-15);

        wings.draw(g,Color.orange);
        ship.draw(g,r);
        nose.draw(g,Color.orange);

    }
}
