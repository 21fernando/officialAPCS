import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class ScrabbleRackManager {
    public ArrayList<String> words = new ArrayList<>();
    public ArrayList<String> rack = new ArrayList<>();
    /** class constructor */
    public ScrabbleRackManager() {
        Scanner in = null;
        try{
            in = new Scanner("2019_collins_scrabble.txt");
            while(in.hasNext()){
                words.add(in.nextLine().toLowerCase());
            }
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
    /** displays the contents of the player's tile rack */
    public void printRack(){

    }
    /** builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile
     * rack */
    public ArrayList<String> getPlaylist(){
        return words;
    }
    /** print all of the playable words based on the letters in the tile rack */
    public void printMatches(){

    }
    /** main method for the class; use only 3 command lines in main */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }


}
