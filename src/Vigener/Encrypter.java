package Vigener;

import java.util.ArrayList;

/**
 * this class is used for the actuall encryption of the Vigenere cipher. </br>
 * since version 2.2 there is a funcional method for encrypting the input by selected key</br>
 * in further versions there (hopefully) will be method that allows the keying of the key table as well
 *@since 2.0
 *@author Michael Roth
 *@version 3.0
 */
public final class Encrypter {
    
    public static char encrypt(char input, String tableKey, char index) {
        
        
        tableKey = KeyTable.process(tableKey,false,true);
        
        byte charType = (byte) Character.getType(input);
        
        if(charType != Character.LOWERCASE_LETTER && charType != Character.UPPERCASE_LETTER)
            return input;
        
        int i = tableKey.indexOf(Character.toString(index).toUpperCase());
        
        int j = tableKey.indexOf(Character.toString(input).toUpperCase());
        
        int encryptedIndex = (i+j)%tableKey.length();
                
        if(charType == Character.LOWERCASE_LETTER) 
            return tableKey.toLowerCase().charAt(encryptedIndex);
        else 
            return tableKey.toUpperCase().charAt(encryptedIndex);
    } // end static method encrypt(char, String, int)
    
    public static String encrypt(String input, String key, String tableKey) {
        
        StringBuilder b = new StringBuilder();
        
        key = KeyTable.process(key,false,true);
        
        int j = 0;
        
        for(int i = 0; i < input.length(); i++) {
            
            char in = input.charAt(i);
            
            byte charType = (byte) Character.getType(in); 
            
            if(charType != Character.LOWERCASE_LETTER && charType != Character.UPPERCASE_LETTER) {
                b.append(in);
            } else {
                char k = key.charAt(j%key.length());
                
                b.append(encrypt(in,tableKey,k));
                j++;
            } // end if()
        } // end for()
        
        return b.toString();
    } // end static method encrypt(String,String,String)
    public static String encrypt(String input, String key) {
        
        return encrypt(input,key,KeyTable.getKey(true));
    } // end static method encrypt(String,String,String)
} // end class Encrypter
