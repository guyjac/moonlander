import java.awt.*;
import java.util.Random;

public class Stars {

    Polygon stararr[];
    int x;
    int y;

    public Stars(){
        setup();
    }

    public void setup(){

        //sets up several polygons, which create stars
        Random ran = new Random();
        x = ran.nextInt(500);
        y = ran.nextInt(500);

        //must be multiples of 3, as 3 polygons make a triangle!!!
        this.stararr = new Polygon[5*3];

        //generates a random number, and then subtracts it from the X and Y of the triangle. this creates random triangles on X and Y coords!
        //i++ after every line as we want to place objects at 1,2,3 not 1,1,1 with for incrementer
        for(int i=0; i<stararr.length;i++){
            x = ran.nextInt(500);
            y = ran.nextInt(500);
            stararr[i] = new Polygon(11+x,55+x, 21+x,52+y, 20+y, 20+y);i++;
            stararr[i] = new Polygon(27+x,0+x, 55+x,40+y, 20+y, 20+y);i++;
            stararr[i] = new Polygon(17+x, 27+x, 45+x,32+y, 0+y, 52+y);
        }

    }

    public void move(){
        //invokes the polygon move method for every star object on screen
        for(int i=0; i<stararr.length;i++){
           stararr[i].move();
        }
    }

    public void draw(Graphics g,Color c){
        //draws all the stars in my array.
        for(int i=0; i<stararr.length;i++){
            stararr[i].draw(g,c);
        }
    }

}
