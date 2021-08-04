import java.awt.*;
import java.awt.geom.Arc2D;

public class Pie extends Shape {
    /*
    X is X Coords
    Y is Y Coords
    XL is X length
    YL is Y Length
    */

        Integer angS,angE;

        public Pie(Integer x, Integer y, Integer xl, Integer yl,Integer angS,Integer angE)

        {
            super(x,y,xl,yl);
            this.angS = angS;
            this.angE = angE;

        }

        public void move(Integer x,Integer y)
        {
            this.x = x;
            this.y = y;
        }

        public void draw(Graphics g, Color r)
        {
            Graphics2D g2 = (Graphics2D) g;
            //paint circle
            Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
            arc.setFrame(this.x, this.y, this.xl, this.yl);
            arc.setAngleStart(angS);
            arc.setAngleExtent(angE);
            g2.setColor(r);
            g2.draw(arc);
            g2.fill(arc);

    }
}
