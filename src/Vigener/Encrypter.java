package Vigener;

import java.util.ArrayList;

/**
 * this class is used for the actuall encryption of the Vigenere cipher. </br>
 * since version 2.2 there is a funcional method for encrypting the input by selected key</br>
 * in further versions there (hopefully) will be method that allows the keying of the key table as well
 *@since 2.0
 *@author Michael Roth
 */
public final class Encrypter {
    /*public static String encrypt(String msg, String messageKey) {
        
        // converts the input Strings to acceptable form
        String tableKey = KeyTable.process(messageKey, false); 
        
        
        StringBuilder sB = new StringBuilder(); // creates the StringBuilder to better manipulate the Strings
        // StringBuilder sTestB = new StringBuilder(); // just to test
        
        ArrayList <Character> arr = KeyTable.getTableKey(true); // actually the only way to 
        
        int j = 0;
        for(int i = 0; i < msg.length(); i++) { // need to use iterator, multiple variables rely on it
            // sB.append(KeyTable.shift(arr,arr.indexOf(tableKey.charAt(i % tableKey.length()))).get(arr.indexOf(msg.charAt(i)))); // turns out to throw Dory, at least I know where...
            if(msg.charAt(i) > 'z' || (msg.charAt(i) < 'a' && msg.charAt(i) > 'Z') || msg.charAt(i) < 'A') {
                sB.append(msg.charAt(i)); 
            } else {
                boolean upperCase = Character.isUpperCase(msg.charAt(i));
                ArrayList <Character> ar = new ArrayList <> (KeyTable.shift(KeyTable.getTableKey(upperCase),arr.indexOf(tableKey.charAt(j%tableKey.length())))); // was throwing Dory, don't know why, it does'n do it anymore
               sB.append(ar.get(KeyTable.getTableKey(upperCase).indexOf(msg.charAt(i)))); // actually works, DO NOT TOUCH
                j++;
            } // end if()
        
        } // end for()
        return sB.toString();
    } // end static method encrypt(String, String)
    public static String encrypt(String msg, String messageKey, String tableKey) {
        
        // converts the input Strings to acceptable form
        String tableKey = KeyTable.process(messageKey, false); 
        
        
        StringBuilder sB = new StringBuilder(); // creates the StringBuilder to better manipulate the Strings
        // StringBuilder sTestB = new StringBuilder(); // just to test
        
        ArrayList <Character> arr = KeyTable.getTableKey(tableKey, true); // actually the only way to 
        
        int j = 0;
        for(int i = 0; i < msg.length(); i++) { // need to use iterator, multiple variables rely on it
            // sB.append(KeyTable.shift(arr,arr.indexOf(tableKey.charAt(i % tableKey.length()))).get(arr.indexOf(msg.charAt(i)))); // turns out to throw Dory, at least I know where...
            if(msg.charAt(i) > 'z' || (msg.charAt(i) < 'a' && msg.charAt(i) > 'Z') || msg.charAt(i) < 'A') {
                sB.append(msg.charAt(i)); 
            } else {
                boolean upperCase = Character.isUpperCase(msg.charAt(i));
                ArrayList <Character> ar = new ArrayList <> (KeyTable.shift(KeyTable.getTableKey(tableKey, upperCase),arr.indexOf(tableKey.charAt(j%tableKey.length())))); // was throwing Dory, don't know why, it does'n do it anymore
                sB.append(ar.get(KeyTable.getTableKey(tableKey, upperCase).indexOf(msg.charAt(i)))); // actually works, DO NOT TOUCH
                j++;
            } // end if()
        
        } // end for()
        return sB.toString();
    } // end static method encrypt(String, String)
    */
    public static char encrypt(char input, String tableKey, char index) {
        
        tableKey = KeyTable.process(tableKey,false,true);
        
        int i = tableKey.indexOf(Character.toString(index).toUpperCase());
        
        int j = tableKey.indexOf(Character.toString(input).toUpperCase());
        
        int encryptedIndex = (i+j)%tableKey.length();
                
        if(input >= 'a' && input <= 'z') return tableKey.toLowerCase().charAt(encryptedIndex);
        else return tableKey.toUpperCase().charAt(encryptedIndex);
    } // end static method encrypt(char, String, int)
    
    public static String encrypt(String input, String key, String tableKey) {
        
        StringBuilder b = new StringBuilder();
        
        key = KeyTable.process(key,false,true);
        
        int j = 0;
        
        for(int i = 0; i < input.length(); i++) {
            
            char in = input.charAt(i);
            
            byte charType = (byte) Character.getType(in); 
            
            if(charType == Character.SPACE_SEPARATOR) b.append(in);
            
            if(charType == Character.LOWERCASE_LETTER || charType == Character.UPPERCASE_LETTER) {
                
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
