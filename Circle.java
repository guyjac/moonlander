import java.awt.*;

public class Circle extends Shape {
    /*
    X is X Coords
    Y is Y Coords
    */

    Integer radius;

    public Circle(Integer x, Integer y, Integer radius)

    {
        super(x,y,radius,radius);
        this.radius = radius;
    }

    public void setRadius(Integer r)
    {
        this.radius = r;
    }

    public void move(Integer x,Integer y)
    {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g, Color r)
    {
        //paint circle
        g.setColor(r);
        g.fillOval(this.x, this.y, this.radius, this.radius);
    }
}