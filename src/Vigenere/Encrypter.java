package Vigenere;

/**
 * this class is used for the encryption of the message using the Vigenére Square.
 *@since 1.0
 *@author Michael Roth
 *@version 3.0
 */
public final class Encrypter {
    
    /**
     * this method returns a Character located on a Vigenére Square in a row and column determined by the two input Characters
     * @see <a href = https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Vigen%C3%A8re_square_shading.svg/864px-Vigen%C3%A8re_square_shading.svg.png>Vigenére Square using default "ABCD...Z" table key</a>
     * @param input column {@code char)
     * @param tableKey table key of type {@code String}, by default of format "ABCD...Z"
     * @param index row {@code char}
     * @return {@code char} to be returned after encryption
     */
    public static char encrypt(char input, String tableKey, char index) {
        
        // sets the tableKey String to upper case with no spaces or other characters
        tableKey = KeyTable.getKey(tableKey,true);
        
        // stores the type of the Character into a byte value
        byte charType = (byte) Character.getType(input);
        
        // returns all non-letter Characters unchanged
        if(charType != Character.LOWERCASE_LETTER && charType != Character.UPPERCASE_LETTER)
            return input;
        
        // stores the index of the {@code index} Character inside the tableKey String
        int i = tableKey.indexOf(Character.toString(index).toUpperCase());
        
        // stores the index of the {@code input} Character inside the tableKey String
        int j = tableKey.indexOf(Character.toString(input).toUpperCase());
        
        // encryptedIndex stores the index of the character on {@code i}th row and {@code j}th column
        int encryptedIndex = (i+j)%tableKey.length();
        
        // based on the case of the input character, returns the encrypted Character in upper or lower case
        if(charType == Character.LOWERCASE_LETTER) 
            return tableKey.toLowerCase().charAt(encryptedIndex);
        else 
            return tableKey.toUpperCase().charAt(encryptedIndex);
    } // end static method encrypt(char, String, int)
    
    /**
     * {@code encrypt(char,String,char)} method overload for use with default table key
     * @param input column {@code char}
     * @param index row {@code char}
     * @return {@code char} to be returned after encryption
     * @see Vigener.Encrypter#encrypt(char, java.lang.String, char)
     * @author Michael Roth
     * @version 1.0
     */
    public static char encrypt(char input, char index) {
        return encrypt(input, KeyTable.getKey(true),index);
    } // end static method encrypt(char, char)
    
    /**
     * this method uses the {@code encrypt(char,String,char)} method to encrypt whole messages instead of only characters
     * @since 1.0
     * @param input input message of type {@code String}
     * @param key encryption key of type {@code String}
     * @param tableKey table key of type {@code String} for more secure encryption 
     * @return encrypted message of type {@code String}
     * @see Vigener.Encrypter#encrypt(char, java.lang.String, char)
     * @author Michael Roth
     * @version 2.0
     */
    public static String encrypt(String input, String key, String tableKey) {
        
        // instantiates new StringBuilder object
        StringBuilder b = new StringBuilder();
        
        // sets the key String to upper case with no spaces or other characters 
        key = KeyTable.process(key,false,true);
        
        // ensures the correct format of the tableKey
        tableKey = KeyTable.getKey(tableKey,true);
        
        /*
         * this cycle uses two iterators, i and j
         * i iterates throughout the cycle until the end of the input String,
         * j iterates only when a letter is encrypted, doesn't encrypt when a non-letter Character is encrypted
         * j is used for key iteration, so that key doesn't iterate with spaces or other Characters
         */
        int j = 0;
        
        for(int i = 0; i < input.length(); i++) {
            
            char in = input.charAt(i);
            
            // stores the type of the Character into a byte value
            byte charType = (byte) Character.getType(in); 
            
            if(charType != Character.LOWERCASE_LETTER && charType != Character.UPPERCASE_LETTER) {
                b.append(in);
            } else {
                char k = key.charAt(j%key.length()); // finds the key character for encryption
                
                //calls the encrypt(char, String, char) method
                b.append(encrypt(in,tableKey,k));
                j++; // iterates the key iterator j
            } // end if()
        } // end for()
        
        return b.toString(); // returns the value stored in the StringBuilder
    } // end static method encrypt(String,String,String)
    
    /**
     * {@code encrypt()} method overload for use with default table Key
     * @param input an input {@code String} to be encrypted
     * @param key 
     * @return encrypted message of type {@code String}
     * @see Vigener.Encrypter#encrypt(java.lang.String, java.lang.String, java.lang.String) 
     * @author Michael Roth
     * @version 1.0
     */
    public static String encrypt(String input, String key) {
        
        // calls the encrypt(String,String,String) method with default table key imported from the KeyTable class
        return encrypt(input,key,KeyTable.getKey(true));
    } // end static method encrypt(String,String,String)
} // end class Encrypter
