import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class integerDecodeTest {

    @Test
    public void test_simple_value(){
        assertEquals(Integer.decode("707"),new Integer(707));
    }

    @Test (expected = NumberFormatException.class)
    public void test_zero_length(){
        Integer.decode("");
    }

    @Test (expected = NullPointerException.class)
    public void test_null(){
        Integer.decode(null);
    }

    @Test
    public void test_positive_negative_numbers(){
        assertEquals(Integer.decode("-707"),new Integer(-707));
        assertEquals(Integer.decode("+707"),new Integer(707));
    }

    @Test
    public void test_hexadecimal_numbers(){
        assertEquals(Integer.decode("0x2C3"),new Integer(0x2C3));
        assertEquals(Integer.decode("0X2C3"),new Integer(0x2C3));
        assertEquals(Integer.decode("#2C3"),new Integer(0x2C3));
    }

    @Test
    public void test_octal_numbers(){
        assertEquals(Integer.decode("0707"),new Integer(0707));
        assertEquals(Integer.decode("0"),new Integer(0));
    }

    @Test (expected = NumberFormatException.class)
    public void test_double_plus(){
        Integer.decode("++707");
    }
    @Test (expected = NumberFormatException.class)
    public void test_double_minus(){
        Integer.decode("--707");
    }

    @Test (expected = NumberFormatException.class)
    public void test_combined_signs(){
        Integer.decode("-+707");
    }

    @Test (expected = NumberFormatException.class)
    public void test_integer_positive_range(){
        Integer.decode(String.valueOf(Integer.MAX_VALUE + 5l));
    }
    @Test (expected = NumberFormatException.class)
    public void test_integer_negative_range(){
        Integer.decode(String.valueOf(Integer.MIN_VALUE - 5l));
    }

}
