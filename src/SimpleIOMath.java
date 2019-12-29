import java.util.Scanner;
import java.lang.Math;

/**
 * This is a program that gets numeric and string input from the user
 * @author 21fernando
 * @version 9/12/19
 */
public class SimpleIOMath {

    private String name;
    private int age;
    private int favNumber;

    /**
     * Asks user questions and stores answers in variables
     */
    public void promptUser(){
        Scanner in = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        name = in.nextLine();
        while (true){
            try{
                System.out.print("Question 2: How old are you? ");
                age = in.nextInt();
                break;
            }
            catch(Exception e){
                in.nextLine();
                System.out.print("Please enter integer input");
            }

        }
        while (true){
            try{
                System.out.print("Question 3: What is your favorite number? ");
                favNumber = in.nextInt();
                break;
            }
            catch(Exception e){
                in.nextLine();
                System.out.print("Please enter integer input. ");
            }

        }

    }

    /**
     * Prints the information user has provided computer
     */
    public void printInfo(){
        System.out.println("Print Info");
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age+1) + ".");
        System.out.println("The first prime factor of " + age+ " is: "+ findSmallestPrimeFactor(age));
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + ((int)(Math.pow(favNumber, 2))));
        System.out.println("* end of program *");
    }

    private int findSmallestPrimeFactor(int input){
        for (int i=2; i<(input/2)+1;i++){
            if(input%i == 0 ){
                return i;
            }
        }
        return input;
    }

    /**
     * Main method for class for SimpleIOMath
     * @param args Command line arguments, if needed.
     */
    public static void main(String args[]){
        SimpleIOMath obj = new SimpleIOMath();
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        obj.promptUser();
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        obj.printInfo();

    }

}
