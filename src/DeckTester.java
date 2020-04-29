/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        Deck2 deck1 = new Deck2(new String[]{"a", "b", "c", "d", "e", "f"}, new String[]{"clubs", "hearts", "spades", "diamonds"}, new int[]{1,2,3,4,5,6});
        System.out.println(deck1);
        Deck2 deck2 = new Deck2(new String[]{"jack", "queen", "king"}, new String[]{"blue", "green"}, new int[]{11,12,13});
        System.out.println("size of second deck: " + deck2.size());
        Deck2 deck3 = new Deck2(new String[]{"A", "B", "C"}, new String[]{"Giraffes", "Lions"}, new int[]{2,1,6});
        for(int i =0; i<10; i++){
            deck3.deal();
        }
        System.out.println(deck3);
    }
}
