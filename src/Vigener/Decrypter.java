/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigener;

import java.util.ArrayList;

/**
 * this is work in progress (no progress made yet)
 * @author Michael Roth
 * since 3.0
 */
public final class Decrypter {
    /**
     * this method decrypts the encrypted message (with standart table key)
     * @param emsg encrypted message of type {@code String}
     * @param key encryption key of type {@code String}
     * @return decrypted message of type {@code String}
     * @author Michael Roth
     */
    public static String decrypt(String emsg, String key) {
        
        StringBuilder sB = new StringBuilder();
        
        key = KeyTable.process(key, false);
        
        int j = 0;
        
        for(int i = 0; i < emsg.length(); i++) {
            if(emsg.charAt(i) > 'z' || (emsg.charAt(i) < 'a' && emsg.charAt(i) > 'Z') || emsg.charAt(i) < 'A') {
                sB.append(emsg.charAt(i));
            } else {
                boolean upperCase = Character.isUpperCase(emsg.charAt(i));
                ArrayList <Character> arr = KeyTable.getTableKey(upperCase);
                ArrayList <Character> ar = KeyTable.shift(KeyTable.getTableKey(upperCase), KeyTable.getTableKey(true).indexOf(key.charAt(j%key.length())));
                
                sB.append(arr.get(ar.indexOf(emsg.charAt(i))));
                j++;
            } // end if()
        } // end for()
        return sB.toString();
    } // end static method decrypt(String, String)
    public static String decrypt(String emsg, String key, String tableKey) {
        
        StringBuilder b = new StringBuilder();
        
        key = KeyTable.process(key, false, true);
        
        
        return b.toString();
    } // end method decrypt(String,String,String)
} // end class decrypter
