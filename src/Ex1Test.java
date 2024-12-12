import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));

    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }



    @Test
    void maxIndexTest() {
        String[] testArray = {"575bG", "165", "ABbD", "17bF", "0b2"};
        assertEquals(0, Ex1.maxIndex(testArray));

        String[] testArray2 = {"0b2", "17bF", "ABbD", "165"};
        assertEquals(3, Ex1.maxIndex(testArray2));
    }
    @Test
    void int2numberTest()
    {
        assertEquals("111b2", Ex1.int2Number(7, 2));
        assertEquals("A2bG", Ex1.int2Number(162, 16));
        assertEquals("", Ex1.int2Number(-10, 10));
        assertEquals("", Ex1.int2Number(10, 20));
        assertEquals("", Ex1.int2Number(-1, 2));
        assertEquals("", Ex1.int2Number(165, 17));
        assertEquals("10100101b2", Ex1.int2Number(165, 2));
        assertEquals("A5bG", Ex1.int2Number(165, 16));
        assertEquals("", Ex1.int2Number(165, 1));
        assertEquals("0b2", Ex1.int2Number(0, 2));
    }
    @Test
    void  number2intTest()
    {
        assertEquals(1397, Ex1.number2Int("575bG"));
        assertEquals(165, Ex1.number2Int("165"));
        assertEquals(141, Ex1.number2Int("ABbD"));
        assertEquals(7, Ex1.number2Int("012b5"));
        assertEquals(117, Ex1.number2Int("7CbF"));
        assertEquals(0, Ex1.number2Int("0b2"));
        //Not in the valid format
        assertEquals(-1, Ex1.number2Int("85Ab9"));
        assertEquals(-1, Ex1.number2Int("@b3"));
        assertEquals(-1, Ex1.number2Int("17b@"));
        assertEquals(-1, Ex1.number2Int("2310b2"));
        assertEquals(-1, Ex1.number2Int("456b1"));
        assertEquals(-1, Ex1.number2Int("79DbB"));
        assertEquals(-1, Ex1.number2Int("b"));
        assertEquals(-1, Ex1.number2Int("b2"));
        assertEquals(-1, Ex1.number2Int(" "));
        assertEquals(-1, Ex1.number2Int("13b"));
        assertEquals(-1, Ex1.number2Int("13 b5"));
        assertEquals(-1, Ex1.number2Int("56b 8"));
        assertEquals(-1, Ex1.number2Int("5 b 9"));
        assertEquals(-1, Ex1.number2Int("b4"));
        assertEquals(22, Ex1.number2Int("17bF"));
        assertEquals(-1, Ex1.number2Int("-3b6"));
        assertEquals(-1, Ex1.number2Int("0b1"));
        assertEquals(-1, Ex1.number2Int("GbG"));
    }
    @Test
    void isNumberTest()
    {
        assertTrue(Ex1.isNumber("575bG"));
        assertTrue(Ex1.isNumber("165"));
        assertTrue(Ex1.isNumber("ABbD"));
        assertTrue(Ex1.isNumber("012b5"));
        assertTrue(Ex1.isNumber("1A37CbF"));
        assertTrue(Ex1.isNumber("0b2"));
        assertTrue(Ex1.isNumber("15bF"));
        assertFalse(Ex1.isNumber("85Ab9"));

        assertFalse(Ex1.isNumber("@b3"));
        assertFalse(Ex1.isNumber("17b@"));
        assertFalse(Ex1.isNumber("2310b2"));
        assertFalse(Ex1.isNumber("456b1"));
        assertFalse(Ex1.isNumber("79DbB"));
        assertFalse(Ex1.isNumber("b"));
        assertFalse(Ex1.isNumber("b2"));
        assertFalse(Ex1.isNumber(" "));
        assertFalse(Ex1.isNumber("13b"));
        assertFalse(Ex1.isNumber("13 b5"));
        assertFalse(Ex1.isNumber("56b 8"));
        assertFalse(Ex1.isNumber("5 b 9"));
        assertFalse(Ex1.isNumber("b4"));
        assertFalse(Ex1.isNumber("-3b6"));
        assertFalse(Ex1.isNumber("0b1"));
        assertFalse(Ex1.isNumber("GbG"));
    }

    @Test
    void EqualsTest() {
        assertFalse(Ex1.equals("575bG", "165"));
        assertFalse(Ex1.equals("ABbD", "012b5"));
        assertFalse(Ex1.equals("7CbF", "5Ab9"));
        assertFalse(Ex1.equals("10100b2", "111b2"));
        assertTrue(Ex1.equals("0b2", "0b2"));
        assertTrue(Ex1.equals("1111b2","21b7"));
    }

    @Test
    void CheckDigitTest()
    {// Valid cases where all characters are digits
        assertTrue(Ex1.checkDigit("123"));
        assertTrue(Ex1.checkDigit("4567890"));
        assertTrue(Ex1.checkDigit("0"));
        assertTrue(Ex1.checkDigit("1"));
        // Invalid cases with non-digit characters
        assertFalse(Ex1.checkDigit("689#%"));
        assertFalse(Ex1.checkDigit("$%^ "));
        assertFalse(Ex1.checkDigit("@35"));
        assertFalse(Ex1.checkDigit("!"));
        assertFalse(Ex1.checkDigit("123a"));
        assertFalse(Ex1.checkDigit("abc"));
        assertFalse(Ex1.checkDigit("12 34"));
        assertFalse(Ex1.checkDigit("-123"));
    }

    @Test
    void  NumSwitchTest()
    {
        // Valid character inputs and their expected numeric values
        assertEquals(0, Ex1.numSwitch("0"));
        assertEquals(1, Ex1.numSwitch("1"));
        assertEquals(2, Ex1.numSwitch("2"));
        assertEquals(9, Ex1.numSwitch("9"));
        assertEquals(10, Ex1.numSwitch("A"));
        assertEquals(15, Ex1.numSwitch("F"));
        // Invalid cases that should return -1
        assertEquals(-1, Ex1.numSwitch("G"));
        assertEquals(-1, Ex1.numSwitch("Z"));
        assertEquals(-1, Ex1.numSwitch("!"));
        assertEquals(-1, Ex1.numSwitch("a"));

    }

    @Test
    void BaseSwitchTest()
    {
        // Valid bases
        assertEquals(2, Ex1.baseSwitch("2"));
        assertEquals(3, Ex1.baseSwitch("3"));
        assertEquals(10, Ex1.baseSwitch("A"));
        assertEquals(16, Ex1.baseSwitch("G"));
        // Invalid cases that should return -1
        assertEquals(-1, Ex1.baseSwitch("1"));
        assertEquals(-1, Ex1.baseSwitch("0"));
        assertEquals(-1, Ex1.baseSwitch("H"));
        assertEquals(-1, Ex1.baseSwitch("17"));
        assertEquals(-1, Ex1.baseSwitch("Z"));
    }

    @Test
    void multiTest()
    {
        assertEquals("1010010b2", Ex1.multi("41b10", "2b10", "2"));
        assertEquals("2000110b3", Ex1.multi("41b5", "77b9", "3"));
        assertEquals("157E8bG", Ex1.multi("1000111b2", "3421b7", "16"));
    }

    @Test
    void addTest()
    {

        assertEquals("101011b2", Ex1.add("41b10", "2b10", "2"));
        assertEquals("10101b3", Ex1.add("41b5", "77b9", "3"));
        assertEquals("51FbG", Ex1.add("1000111b2", "3421b7", "16"));
    }



}