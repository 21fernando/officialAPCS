import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * This program creates a doubly randomized scrabble rack and then finds all of the words that can be played from it.
 * @author 21fernando
 * @version 1/21/2020
 */
public class ScrabbleRackManager {
    public ArrayList<String> scrabbleWords;
    public ArrayList<String> rack;
    public String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    public int[] rackCounts;
    /** default class constructor */
    public ScrabbleRackManager() {
        scrabbleWords = new ArrayList<>();
        buildRack();
        Scanner in = null;
        try{
            in = new Scanner(new File("2019_collins_scrabble.txt"));
            while(in.hasNext()){
                String next = in.nextLine();
                if(next.length()<=7) {
                    scrabbleWords.add(next);
                }
            }
            in.close();
        }catch(Exception e ){
            e.printStackTrace();
        }
        Collections.sort(scrabbleWords);
    }
    //helper method that builds the tile rack
    private void buildRack(){
        rackCounts= new int[27];
        rack = new ArrayList<>();
        int[] frequencies = new int[]{9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2};
        ArrayList<String> allTiles = new ArrayList<>();
        //loading up the allTiles ArrayList<String>
        int index = 0;
        for (int count: frequencies){
            for (int i =0; i<count; i++){
                allTiles.add(alphabet.substring(index, index+1));
            }
            index ++;
        }
        //doubly random selection
        Collections.shuffle(allTiles);
        for (int i = 0; i < 7; i++) {
            rack.add(allTiles.remove((int)(Math.random()*allTiles.size())));
        }
        //counting and storing number of occurences of each letter in the rack in rack counts
        for(String r: rack){
            rackCounts[alphabet.indexOf(r)]+=1;
        }
    }
    /** displays the contents of the player's tile rack */
    public void printRack(){
        System.out.println("Letters in the rack: "  + rack);
    }
    /** builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile rack
     * @return an ArrayList<String> of all the playable words*/
    public ArrayList<String> getPlaylist(){
        ArrayList<String> playable = new ArrayList<>();
        int[] wordCounts;
        int differences;
        for( String word: scrabbleWords){
            differences = 0;
            wordCounts = new int[27];
            for(int i =0; i< word.length(); i++){
                wordCounts[alphabet.indexOf(word.substring(i,i+1))]+=1;
            }
            for (int i = 0; i <27; i++) {
                differences += (rackCounts[i]>=wordCounts[i])? 0:wordCounts[i]-rackCounts[i] ;
            }
            if(differences<=rackCounts[ 26]){
                playable.add(word);
            }
        }
        return playable;
    }
    /** prints all of the playable words based on the letters in the tile rack*/
    public void printMatches(){
        ArrayList<String> words = getPlaylist();
        System.out.println("You can play the following words from the letters in your rack: ");
        if(words.size() == 0){
            System.out.println("Sorry, NO words can be played from those tiles.");
        }else{
            int i =1;
            String word;
            while(i<words.size()){
                word = words.get(i);
                System.out.printf("%-12s", (word.length()==7 )? word+"*": word); // Credit to griffin for this line
                if(i%10==0){ System.out.println(); }
                i++;
            }
        }
        System.out.println();
        System.out.println("* denotes bingo");
        System.out.println(words.size());
    }
    /**main method for this program
     * @param args command line arguments if necessary*/
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
        app.getPlaylist();
    }
}
/* very cool recursive permutation finding algorithm I tried but proved to be slower than the linear search through the dictionary approach
takes letters and length as a parameters
private ArrayList<String> getPermutations(int length, ArrayList<String> letters){
        ArrayList<String> permutations = new ArrayList<>();
        ArrayList<String> temp;
        if (length ==1 ){
            return letters;
        }
        for(int i =0; i<letters.size(); i++){
            temp = (ArrayList<String>)(letters.clone()); // http://www.java2novice.com/java-collections-and-util/arraylist/copy-clone/
            temp.remove(i);
            String letter = letters.get(i);
            for(String p: getPermutations(length-1, temp)){
                if(!permutations.contains(letter+p)){
                    permutations.add(letter+p);
                }
            }

        }
        return permutations;
    }
 */
