/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigenere;

import java.util.ArrayList;

/**
 * this is work in progress (no progress made yet)
 * @author Michael Roth
 * since 3.0
 */
public final class Decrypter {
    
    public static String decrypt(String emsg ,String key) {
        return decrypt(emsg, key, KeyTable.getKey(true));
    } // end static method decrypt(String, String)
    
    public static String decrypt(String emsg, String key, String tableKey) {
        
        StringBuilder b = new StringBuilder();
        
        key = KeyTable.process(key, false, true);
        
        byte charType;
        
        int j = 0;
        
        for(int i = 0; i < emsg.length(); i++) {
            
            char c = emsg.charAt(i);
            
            charType = (byte) Character.getType(c);
            
            if(charType != Character.LOWERCASE_LETTER && charType != Character.UPPERCASE_LETTER) {
                b.append(c);
            } else {
                b.append(decrypt(c,key.charAt(j%key.length()),tableKey));
                j++;
            } // end if()
        } // end for()
        
        return b.toString();
    } // end method decrypt(String,String,String)
    public static char decrypt(char e, char k, String tableKey) {
        
        byte charType = (byte) Character.getType(e);
        
        if(charType != Character.LOWERCASE_LETTER && charType != Character.UPPERCASE_LETTER) return e;
        
        tableKey = KeyTable.getKey(tableKey, true);
        
        int index = tableKey.indexOf(Character.toString(k).toUpperCase());
        
        String shift = tableKey.substring(index).concat(tableKey.substring(0,index));
        
        index = shift.indexOf(Character.toString(e).toUpperCase());
        
        if(charType == Character.LOWERCASE_LETTER) 
            return Character.toLowerCase(tableKey.charAt(index));
        else
            return Character.toUpperCase(tableKey.charAt(index));
    } // end method decrypt(char, String, char)
} // end class decrypter
