import java.awt.*;
import java.awt.image.ImageObserver;

public class Rectangle extends Shape {

    /*
    X is X Coords
    Y is Y Coords
    XL is X length
    YL is Y Length
    */

    public Rectangle(Integer x, Integer y, Integer xl, Integer yl){
        //calls super to shape
        super(x,y,xl,yl);
    }

    public void setup(Integer x, Integer y, Integer xl, Integer yl ){
        this.x = x;
        this.y = y;
        this.xl = xl;
        this.yl = yl;
    }

    public void draw(Graphics g, Color r)
    {
        //creates and draws the shape
        g.setColor(r);
        g.fillRect(this.x, this.y, this.xl, this.yl);
    }
    public void drawImg(Graphics g, Image img1, ImageObserver ob){
        //draws an image over the shape.
        g.drawImage(img1,this.x,this.y,ob);
    }
}
