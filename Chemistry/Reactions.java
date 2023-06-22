import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
/**
 * @author Owen P. Desjardins
 * @version [6/17/2023]
 */
public class Reactions 
{
    // My Reaction handler to deal with all reactions.
    public Reactions()
    {

    }

    public static String checkReaction(String moleculeType1,String moleculeType2) {
        String newMoleculeType = "";
        if ((moleculeType1.equals("acid") && moleculeType2.equals("base"))||(moleculeType2.equals("acid") && moleculeType1.equals("base"))) {
            System.out.println("FIZZLE!");
            newMoleculeType = "water";
        } else if ((moleculeType1.equals("acid") && moleculeType2.equals("acid"))||(moleculeType1.equals("acid") && moleculeType2.equals("water"))||(moleculeType1.equals("water") && moleculeType2.equals("acid"))) {
            newMoleculeType = "acid";
        } else if (moleculeType1.equals("base") && moleculeType2.equals("base")||(moleculeType1.equals("base") && moleculeType2.equals("water"))||(moleculeType1.equals("water") && moleculeType2.equals("base"))) {
            newMoleculeType = "base";
        } else if (moleculeType1.equals("water") && moleculeType2.equals("water")) {
            newMoleculeType = "water";
        } 
        return newMoleculeType;
    }

    public static String moleculeName(String type) {
        Path path = Paths.get("molecules/"+type+"s.txt");
        String name;
        try {
            long lines = Files.lines(path).count();
            int rand = (int) (Math.random()*lines);
            name = Files.readAllLines(path).get(rand);
        } catch (IOException e) {
            System.out.println("File not found");
            return null;
        }
        return name;
    }
}
