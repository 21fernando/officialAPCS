import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintStream;
/** SubWordFinder finds all the words in a given dictionary that are made up of two consecutive words. ex. baseball = base + ball
 * NOTE: this program both prints to the console and also to the text file subwordOutput.txt
 * EXTRA: Finds the top 10 most common Prefixes and prints how many they occur
 * @version 3/12/2019
 * @author 21fernando
 */
public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;
    private ArrayList<SubWord> subwords;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private ArrayList<String> prefixes;
    private ArrayList<Integer> prefixCount;
     /**
      * Default constructor for Sub Word Finder class
     */
    public SubWordFinder(){
        dictionary = new ArrayList<ArrayList<String>>(26);
        for (int i = 0; i < 26; i++) {
            dictionary.add(new ArrayList<String>());
        }
        subwords = new ArrayList<SubWord>();
        prefixes = new ArrayList<String>();
        prefixCount = new ArrayList<Integer>();
    }
    /**
     * Populate dictionary reads in the text file SCRABBLE_WORDS.txt and sorts places the words into the dictionary ArrayList in buckets in order.
     */
    public void populateDictionary(){
        Scanner in = null;
        try{
            in = new Scanner( new File("words_all_os.txt"));
            String word;
            int count = 0;
            while(in.hasNext()){
                 word = in.nextLine();
                 count++;
                dictionary.get(alphabet.indexOf(word.charAt(0))).add(word);
            }
            for(ArrayList<String> bucket : dictionary){
                Collections.sort(bucket);
            }
            in.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Iterates through the dictionary and determines if words are subwords or not
     * @return an ArrayList containing SubWord objects
     */
    public ArrayList<SubWord> getSubWords(){
        String word;
        String p1;
        String p2;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < dictionary.get(i).size(); j++) {
                word = dictionary.get(i).get(j);
                for (int k = 2; k < word.length()-1; k++) {
                    p1 = word.substring(0,k);
                    p2 = word.substring(k) ;
                    if(inDictionary(p1) && inDictionary(p2)) {
                        subwords.add(new SubWord(word, p1, p2));
                        addToList(p1);
                    }
                }
            }
        }
        return subwords;
    }
    /**
     * Utilizes a binary search to determine if a word is in the dictionary
     * @param word The item to be searched for in dictionary
     * @return true or false based on wheter or not the word is in the dictionary
     */
    public boolean inDictionary(String word){
        ArrayList<String> bucket = dictionary.get(alphabet.indexOf(word.charAt(0)));
        int low = 0;
        int high = bucket.size()-1;
        int middle;
        while (low<=high){
            middle = (low+high)/2;
            if(bucket.get(middle).equals(word)){return true;}
            else if(bucket.get(middle).compareTo(word)<0){
                low = middle+1;
            }
            else{
                high = middle-1;
            }
        }
        return false;
    }
    private void printToFile(ArrayList<SubWord> s){
        PrintStream ps = null;
        try{
            ps = new PrintStream("subwordOutput.txt");
            for(SubWord subword : s){
                ps.println(subword);
            }
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void addToList(String word){
        int index = Collections.binarySearch(prefixes, word);
        if (index>=0){
            prefixCount.set(index, prefixCount.get(index)+1);
        }else{
            prefixes.add(word);
            prefixCount.add(1);
        }
    }
    /**
     * Main method for this program
     * @param args comman line arguments if provided
     */
    public static void main(String[] args){
        SubWordFinder app = new SubWordFinder();
        app.populateDictionary();
        for(SubWord subword : app.getSubWords()){
            System.out.println(subword);
        }
        app.printToFile(app.subwords);
        //prints the top 10 prefixes
        int[] maxes = new int[10];
        String[] words = new String[10];
        int index;
        int max;
        for (int i= 0; i<10; i++){
            index = 0;
            max = 0;
            for (int j = 0; j < app.prefixes.size(); j++) {
                if (app.prefixCount.get(j) >max){
                    index = j;
                    max = app.prefixCount.get(j);
                }
            }
            maxes[i] = app.prefixCount.get(index);
            words[i] = app.prefixes.get(index);
            app.prefixCount.remove(index);
            app.prefixes.remove(index);
        }
        System.out.println("===========================\n" +
                "The top ten prefixes are...\n"+
                "===========================");
        for (int i = 0; i < 10; i++) {
            System.out.println("" + (i+1) + ". " +  words[i] + "- occuring "  + maxes[i] + " times.");
        }
    }
}
