import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {

    //Labels used for text
    JFrame frame = new JFrame("Lunar Lander - Student 1702267");
    JLabel fuel = new JLabel("LEFT CLICK TO START");

    //Create our objects. Stars is a class which draws multiple stars. Platform is a class that stores an arrangement of shapes
    SpaceShip bowie = new SpaceShip(385,-40,15,40,false);
    Platform plat = new Platform();
    Stars star = new Stars();

    //Create our jpanel
    JPanel jPan1 = init();

    //Boolean used to pause the game but allow clock to continue.. good for click events
    boolean playing = false;

    public static void main(String[] args) {
        //Create our object of the program
        Game program1 = new Game();
    }

    public JPanel init(){
        //Creates our jpanel and draws various objects. BG is used to load a backing image.

        Square bg = new Square(800,0,0);
        Circle moon = new Circle(80,80,50);

        JPanel jPan1 = new JPanel() {
            public void paintComponent(Graphics g) {
                bg.draw(g,Color.black);
                bg.drawImg(g,Toolkit.getDefaultToolkit().getImage("bg.png"),this);

                plat.draw(g);
                moon.draw(g,Color.orange);
                bowie.draw(g, Color.red);
                star.draw(g,Color.white);

            }
        };

        //Set focusable so our listeners work. add mouse and kb listener to the frame
        jPan1.setFocusable(true);
        KeyListener listener = new MyKeyListener(this);
        MouseListener listenerm = new MyMouseListener(this);
        jPan1.addKeyListener(listener);
        jPan1.addMouseListener(listenerm);

        return jPan1;
    }

    public Game()
    {
        //Constructor
        createWindow();
        timer.start();
    }


    public void createWindow() {

        //Method is responsible for creating the window of the program
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jPan1, BorderLayout.CENTER);
        //adds our Label at the top of the program, shows fuel count and scoreboard
        jPan1.add(fuel);
        fuel.setForeground(Color.white);
        fuel.setFont(new Font("Consolas", Font.BOLD, 15));
        frame.setVisible(true);
        frame.pack();
    }

    Timer timer = new Timer(20, new ActionListener() {
        //Clock used to cycle our methods and redraw.
        public void actionPerformed(ActionEvent evt) {
            if(playing) {
                updateShip();
                frame.repaint();
                checkCollision();
                checkWin();
            }
        }
    });

    public void updateShip()
    {
            //this is our tick update, perform thrust, banks and gravity. check for fuel
            bowie.thrust();
            bowie.bank();
            fuel.setText("Fuel: " + bowie.fuel);

            //gravity gets more intense per cycle
            bowie.gravity+=0.09;
            //make the gravity act on bowie.
            bowie.move(null, bowie.y + (int)Math.round(bowie.gravity));

            //move our test stars
            star.move();
    }


    public void checkCollision()
    {

        for(int i=0; i<star.stararr.length;i++){
            //assign the X coords to vars. these are star coords
            int x1 = star.stararr[i].xPoints[0];
            int x2 = star.stararr[i].xPoints[1];
            int x3 = star.stararr[i].xPoints[2];

            int y1 = star.stararr[i].yPoints[0];
            int y2 = star.stararr[i].yPoints[1];
            int y3 = star.stararr[i].yPoints[2];

            //find the biggest X and Y
            int bigX = Math.max(Math.max(x1, x2), x3);
            int smallX = Math.min(Math.min(x1, x2), x3);
            int bigY = Math.max(Math.max(y1, y2), y3);
            int smallY = Math.min(Math.min(y1, y2), y3);

            //if Bowie is within X and Y range of a triangle, hes been hit by a star
            if(( bowie.x < bigX && bowie.x > smallX) && (bowie.y < bigY && bowie.y > smallY)){
               end(false);
            }
        }
    }

    public void checkWin(){

        //If we are lower than the platform then we can deduce bowie has landed or died
        if (bowie.y+bowie.yl >= plat.y)
        {
            //if he is within the platform range and size. If the gravity is too high he is travelling too fast and dies
            if ( (bowie.x >= plat.x) && (bowie.x <= plat.x+100)&& bowie.gravity<3.5){
                end(true);
            }
            else{
                //if he is out of the X range, hes dead
                end(false);
            }
        }
    }

    public void restart(){
        //Playing boolean is set to false, which stops the timer ticking the updateship method, thus effectively pausing gameplay
        playing=false;
        //Reset all objects to their default state, or move them to new locations
        bowie.setup(385,-40,15,40);
        //Reset directions, thrust and gravity etc as this can go weird otherwise
        bowie.direction=0;
        bowie.gravity=0.0;
        bowie.burst=0.0;
        bowie.engine=false;
        bowie.fuel=150;
        //randomise our playing environment
        plat.setup();
        star.setup();
        frame.repaint();
    }

    public void end(boolean win){
        //You lost
        String name = "";
        int score = 0;

        if(win){
            //record fuel as score
            name = (String)JOptionPane.showInputDialog(frame, "Enter your name:","Successful landing", JOptionPane.INFORMATION_MESSAGE);
            score =bowie.fuel;
        }
        if(!win) {
            //Record score of 0 as you lost. and Load the scores
            name = (String)JOptionPane.showInputDialog(frame, "Enter your name", "You crashed!", JOptionPane.INFORMATION_MESSAGE);
        }

        //Check if cancel is pressed. we cant check for null, so we check for NOT NULL, then else
        if (Checknull.nullcheck(name))
            name = "aaa";

        ScoreHandler.writer(score, name);
        fuel.setText(ScoreHandler.topten());
        restart();
    }

}














