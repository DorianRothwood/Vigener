package Vigenere;

import java.util.ArrayList;

/**
 * this class is used mainly to help both encryption and decryption of the code
 * since version 1.2 supports modifying of the table key
 * @author Michael Roth
 * @since 1.0
 */
public final class KeyTable {
    
    /**
     * default table key for general use with unencrypted tables
     * @since 2.2
     * @author Michael Roth
     */
    private static final String DEFAULT_KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    /**
     * overload of method {@code getTableKey(boolean)} with upper case set by default
     * @return table key of type {@code ArrayList <Character>}
     * @deprecated use {@link Vigenere.KeyTable#getKey(boolean, java.lang.String) instead
     */
    @Deprecated
    public static ArrayList <Character> getTableKey() {
        return getTableKey(true);
    } // end method getTableKey()
    
    /**
     * this method returns an ArrayList with set of characters sorted into a table key
     * @param upperCase {@code boolean} value to decide the case of characters inside the table
     * @return table key of type {@code ArrayList <Character>}
     * @deprecated use {@link Vigenere.KeyTable#getKey(boolean, java.lang.String) instead
     */
    @Deprecated
    public static ArrayList <Character> getTableKey(boolean upperCase)
    {
        String key;
        ArrayList <Character> arr = new ArrayList();
        
        if(upperCase) key = DEFAULT_KEY;
        else key = DEFAULT_KEY.toLowerCase();
        
        for(int i = 0; i < key.length();i++) 
            if((Character.getType(key.charAt(i)) == Character.UPPERCASE_LETTER) || (Character.getType(key.charAt(i)) == Character.LOWERCASE_LETTER) && !(arr.contains(key.charAt(i)))) 
                arr.add(key.charAt(i));
        
        return arr;
    } // end method getTableKey(boolean)
    
