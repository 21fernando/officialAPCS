import java.util.Scanner;
import java.io.File;
/**
 * This program imports a text file containing ISBN numbers and checks if they are valid or invalid
 * @author 21fernando
 * @version 11/14/2019
 */
public class ISBNValidator {
    private String[] validNums;
    private String[] invalidNums;
    /**
     * Default constructor for the ISBN validator class, initializes arrays
     */
    public ISBNValidator(){
        validNums =  new String[1659];
        invalidNums = new String[1659];
    }
    /**
     * Import Data imports .dat file, calls isValidISBN method and stores Strings into corresponding arrays
     */
    public void importData(){
        Scanner in = null;
        try{
           in = new Scanner(new File("isbn_files/isbn3.dat"));
           String temp;
           int validIndex=0;
           int invalidIndex = 0;
           while (in.hasNext()){
               temp=in.nextLine();
               if(isValidISBN(temp)){
                   validNums[validIndex++] = temp;
               }else{
                   invalidNums[invalidIndex++] = temp;
               }
           }
           in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Determines validity of supplied ISBN number. Called inside importData
     * @param isbn an isbn is passed into this method
     * @return true or false based on validity of ISBN
     */
    public boolean isValidISBN(String isbn) {
        isbn = isbn.replace("-", "");
        int sum = 0;
        for(int i =0; i<isbn.length(); i++){
            sum += (i%2==0)? Integer.parseInt(isbn.charAt(i)+""):3*Integer.parseInt(isbn.charAt(i)+"");
        }
        if(Integer.parseInt(isbn.substring(0,3))==978 || Integer.parseInt(isbn.substring(0,3))==979 )
            return sum%10==0;
        return false;
    }

    /**
     * Handles user input for this program
     */
    public void runProgram(){
        boolean running = true;
        Scanner in = new Scanner(System.in);
        while (running) {
            System.out.println("All ISBN data has been imported and validated. Would you like to:");
            System.out.println("1) View all valid ISBN numbers \n2) View all invalid ISBN numbers \n3) Quit");
            String input = in.nextLine();
            int count = 0;
            if (input.equals("1")) {
                for (String validNum : validNums) {
                    if (validNum == null) break;
                    System.out.println(validNum);
                    count++;
                }
                System.out.println(count + " valid ISBN numbers");
            } else if (input.equals("2")) {
                for (String invalidNum : invalidNums) {
                    if (invalidNum == null) break;
                    System.out.println(invalidNum);
                    count++;
                }
                System.out.println(count + " invalid ISBN numbers");
            }else{
                running = false;
            }
        }
    }
    /**
     * Main method for this program
     * @param args command line, if provided
     */
    public static void main(String[] args){
        ISBNValidator app = new ISBNValidator();
        System.out.println("* ISBN Validator Program *");
        System.out.println("...Importing data...");
        app.importData(); // imports data from the text file
        app.runProgram(); // runs using a while loop; see examples
        System.out.println("* End of Program *");
    }

}
