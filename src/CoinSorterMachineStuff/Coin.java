package CoinSorterMachineStuff;

/**
 * Abstract Class coin
 * @author 21fernando
 * @version 02/03/2020
 */
public abstract class Coin {
    /**
     * abstract accessor method for a coin's value
     * @return coin's value
     */
    public abstract double getValue();

    /**
     * abstract accessor method for a coin's name
     * @return coin's name
     */
    public abstract String getName();

    /**
     * concrete method that gets a coin's plural name
     * @return the plural name for a coin
     */
    public String getPluralName(){
        if(getName().substring((getName().length()-1)).equals("y")) return "pennies";
        return getName() + "s";
    }

}
