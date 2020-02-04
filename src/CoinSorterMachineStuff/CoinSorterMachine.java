package CoinSorterMachineStuff;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Coin Sorter Machine reads in text file and counts the number of each coin present, and the total value of all coins in the set
 * @author 21fernando
 * @version 02/03/2020
 */
public class CoinSorterMachine {

    private ArrayList<Coin> coins;
    private int[] coinCounts;
    private Coin[] coinTypes;

    /**
     * default constructor for this class, initializes arrays and arraylists
     */
    public CoinSorterMachine(){
        coins = new ArrayList<Coin>();
        coinCounts = new int[]{0,0,0,0,0,0};
        coinTypes = new Coin[]{new Penny(), new Nickel(), new Dime(), new Quarter(), new HalfDollar(), new Dollar()};
    }

    /**
     * prompts the user for a file name, converts the text to coin equivalents, and stores them in the coin arraylist
     */
    public void depositCoins(){
        Scanner prompt = new Scanner(System.in);
        System.out.print("Enter the name of the data file for coin deposit: ");
        String filename = prompt.nextLine();
        Scanner read = null;
        try{
            read = new Scanner(new File(filename));
            System.out.println("Depositing coins...");
            while(read.hasNext()){
                String line = read.nextLine();
                switch (line) {
                    case "1":
                        coins.add(new Penny());
                        coinCounts[0]++;
                        break;
                    case "5":
                        coins.add(new Nickel());
                        coinCounts[1]++;
                        break;
                    case "10":
                        coins.add(new Dime());
                        coinCounts[2]++;
                        break;
                    case "25":
                        coins.add(new Quarter());
                        coinCounts[3]++;
                        break;
                    case "50":
                        coins.add(new HalfDollar());
                        coinCounts[4]++;
                        break;
                    case "100":
                        coins.add(new Dollar());
                        coinCounts[5]++;
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Prints deposit summary using a DecimalFormat object (see output section) public void printDepositSummary()
     */
    public void printDepositSummary(){
        System.out.println("Summary of Deposit:");
        DecimalFormat df = new DecimalFormat("$##0.00");
        for (int i = 0; i< coinTypes.length; i++) {
            System.out.println("\t" + coinCounts[i] + " " + ((coinCounts[i]==1)? coinTypes[i].getName():coinTypes[i].getPluralName() )+ " " + df.format(coinCounts[i]* coinTypes[i].getValue()));
        }
        System.out.println("TOTAL DEPOSIT: " + df.format(getTotalValue()));
    }

    /**
     * Sums the total value of all coins in the coins arraylist
     * @return a double that is the total value of all the coins
     */
    public double getTotalValue(){
        double total = 0.0;
        for (Coin c : coins) {
            total += c.getValue();
        }
        return total;
    }

    /**
     * main method for this program
     * @param args command line arguments if provided
     */
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }

}
