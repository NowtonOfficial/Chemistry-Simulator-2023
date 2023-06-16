/**
 * @author Owen P. Desjardins
 * @version [6/12/2023]
 */
public class Reactions  
{

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
        } 
        return newMoleculeType;
    }
}
