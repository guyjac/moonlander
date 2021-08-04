import java.awt.*;
import java.awt.image.ImageObserver;

public class Square extends Shape{

    public Square(Integer side, Integer x, Integer y){
        super(x,y,side,side);
        this.x = x;
        this.y = y;
        this.xl = side;
        this.yl = side;
    }
    public void drawImg(Graphics g, Image img1, ImageObserver ob){
        //draws an image over the shape.
        g.drawImage(img1,this.x,this.y,ob);
    }
    public void draw(Graphics g, Color r)
    {
        //creates and draws the shape
        g.setColor(r);
        g.fillRect(this.x, this.y, this.xl, this.xl);
    }
}