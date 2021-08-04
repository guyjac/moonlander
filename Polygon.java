import java.awt.*;

public class Polygon extends Shape {



    public Polygon(int x1,int x2,int x3, int y1,int y2,int y3){
        super(x1,x2,x3,y1,y2,y3);
        //first three numbers are x points
        //second three numbers are y points
        //these are passed into an array of integers which are returned. as Xpoints and Ypoints
    }

    public void move(){

        //Loop through all polygon X points to move horizontally across screen
        for (int i=0;i<xPoints.length;i++){

            //Check if the star has gone off the screen.. if it has:
            if(this.xPoints[i]>820)
            {
                //Moves the star back to the start (x=0) if it goes off screen
                for(int e=0; e < xPoints.length;e++)
                {
                    xPoints[e]-=800;
                }
            }
            //moves across screen
            this.xPoints[i] += 5;
            }

    }

    public void draw(Graphics g, Color r)
    {
        //creates and draws the shape given the arrays
        g.setColor(r);
        g.fillPolygon (this.xPoints, this.yPoints, 3);
    }
}
