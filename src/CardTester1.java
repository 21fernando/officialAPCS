/**
 * This is a class that tests the Card class.
 */
public class CardTester1 {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card1 ace = new Card1("ace", "diamonds", 10);
		Card1 jack = new Card1("jack", "hearts", 1);
		Card1 jack2 = new Card1("jack", "hearts", 1);
		Card1 three = new Card1("Three", "clubs", 3);
		System.out.println(ace + " " + jack + " " + three);
		System.out.println(ace.matches(jack));
		System.out.println(jack.matches(jack2));
	}
}
