/**
 * Roman To Decimal is a program that converts roman numerals to decimals
 * @version Monday 9/23/19
 * @author 21fernando
 */
public class RomanToDecimal {
    private static String numerals = "IVXLCDM";
    private static int[] values = {1,5,10,50,100,500,1000};
    private static String[] invariants = {"IV", "IX", "XL", "XC", "CD", "CM"};
    /**
     * Method that is given a roman numeral which is converted into a decimal
     * @param roman input roman numeral
     * @return will return decimal value of roman numeral if valid, else returns -1
     */
    public static int romanToDecimal(String roman){
        int sum = 0;
        try {
            for (int i = 0; i < roman.length(); i++) {
                if (i + 1 <= roman.length() - 1) {
                    String nextTwo = roman.substring(i, i + 2);
                    sum -= checkInvariants(nextTwo);
                }
                sum += charToVal(roman.substring(i, i + 1));
            }
        }
        catch(Exception e){
        }
        // .equals is a method that compares 2 string for equality
        if(decimalToRoman(sum).equals(roman))
            return sum;
        else
            return -1;
    }

    //griffin gave me the idea to check validity like this but I came up with the method
    //inspired by https://www.aivosto.com/visustin/sample/roman.pdf
    private static String decimalToRoman(int decimal){
        int initialval = decimal;
        String roman = "";
        String[] romanNumerals = {"M" , "CM", "D", "CD", "C","XC","L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000,900,500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0;
        while (decimal >0){
            if (decimal >= values[index]){
                decimal -= values[index];
                roman += romanNumerals[index];
            }
            if (decimal < values[index]){
                index ++;
            }
        }
        return roman;
    }

    //Returns the necessary subtraction for an invariant
    private static int checkInvariants(String roman){
        for (int j = 0; j < invariants.length; j++) {
            if (roman.equals(invariants[j]) ) {
                return (charToVal(invariants[j].substring(0, 1)) * 2);
            }
        }
        return 0;
    }

    //given roman numeral returns decimal value
    private static int charToVal(String c){
        return values[numerals.indexOf(c)];
    }

    /**
     * Main method for class for RomanToDecimal
     * @param args Command line arguments, if needed.
     */
    public static void main(String[] args){
        for (String r: args){
            int decimal = RomanToDecimal.romanToDecimal(r.toUpperCase());
            if (decimal == -1){
                System.out.println( r + " => invalid");
            }
            else{
                System.out.println( r + " => " + decimal);
            }
        }
    }
}