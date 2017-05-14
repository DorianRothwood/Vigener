package Vigenere;

import java.util.ArrayList;

/**
 * this class is used mainly to help both encryption and decryption of the code
 * since version 1.2 supports modifying of the table key
 * @author Michael Roth
 * @since 1.0
 */
public final class KeyTable {
    
    private static final String DEFAULT_KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static ArrayList <Character> getTableKey() {
        return getTableKey(true);
    } // end method getTableKey()
    
    public static ArrayList <Character> getTableKey(boolean upperCase)
    {
        String key;
        ArrayList <Character> arr = new ArrayList();
        
        if(upperCase) key = DEFAULT_KEY;
        else key = DEFAULT_KEY.toLowerCase();
        
        for(int i = 0; i < key.length();i++) 
            if((key.charAt(i) >= 'A' && key.charAt(i) <= 'Z') || (key.charAt(i) >= 'a' && key.charAt(i) <= 'z') && !(arr.contains(key.charAt(i)))) 
                arr.add(key.charAt(i));
        
        return arr;
    } // end method getTableKey(boolean)
    
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
     * this method has no good use yet, just to demonstrate how the Vigenere square works</br>
     * eventually this method may be used in the GUI for encryption (Work not yet in progress)
     * @param arr {@code ArrayList} with the table key (keyed or unkeyed, supports both)
     * @return two-dimensional array of {@code char}s
     * @author Michael Roth
     * @since 2.0
     */
    public static char[][] getTable(ArrayList <Character> arr) {
        
        char[][] ar = new char[26][26];
        
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                ar[i][j] = arr.get(j);
            }
            shift(arr);
        }
        
        return ar;
    } // end static method getTable(ArrayList <Character>)
    /**
     * this method shifts all the characters in the {@code ArrayList} by one to the left
     * @param arr {@code ArrayList} containing the table Key to be shifted
     * @return shifted {@code ArrayList}
     * @author Michael Roth
     * @since 2.0
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
     */
    public static ArrayList <Character> shift(ArrayList <Character> arr, int shiftCount) {
        for(int i = 0; i < shiftCount; i++) {
            char c = arr.get(0);
            arr.remove(0);
            arr.add(c);
        } // end for
        return arr;
    } // end method shift(ArrayList <Character>, int)
    /**
     * this method takes the input {@code String}, sets it to upper case and removes all non-alphabetical characters
     * since version 2.2 method also deletes the spaces (depending on the {@code <b>spaces</b> boolean} value) 
     * @param in input {@code String} to be processed
     * @param spaces {@code boolean} type to decide if processed string should contain spaces, usefull for processing both message and key
     * @return processed {@code String}
     * @author Michael Roth
     * @since 2.2
     */
    public static String process(String in,boolean spaces) {
        StringBuilder s = new StringBuilder();
        for(char c : in.toUpperCase().toCharArray()) {
            if((c > 64 && c < 91) || (c == ' ' && spaces)) {
                s.append(c);
            } // end if()
        } // end for()
        return s.toString();
    } // end static method process(String, boolean)
    public static String process(String in,boolean spaces, boolean upperCase) {
        if(upperCase) return process(in,spaces);
        StringBuilder s = new StringBuilder();
        for(char c : in.toLowerCase().toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c == ' ' && spaces)) {
                s.append(c);
            } // end if()
        } // end for()
        return s.toString();
    } // end static method process(String, boolean)
    
    public static String getKey(boolean upperCase) {
        
        String key;
        if(upperCase) key = DEFAULT_KEY;
        else key = DEFAULT_KEY.toLowerCase();
        return key;
    } // end method getKey(String, boolean)
    
    public static String getKey(String key, boolean upperCase) {
        
        ArrayList <Character> arr = new ArrayList();
        if(upperCase) key = key.toUpperCase();
        StringBuilder sB = new StringBuilder();
        
        for(int i = 0; i<key.length();i++) {
            char c = key.charAt(i);
            if((c > 64 && c < 91) && !(arr.contains(c))) {
                arr.add(c);
                sB.append(c);
            } // end if
        } // end for
        
        if(arr.size() != 26) {
            for(int i = 0; i < 26; i++) {
                char c = (char) (i + 65);
                if(!arr.contains(c)) {
                    arr.add(c);
                    sB.append(c);
                } // end if()
            } // end for
        } // end if
        
        return sB.toString();
    } // end method getKey(String, boolean)
} // end class KeyTable
