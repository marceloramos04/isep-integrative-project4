package customer.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerCodeTest {

    @Test
    void testCorrectCodeFormat(){
        String in1="ISEP";
        String in2="isep";
        String in3="ISep";
        String in4="ISEP2";
        String in5="xxxxxxxxxx"; //test size limit

        assertTrue(CustomerCode.checkCustomerCodeFormat(in1));
        assertTrue(CustomerCode.checkCustomerCodeFormat(in2));
        assertTrue(CustomerCode.checkCustomerCodeFormat(in3));
        assertTrue(CustomerCode.checkCustomerCodeFormat(in4));
    }

    @Test
    void testIncorrectCodeFormat(){
        String in1="1ISEP";
        String in2="1ISep";
        String in3="xxxxxxxxxxx"; //to size limit

        assertFalse(CustomerCode.checkCustomerCodeFormat(in1));
        assertFalse(CustomerCode.checkCustomerCodeFormat(in2));
        assertFalse(CustomerCode.checkCustomerCodeFormat(in3));
    }
}