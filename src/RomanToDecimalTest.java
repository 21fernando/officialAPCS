import org.junit.Assert;
import org.junit.Test;

/**
 * This is a junit test for Roman to Decimal, 10 valid, 4 illogical, 4 invalid
 * @author 21fernando
 * @version 9/23/19
 */
public class RomanToDecimalTest {
    /**
     * Main method for roman to decimal test
     */
    @Test
    public void RomanToDecimalTest(){
        Assert.assertEquals(RomanToDecimal.romanToDecimal("IX"), 9);
        Assert.assertEquals(RomanToDecimal.romanToDecimal("XXXIX"), 39);
        Assert.assertEquals(RomanToDecimal.romanToDecimal("CMXLIX"), 949 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("MM"),2000 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("LIV"),54 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("DC"),600 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("XII"),12 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("MCDV"),1405 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("XXII"),22 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("CLXV"),165 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("CDCM"), -1);
        Assert.assertEquals(RomanToDecimal.romanToDecimal("IXIX"),-1 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("IIVI"),-1 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("IL"),-1 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("123"),-1 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("XXICDK"), -1 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("$$$#$@"), -1 );
        Assert.assertEquals(RomanToDecimal.romanToDecimal("WALKER"), -1 );
        Assert.assertNotEquals(RomanToDecimal.romanToDecimal("IC"), 101);
        Assert.assertNotEquals(RomanToDecimal.romanToDecimal("Hello"), 10 );


    }

}
