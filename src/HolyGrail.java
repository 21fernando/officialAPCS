/**
 * Holy Grail is a simple input output application
 * @version Wednesday 9/4/19
 * @author 21fernando
 */

import java.util.Scanner;

public class HolyGrail {
    /**
     * Main method for class HolyGrail
     * @param args command line arguments if needed
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
        System.out.print("Question 1: What is your name? ");
        String name = in.nextLine();
        System.out.print("Question 2: What is your quest? ");
        String quest = in.nextLine();
        System.out.print("Question 3: What is your favorite color? ");
        String color = in.nextLine();
        System.out.println("King Arthur says, \"You have to know these things when you're a king, you know.\"");
        System.out.println("Your name is: " + name);
        System.out.println("Your quest is: " + quest);
        System.out.println("Your favorite color is: "+color);
        System.out.println("* end of program *");
    }
}