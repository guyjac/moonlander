abstract class Shape {

    Integer x;
    Integer xl;
    Integer y;
    Integer yl;
    int[] xPoints;
    int[] yPoints;

    public Shape(Integer x, Integer y, Integer xl, Integer yl) {
        this.x = x;
        this.xl = xl;
        this.y = y;
        this.yl = yl;
    }

    public Shape(int x1, int x2, int x3, int y1, int y2, int y3){
        int[] xPoints = {x1, x2, x3};
        int[] yPoints = {y1, y2, y3};
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }
}

