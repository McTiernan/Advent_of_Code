/**
 * Created by ethanmctiernan on 15/12/2015.
 */
import java.awt.*;
import java.awt.Point;
import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Scanner;

public class day3{

    static LinkedList<Point> whereSantasBeen = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        System.out.println("Would you like to solve puzzle 1 or 2? Answer with the puzzle number.");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        readInFile(answer);
        System.out.println("Santa delivered at least one present to: " + whereSantasBeen.size() + " houses" );
        //System.out.println(whereSantasBeen);
    }

    static void readInFile(int puzzle) throws IOException {
        Point startingLoc = new Point();
        startingLoc.setLocation(0, 0);
        //System.out.println("santasLoc first = " + santasLoc);
        whereSantasBeen.addLast(startingLoc);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("/Users/ethanmctiernan/Development/Advent_of_Code/day3/input.txt"), Charset.forName("UTF-8")));
        int c;
        Point santaslastLoc = startingLoc;
        Point roboslastLoc = startingLoc;
        int count = 1;
        while ((c = reader.read()) != -1) {
            Point lastLoc;
            if(count%2!=0&&puzzle==2){
                lastLoc=roboslastLoc;
            }
            else lastLoc = santaslastLoc;
            Point santasLoc = new Point();
            char character = (char) c;
            if (character == 'v') {

                santasLoc.setLocation(lastLoc.getX(), lastLoc.getY() - 1);
                lastLoc = santasLoc;
                //System.out.println(santasLoc.getX() + " " + santasLoc.getY());
                if (!hasSantaBeenHere(santasLoc)) {
                    whereSantasBeen.add(santasLoc);
                }
            }
            if (character == '^') {
                santasLoc.setLocation(lastLoc.getX(), lastLoc.getY() + 1);
                lastLoc = santasLoc;

                if (!hasSantaBeenHere(santasLoc)) {
                    whereSantasBeen.add(santasLoc);
                }
            }
            if (character == '>') {
                santasLoc.setLocation(lastLoc.getX() + 1, lastLoc.getY());
                lastLoc = santasLoc;

                if (!hasSantaBeenHere(santasLoc)) {
                    whereSantasBeen.add(santasLoc);
                }
            }
            if (character == '<') {
                santasLoc.setLocation(lastLoc.getX() - 1, lastLoc.getY());
                lastLoc = santasLoc;
                if (!hasSantaBeenHere(santasLoc)) {
                    whereSantasBeen.add(santasLoc);
                }
            }
            if(count%2!=0&&puzzle==2){
                roboslastLoc=lastLoc;
            }
            else santaslastLoc = lastLoc;
            count++;
        }

    }
    static boolean hasSantaBeenHere(Point santasLoc) {
        boolean toReturn = false;

        for (Point p : whereSantasBeen) {
            //System.out.println(" p  = " + p +" santasLoc: "  + santasLoc);
            if(p.equals(santasLoc)) {toReturn = true; break;}
            else toReturn = false;
        }
        //System.out.println("toReturn = " + toReturn);
        return toReturn;
    }

}