    /**
     * this method returns an ArrayList with set of characters sorted into a table key using a non-standard key
     * @param key table key of type {@code String} for more secure encryption
     * @param upperCase {@code boolean} value to decide the case of characters inside the table
     * @return table key of type {@code ArrayList <Character>}
     * @deprecated use {@link Vigenere.KeyTable#getKey(boolean, java.lang.String) instead
     */
    @Deprecated
    public static ArrayList <Character> getTableKey(String key, boolean upperCase)
    {
        ArrayList <Character> arr = new ArrayList();
        if(upperCase) key = key.toUpperCase();
        
        for(int i = 0; i<key.length();i++) {
            char c = key.charAt(i);
            if((c > 64 && c < 91) && !(arr.contains(c))) {
                arr.add(c);
            } // end if
        } // end for
        
        if(arr.size() != 26) {
            for(int i = 0; i < 26; i++) {
                char c = (char) (i + 65);
                if(!arr.contains(c)) arr.add(c);
            } // end for
        } // end if
        
        return arr;
    } // end method getTableKey(String, boolean)
    /**
     * this method has no good use anymore, just to demonstrate how the Vigenere square works
     * @param arr {@code ArrayList} with the table key (keyed or unkeyed, supports both)
     * @return two-dimensional array of {@code char}s
     * @author Michael Roth
     * @since 2.0
     * @deprecated not useful anymore
     */
    @Deprecated
    public static char[][] getTable(ArrayList <Character> arr) {
        
        char[][] ar = new char[26][26];
        
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                ar[i][j] = arr.get(j);
            } // end for
            shift(arr);
        } // end for
        
        return ar;
    } // end static method getTable(ArrayList <Character>)
    
    /**
     * this method shifts all the characters in the {@code ArrayList} by one to the left
     * @param arr {@code ArrayList} containing the table Key to be shifted
     * @return shifted {@code ArrayList}
     * @author Michael Roth
     * @since 2.0
     * @deprecated not useful since it's not recommended to use ArrayList using KeyTable methods anymore
     */
    public static ArrayList <Character> shift(ArrayList <Character> arr) {
        char c = arr.get(0);
        arr.remove(0);
        arr.add(c);
        return arr;
    } // end method shift(ArrayList <Character>)
    
    /**
     * this method overloads the original shift method with specified <b>n</b> for shift
     * @param arr {@code ArrayList} containing the table Key to be shifted
     * @param shiftCount {@code int} value of how many times the shift should be executed
     * @return shifted {@code ArrayList}
     * @author Michael Roth
     * @since 2.2
     * @deprecated not useful since it's not recommended to use ArrayList using KeyTable methods anymore
     */
    @Deprecated
    public static ArrayList <Character> shift(ArrayList <Character> arr, int shiftCount) {
        for(int i = 0; i < shiftCount; i++) {
            char c = arr.get(0);
            arr.remove(0);
            arr.add(c);
        } // end for
        return arr;
    } // end method shift(ArrayList <Character>, int)
    
    /**
     * this method is the overload for the method {@code process(String, boolean, boolean)} with upper case by default
     * since version 2.2 method also deletes the spaces (depending on the {@code <b>spaces</b> boolean} value) 
     * @param in input {@code String} to be processed
     * @param spaces {@code boolean} type to decide if processed string should contain spaces, usefull for processing both message and key
     * @return processed {@code String}
     * @see Vigenere.KeyTable#process(java.lang.String, boolean, boolean) 
     * @author Michael Roth
     * @since 2.2
     */
    public static String process(String in,boolean spaces) {
        return process(in,spaces,true);
    } // end static method process(String, boolean)
    
    /**
     * this method takes the input {@code String} and removes all non-alphabetical characters
     * since version 2.2 method also deletes the spaces (depending on the {@code <b>spaces</b> boolean} value) 
     * @param in input {@code String} to be processed
     * @param spaces {@code boolean} type to decide if processed string should contain spaces, usefull for processing both message and key
     * @param upperCase {@code boolean} to decide which case should the 
     * @return processed {@code String}
     * @author Michael Roth
     * @since 2.2
     */
    public static String process(String in,boolean spaces, boolean upperCase) {
        if(upperCase) return process(in,spaces);
        StringBuilder s = new StringBuilder();
        for(char c : in.toLowerCase().toCharArray()) {
            
            // if a selected character is a letter or a blank space (if the spaces variable is true) the letter is appended into the StringBuilder
            if((Character.getType(c) == Character.LOWERCASE_LETTER) || (c == ' ' && spaces)) {
                s.append(c);
            } // end if()
        } // end for()
        
        // based on the upperCase value returns either an uppercase or a lowercase String
        if(upperCase) return s.toString().toUpperCase();
        else return s.toString();
    } // end static method process(String, boolean)
    
    /**
     * this method returns the default table key in the specified case
     * @param upperCase {@code boolean} determining the case of table key 
     * @return table key of type {@code String}
     * @author Michael Roth
     * @since 2.2
     */
    public static String getKey(boolean upperCase) {
        
        String key;
        if(upperCase) key = DEFAULT_KEY;
        else key = DEFAULT_KEY.toLowerCase();
        return key;
    } // end method getKey(String, boolean)
    
    /**
     * this method is used to get the table key used in the encryption
     * @param key a key of type {@code String} to be processed
     * @param upperCase {@code boolean} value to determine the case of the table key
     * @return table key of type {@code String}
     * @author Michael Roth
     * @since 2.2
     */
    public static String getKey(String k, boolean upperCase) {
        
        // ensures the key is in a right format
        String key = KeyTable.process(k,false);
        
        // instantiates a new StringBuilder
        StringBuilder b = new StringBuilder();
        
        // checks if the key variable is empty, if not, iterates the loop
        while(!key.isEmpty()) {
            
            char c = key.charAt(0);
            
            // appends the first character in the key variable and deletes all other occurencs of that character
            b.append(c);
            key.replaceAll(Character.toString(c), "");
            
        } // end while()
        
        // loops through the default key
        for(int i = 0; i < DEFAULT_KEY.length(); i++) {
            
            // stores the current character in a variable and if it's not yet in the StringBuilder, appends it
            char c = DEFAULT_KEY.charAt(i);
            if(b.toString().contains(Character.toString(c))) {
                b.append(c);
            } // end if()
        } // end for()
        
        // returns the String stored in the StringBuilder depending on the case
        if(upperCase) return b.toString();
        else return b.toString().toLowerCase();
    } // end method getKey(String, boolean)
} // end class KeyTable
