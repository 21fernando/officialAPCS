package CoinSorterMachineStuff;
/**
 * Class that represents a Penny and extends the abstract Coin class
 */
public class Penny extends Coin{
    /**
     * Gets the value of a Penny
     * @return value of a Penny
     */
    public double getValue(){
        return 0.01;
    }
    /**
     * Gets name of a Penny
     * @return the name of a Penny
     */
    public String getName(){
        return "Penny";
    }

}
