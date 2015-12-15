/**
 * Created by ethanmctiernan on 15/12/2015.
 */
import java.awt.*;
import java.awt.Point;
import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;

public class day3{

    static LinkedList<Point> whereSantasBeen = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        readInFile();
        System.out.println("Santa delivered at least one present to " + whereSantasBeen.size() + " houses" );
    }

    static void readInFile() throws IOException {
        Point startingLoc = new Point();
        startingLoc.setLocation(0, 0);
        whereSantasBeen.addLast(startingLoc);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("/Users/ethanmctiernan/Development/Advent_of_Code/day3/input.txt"), Charset.forName("UTF-8")));
        int c;
        Point lastLoc = startingLoc;
        while ((c = reader.read()) != -1) {
            Point santasLoc = new Point();
            char character = (char) c;
            if (character == 'v') {

                santasLoc.setLocation(lastLoc.getX(),lastLoc.getY()-1);
                lastLoc = santasLoc;
                if(!hasSantaBeenHere(santasLoc)) {
                    whereSantasBeen.add(santasLoc);
                }
            }if (character == '^') {
                santasLoc.setLocation(lastLoc.getX(),lastLoc.getY()+1);
                lastLoc = santasLoc;

                if(!hasSantaBeenHere(santasLoc)) {
                    whereSantasBeen.add(santasLoc);
                }
            }if (character == '>') {
                santasLoc.setLocation(lastLoc.getX()+1,lastLoc.getY());
                lastLoc = santasLoc;

                if(!hasSantaBeenHere(santasLoc)) {
                    whereSantasBeen.add(santasLoc);
                }
            }if (character == '<') {
                santasLoc.setLocation(lastLoc.getX()-1,lastLoc.getY());
                lastLoc = santasLoc;
                if(!hasSantaBeenHere(santasLoc)) {
                    whereSantasBeen.add(santasLoc);
                }
            }
        }

    }
    static boolean hasSantaBeenHere(Point santasLoc) {
        boolean toReturn = false;

        for (Point p : whereSantasBeen) {
            if(p.equals(santasLoc)) {toReturn = true; break;}
            else toReturn = false;
        }
        return toReturn;
    }

}

