import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumberTest {

    @Test
    public void testConstructor(){
        RomanNumber romanNumber = new RomanNumber("V", "V", 1);
        Assertions.assertEquals("V", romanNumber.getNumber1());
        Assertions.assertEquals("V", romanNumber.getNumber2());
        Assertions.assertEquals(1, romanNumber.getNumber3());
    }

    @Test
    public void testSingleConversion(){
        RomanNumber romanNumber = new RomanNumber("V", "X", 1);
        Assertions.assertEquals(5, romanNumber.convertNumber(romanNumber.getNumber1()));
        Assertions.assertEquals(10, romanNumber.convertNumber(romanNumber.getNumber2()));
    }

    @Test
    public void testMultipleConversion(){
        RomanNumber romanNumber = new RomanNumber("IV", "XC", 1);
        Assertions.assertEquals(4, romanNumber.convertNumber(romanNumber.getNumber1()));
        Assertions.assertEquals(90, romanNumber.convertNumber(romanNumber.getNumber2()));
    }

    @Test
    public void testException(){
        RomanNumber romanNumber = new RomanNumber("F", "X", 1);
        assertThrows(NumberFormatException.class, () -> {
            romanNumber.convertNumber(romanNumber.getNumber1());
        });
    }

    @Test
    public void testCombineNumbers(){
        RomanNumber romanNumber = new RomanNumber("V","X",18);
        Assertions.assertEquals(33, romanNumber.combineNumbers());
    }

}
