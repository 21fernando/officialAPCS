package CoinSorterMachineStuff;

/**
 * Class that represents a Dollar and extends the abstract Coin class
 */
public class Dollar extends Coin {
    /**
     * Gets the value of a Dollar
     * @return value of a Dollar
     */
    public double getValue(){
        return 1.0;
    }
    /**
     * Gets name of a Dollar
     * @return the name of a Dollar
     */
    public String getName(){
        return "Dollar";
    }

}
