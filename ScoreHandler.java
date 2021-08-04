import java.io.*;
import java.util.*;

public class ScoreHandler {


    public static String loadScores(){
        //Load all scores save in score.txt and return them as an STR
        //Catch exceptions
        String lscores = "";
        try
        {
            File file = new File("score.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                lscores += sc.nextLine() + "\n";
        }
        catch (FileNotFoundException e)
        {
            //e.printStackTrace();
            //Create score file if it doesn't exist
            createFile();
        }
        return lscores;
    }

    public static void createFile(){
        //If Load scores fails, create the file.
        File file = new File("score.txt");
        try
        {
            //creates a file if it cant be found
            file.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void writer( int score, String n){

        //loads the old scores into a string, then appends the new score to the end
        String oldscores = loadScores();

        //open the file and write to it. add the old scores + the new scores and the name
        File file = new File("score.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write( oldscores + n +":"+ score +":");
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String topten(){

        //wraps the string in HTML for a JLABEL

        String toptenstr = "<html><body style=\"background-color:BLACK;\"><br><center>TOP TEN SCORES<br>";

        //LOADS SCORES AND SEPERATES THEM INTO AN ARRAY BY SPACE. PRODUCES AAA,22,VVV,22 ETC
        String scores = loadScores();
        String lines[] = scores.split(":");

        /*
        * This is an insertion sort method, which goes every 2 elements
        * example array A=['a','2','b','5','c','6']
        * every Nth element is a score, thus n-1 is a name
        * we sort by comparing n elements and then also sorting n-1 given the sort
        */

        int n = lines.length;
        for (int i=3; i<n; i++)
        {
            int key = Integer.parseInt(lines[i]);
            String keyname = lines[i-1];
            int scoreBefore = i-2;

            while (scoreBefore>=0 && Integer.parseInt(lines[scoreBefore]) < key)
            {
                lines[scoreBefore+2] = lines[scoreBefore];
                lines[scoreBefore+1] = lines[scoreBefore-1];
                scoreBefore = scoreBefore-2;
            }
            lines[scoreBefore+2] = Integer.toString(key);
            lines[scoreBefore+1] = keyname;
            i++;
        }

        int counter = 0;
        //print the top 10, break if we have 10 scores . add scores to string
        //wrap with html for our jlabel
        for (int i=0; i<lines.length-1; i++) {
            toptenstr += lines[i]+" "+lines[i+1] + "<br>";
            counter++;

            if(counter==10) {
                break;
            }
            i++;
        }

        toptenstr += "<br>LEFT CLICK TO START</html>";

        return toptenstr;
    }

}
