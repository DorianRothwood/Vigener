/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigenere;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Roth
 */
public class EncrypterTest {
    
    public EncrypterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of encrypt method, of class Encrypter.
     * This is a basic test, the the message should not be encrypted given this key.
     * Key is uppercase and same length as the message.
     * Fail in this test means serious program logic error
     */
    @Test
    public void testEncryptBasic() {
        System.out.println("Encrypting the test word \"WIKIPEDIA\" with the key \"AAAAAAAAA\" (encrypted message is expected to be \"WIKIPEDIA\").");
        String msg = "WIKIPEDIA";
        String messageKey = "AAAAAAAAA";
        String expResult = "WIKIPEDIA";
        String result = Encrypter.encrypt(msg, messageKey);
        System.out.println("Encrypted message is: " + result);
        System.out.println();
        assertEquals("the message should not be changed, the encrypted text should be \"WIKIPEDIA\"",expResult, result);
    }
    
    
    /**
     * Test of encrypt method, of class Encrypter
     * the message key should be case-insensitive, this test ensures that
     * fail in this test means the method can't handle mixed case key 
     */
    @Test
    public void testEncryptKeyCase() {
        System.out.println("Encrypting the test word \"WIKIPEDIA\" with the key \"AaaaAaAAA\" (encrypted message is expected to be \"WIKIPEDIA\").");
        String msg = "WIKIPEDIA";
        String messageKey = "AAAAAAAAA";
        String expResult = "WIKIPEDIA";
        String result = Encrypter.encrypt(msg, messageKey);
        System.out.println("Encrypted message is: " + result);
        System.out.println();
        assertEquals("the message should not be changed, the encrypted text should be \"WIKIPEDIA\"",expResult, result);
    }
    
    /**
     * Test of encrypt method, of class Encrypter
     * if the message is longer than the key, method should continue from the start of the, this test ensures that
     * fail in this test means the method can't handle mixed case key 
     */
    @Test
    public void testEncryptKeyDifferentLength() {
        System.out.println("Encrypting the test word \"WIKIPEDIA\" with the key \"AAaAaa\" (encrypted message is expected to be \"WIKIPEDIA\").");
        String msg = "WIKIPEDIA";
        String messageKey = "AAaAaa";
        String expResult = "WIKIPEDIA";
        String result = Encrypter.encrypt(msg, messageKey);
        System.out.println("Encrypted message is: " + result);
        System.out.println();
        assertEquals("the message should not be changed, the encrypted text should be \"WIKIPEDIA\"",expResult, result);
    }
    /**
     * Test of encrypt method, of class Encrypter
     * this test should output standard Caesarian shift of the message word
     * fail in this test
     */
    @Test
    public void testEncryptSimpleKey() {
        String msg = "WIKIPEDIA";
        String messageKey = "b";
        String expResult = "XJLJQFEJB";
        String result = Encrypter.encrypt(msg, messageKey);
        System.out.println("Encrypting the test word \"WIKIPEDIA\" with the key \""+ messageKey +"\" (encrypted message is expected to be \"XJLJQFEJB\").");
        System.out.println("Encrypted message is: " + result);
        System.out.println();
        assertEquals("the encrypted text should be \"XJLJQFEJB\"",expResult, result);
    }
    
    @Test
    public void testEncryptSingleLetter() {
        String key = KeyTable.getKey(true);
        char x = 'w';
        char y = 'b';
        System.out.println("Encrypting the character "+x+" with the character "+y);
        char z1 = Encrypter.encrypt(y, key, x);
        char z2 = Encrypter.encrypt(x, key, y);
        System.out.println("encrypted letters: "+z1+", "+z2);
        System.out.println();
        assertEquals("Encrypted character should be x in both cases",z1,'x');
        assertEquals("Encrypted character should be x in both cases",z2,'x');
    }
    /**
     * Test of encrypt method, of class Encrypter.
     */
    /*@Test
    public void testEncrypt_3args() {
        System.out.println("encrypt");
        String msg = "";
        String messageKey = "";
        String tableKey = "";
        String expResult = "";
        String result = Encrypter.encrypt(msg, messageKey, tableKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
