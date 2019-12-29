import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
/** Scrabble scorer checks if the word that a user inputs is valid and then proceeeds to score the words using scrabble scoring
 * @author 21fernando
 * @version 11/19/2019
 */
public class ScrabbleScorer {
    private String alphabet;
    private int[] points = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    private ArrayList<String> dictionary;
    /**
     * Default constructor for the Scrabble Scorer object
     */
    public ScrabbleScorer(){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictionary = new ArrayList<String>();
    }
    /**
     * Build dictionary reads in the SCRABBLE_WORDS.txt file and populates the arrayList dictionary. This list is then sorted.
     */
    public void buildDictionary (){
        Scanner in = null;
        try{
            in = new Scanner( new File("SCRABBLE_WORDS.txt"));
            while(in.hasNext()){
                dictionary.add(in.nextLine());
            }
            in.close();
            Collections.sort(dictionary);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * isValidWord Checks if a word is in the dictionary
     * @param word the word that is being checked
     * @return boolean expressing the validity of the word
     */
    public boolean isValidWord(String word){
        return Collections.binarySearch(dictionary, word) >= 0;
    }
    /**
     * getWordScore checks the score of the word using the points array
     * @param word
     * @return an integer expressing the score of the word
     */
    public int getWordScore(String word){
        int score = 0;
        for (int i =0; i<word.length(); i++){
            score+= points[alphabet.indexOf(word.charAt(i))];
        }
        return score;
    }
    /**
     * Main method for the ScrabbleScorer class
     * @param args command line args if provided
     */
    public static void main(String[] args){
        ScrabbleScorer app = new ScrabbleScorer();
        app.buildDictionary();
        Scanner in = new Scanner(System.in);
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String ui = "0";
        do{
            System.out.print("Enter a word to score or 0 to quit: ");
            ui = in.nextLine();
            if (!ui.equals("0")){
                System.out.println((app.isValidWord(ui.toUpperCase()))? (ui + " = " + app.getWordScore(ui.toUpperCase()) + " points") : (ui + " is not a valid word in the dictionary"));
            }
        }while(!ui.equals("0"));
        System.out.println("Exiting the program thanks for playing");
    }
}