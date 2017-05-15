/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigenere;

import java.util.ArrayList;

/**
 * this class is used for Vigenére cypher decryption.
 * @see <a href = https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Vigen%C3%A8re_square_shading.svg/864px-Vigen%C3%A8re_square_shading.svg.png>Vigenére Square using default "ABCD...Z" table key</a>
 * @author Michael Roth
 * @since 3.0
 */
public final class Decrypter {
    
    /**
     * overload of method {@code decrypt(String,String,String)} for use with default table key
     * @param emsg encrypted message of type {@code String}
     * @param key encryption key of type {@code String}
     * @return decrypted message of type {@code String}
     * @see Vigenere.Decrypter#decrypt(java.lang.String, java.lang.String, java.lang.String) 
     * @version 1.0
     * @author Michael Roth
     */
    public static String decrypt(String emsg ,String key) {
        return decrypt(emsg, key, KeyTable.getKey(true));
    } // end static method decrypt(String, String)
    
    /**
     * this method uses the {@link Vigenere.Decrypter#decrypt(char, char, java.lang.String)} method to decrypt the entire strings based on keyword
     * @param emsg encrypted message of type {@code String}
     * @param key encryption key of type {@code String}
     * @param tableKey table key of type {@code String}
     * @return original decrypted text of type {@code String}
     * @see Vigenere.Decrypter#decrypt(char, char, java.lang.String) 
     */
    public static String decrypt(String emsg, String key, String tableKey) {
        
        // instantiates a new StringBuilder
        StringBuilder b = new StringBuilder();
        
        // ensures key is in the right format (all upprecase, no non-letter characters
        key = KeyTable.process(key, false, true);
        
        // declaration of chartype variable: will be used inside the cycle
        byte charType;
        
        // iterator j, used inside the cycle to loop through the key
        int j = 0;
        
        // iterator i is used to loop through the encrypted message
        for(int i = 0; i < emsg.length(); i++) {
            
            // takes the character from the encrypted message
            char c = emsg.charAt(i);
            
            // decides the type of given character
            charType = (byte) Character.getType(c);
            
            // decides wether the current character should be decrypted(non-letter characters are left undecrypted)
            if(charType != Character.LOWERCASE_LETTER && charType != Character.UPPERCASE_LETTER) {
                b.append(c);
            } else {
                b.append(decrypt(c,key.charAt(j%key.length()),tableKey)); // calls the decrypt(char,String,char) method and stores the result in the StringBuilder
                j++; // if the character is a letter, iterates the j iterator to loop through the key
            } // end if()
        } // end for()
        
        // returns the String stored in this StringBuilder
        return b.toString();
    } // end method decrypt(String,String,String)
    
    /**
     * method for decrypting one character, based on encrypted character and one of the coordinates on Vigenére Square
     * @param e encrypted {@code char}
     * @param k one of the known indexes of type {@code char}
     * @param tableKey table key of type {@code String}
     * @return second index of type {@code}
     * @author Michael Roth
     * @version 3.0
     */
    public static char decrypt(char e, char k, String tableKey) {
        
        // casts the character type to a byte variable (method returns int, whereas the constants in Character class are byte)
        byte charType = (byte) Character.getType(e);
        
        // handles all non-letter characters by simply returning them (the cipher does not use them)
        if(charType != Character.LOWERCASE_LETTER && charType != Character.UPPERCASE_LETTER) return e;
        
        // ensures the table key is correct format (uppercase and all letters used one time)
        tableKey = KeyTable.getKey(tableKey, true);
        
        // stores the first coordinate of the encrypted letter
        int index = tableKey.indexOf(Character.toString(k).toUpperCase());
        
        // shifts the key table String, so that the first coordinate has an index 0
        String shift = tableKey.substring(index).concat(tableKey.substring(0,index));
        
        // index of the original letter is equal to the index of the encrypted letter in the shifted key table
        index = shift.indexOf(Character.toString(e).toUpperCase());
        
        // based on the case of the encrypted letter, returns the original letter upper or lower case
        if(charType == Character.LOWERCASE_LETTER) 
            return Character.toLowerCase(tableKey.charAt(index));
        else
            return Character.toUpperCase(tableKey.charAt(index));
    } // end method decrypt(char, String, char)
} // end class decrypter
