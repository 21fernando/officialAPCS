import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * add blank tiles
 */
public class BoringScrabbleRackManager {
    public ArrayList<String> scrabbleWords;
    public ArrayList<String> rack;
    public String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** class constructor */
    public BoringScrabbleRackManager() {
        rack = new ArrayList<>();
        scrabbleWords = new ArrayList<>();
        int[] frequencies = new int[]{9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
        ArrayList<String> allTiles = new ArrayList<>();
        int index = 0;
        for (int count: frequencies){
            for (int i =0; i<count; i++){
                allTiles.add(alphabet.substring(index, index+1));
            }
            index ++;
        }
        Collections.shuffle(allTiles);

        for (int i = 0; i < 7; i++) {
            rack.add(allTiles.remove((int)(Math.random()*allTiles.size())));
        }
        rack.set(0,"N");
        rack.set(1,"A");
        rack.set(2,"O");
        rack.set(3,"T");
        rack.set(4,"M");
        rack.set(5,"U");
        rack.set(6,"S");
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
    }
    /** displays the contents of the player's tile rack */
    public void printRack(){
        System.out.println("Letters in the rack: "  + rack);
    }

    private ArrayList<String> getPermutations(int length, ArrayList<String> letters){
        ArrayList<String> permutations = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        if (length ==1 ){
            return letters;
        }
        for(int i =0; i<letters.size(); i++){
            temp = (ArrayList<String>)(letters.clone()); // http://www.java2novice.com/java-collections-and-util/arraylist/copy-clone/
            temp.remove(i);
            String letter = letters.get(i);
            for(String p: getPermutations(length-1, temp)){
                if(!permutations.contains(letter+p))permutations.add(letter+p);
            }

        }
        return permutations;
    }

    /** builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile
     * rack */
    public ArrayList<String> getPlaylist(){
        ArrayList<String> playable = new ArrayList<>();
        int[] value = new int[26];
        boolean valid;
        for(String r: rack){
            value[alphabet.indexOf(r)]+=1;
        }
        int [] temp;
        for( String word: scrabbleWords){
            temp = value.clone();
            for(int i =0; i< word.length(); i++){
                temp[alphabet.indexOf(word.substring(i,i+1))]-=1;
            }
            valid = true;
            for (int i = 0; i <26 && valid ; i++) {
                if(temp[i]<0){
                    valid = false;
                }
            }
            if(valid){
                playable.add(word);
            }
        }
        return playable;
    }

    public ArrayList<String> getPermutationsPlaylist(){
        ArrayList<String> playable = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            for(String possible: getPermutations(i,rack)){
                if(Collections.binarySearch(scrabbleWords,possible)>-1) playable.add(possible);
            }
        }
        return playable;
    }


    /** print all of the playable words based on the letters in the tile rack */
    public void printMatches(){
        //System.out.println(getPlaylist().size() + " linear size");
        //System.out.println(getPermutationsPlaylist().size() + "perm size");
        ArrayList<String> words = getPlaylist();
        System.out.println(words);
        System.out.println(words.size());
        /*System.out.println("You can play the following words from the letters in your rack: ");
        if(words.size() == 0){
            System.out.println("Sorry, NO words can be played from those tiles.");
        }else{
            int i =1;
            String word;
            while(i<words.size()){
                word = words.get(i);
                if(word.length() == 7){
                    word = word + "*";
                }
                System.out.print(word);
                for(int s = 0; s< 12-word.length(); s++){
                    System.out.print(" ");
                }
                if(i%10==0){
                    System.out.println();
                }
                i++;
            }
        }*/
        System.out.println("* denotes bingo");
    }

    private boolean binarySearch(String word){
        int low = 0;
        int high = scrabbleWords.size()-1;
        int middle;
        while (low<=high){
            middle = (low+high)/2;
            if(compareWithBlanks(word, scrabbleWords.get(middle)) == 0){return true;}
            else if(compareWithBlanks(word,scrabbleWords.get(middle)) < 0){
                low = middle+1;
            }
            else{
                high = middle-1;
            }
        }
        return false;
    }
    public int compareWithBlanks(String s1, String s2){
        if(s1.length() != s2.length()){return s1.compareTo(s2);}
        else {
            int differentChars = 0;
            char[] p1 = s1.toCharArray();
            char[] p2 = s2.toCharArray();
            for (int i = 0; i < p1.length; i++) {
                if(p1[i] != p2[i]){
                    differentChars--;
                }
            }
            int numblanks = 0;
            for (int i = 0; i < s1.length(); i++) {
                if(s1.substring(i,i+1).equals(" ")){numblanks +=1;}
            }
            if(differentChars+numblanks>= 0){return 0;}
            return s1.compareTo(s2);
        }
    }
    /** main method for the class; use only 3 command lines in main */
    public static void main(String[] args){
        long tick = System.nanoTime();
        BoringScrabbleRackManager app = new BoringScrabbleRackManager();
        app.printRack();
        app.printMatches();
        long tock = System.nanoTime();
        System.out.println(tock - tick);
        //System.out.println(app.getPermutations(3, app.rack));
    }


}
