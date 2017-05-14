/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigenere;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author micha
 */
public class KeyTableTest {
    
    public KeyTableTest() {
    }
    
    @Before
    public void setUp() {
        ArrayList <Character> defaultKeyTable = new ArrayList();
        
        for(int i = 0; i < 26; i++) {
            defaultKeyTable.add((char) (i+'A'));
        } // end for
        
        
    } // end method setUp()
    
    private String arrToString(ArrayList <Character> arr) {
        StringBuilder sB = new StringBuilder();
        arr.forEach((c) -> {sB.append(c);});
        return sB.toString();
    } // end method ArrToString(ArrayList <Character>)
    
    @Test
    public void testGetTableKey_general() {
        System.out.println("testing the general structure of the keyTable ArrayList");
        ArrayList <Character> keyTable = KeyTable.getTableKey();
        
        for(int i = 0; i < 26; i++) {
            char c = (char) ( i+'A');
            char a = keyTable.get(i);
            
            assertEquals("expected '"+c+"' at index "+i+", but recieved '"+a+"'",c,a);
        }
        
    }
    
}
