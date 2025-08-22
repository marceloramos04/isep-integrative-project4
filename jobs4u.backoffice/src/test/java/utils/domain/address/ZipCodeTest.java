package utils.domain.address;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipCodeTest {

    @Test
    void testCorrectZipcodeFormat(){
        String in1="1111-111";
        String in2="1111-222";
        String in3="1112-233";
        assertTrue(ZipCode.checkZipCodeFormat(in1));
        assertTrue(ZipCode.checkZipCodeFormat(in2));
        assertTrue(ZipCode.checkZipCodeFormat(in3));
    }

    @Test
    void testIncorrectZipcodeFormat(){
        String in1="1122-33";
        String in2="11-2233";
        String in3="11111-11111";
        String in4="111-111";

        assertFalse(ZipCode.checkZipCodeFormat(in1));
        assertFalse(ZipCode.checkZipCodeFormat(in2));
        assertFalse(ZipCode.checkZipCodeFormat(in3));
        assertFalse(ZipCode.checkZipCodeFormat(in4));
    }
}