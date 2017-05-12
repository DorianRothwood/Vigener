package Vigener;

import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 * this class is basically useless, just making some tests (that should be done elsewhere) on it
 * @author Michael Roth
 */
public class Runner {
    /**
     * this main class exists temporarily, until I make proper test classes
     * @param args arguments from the command line
     * @since 1.0
     * @author Michael Roth
     */
    public static void main(String[] args) {
        StringBuilder sB = new StringBuilder();
        
        // testing the default constructor for KeyTable, should print out upper case alphabet correctly
        KeyTable.getTableKey(true).forEach((c) -> { sB.append(c);});
        System.out.println(sB.toString());
        sB.delete(0,sB.length());
        
        
        KeyTable.getTableKey(false).forEach((c) -> { sB.append(c);});
        System.out.println(sB.toString());
        sB.delete(0,sB.length());
        
        
        KeyTable.shift(KeyTable.getTableKey(true),3).forEach((c) -> { sB.append(c);}); // love this implementation of foreach, it's just too sexy!
        System.out.println(sB.toString());
        
        sB.delete(0,sB.length()); 
        System.out.println(KeyTable.getKey("Just keep swimming", true));
        
        // i should really get to make those test classes...
        System.out.println();
        
        // prints out the entire key table with key
        char[][] ch = KeyTable.getTable(KeyTable.getTableKey(true));
        sB.delete(0,sB.length());
        
        // 11/12 02:15 my hands are typing words...
        for(int i = 0;i < 26; i++) {
            for(int j = 0; j < 26; j++) {
               sB.append(ch[j][i]);
            }
            sB.append("\n");
        } // end for
        System.out.print(sB.toString());
        
        System.out.println();
        
        // tests the function of process static method
        System.out.println(KeyTable.process("Wololo yeah!", false, false));
        
        
        // System.out.println(Encrypter.encrypt("Dory", "Just keep swimming")); // nope, too early, throws Dory lol
       
       //give'em the sweet line feed gap
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       
       //does it work? Even without Dory? NO WAY! 11/12 03:23 YAY! GOT IT!
       
       String enc = Encrypter.encrypt("Ahoj!", "Bagr");
       System.out.println(Encrypter.encrypt("Ahoj!", "Bagr"));
       System.out.println(enc);
       System.out.println(Decrypter.decrypt(enc, "Bagr"));
       
       String key = KeyTable.getKey(true);
       String encrypt = "Wikipedia";
       String k = "bagr";
       
       StringBuilder b = new StringBuilder();
       
       
       
       GUI.KeyWindow t = new GUI.KeyWindow();
        
        GUI.GUIFrame jF = new GUI.GUIFrame();
        jF.setVisible(true);
       /* 
        jF.setLayout(new GridBagLayout());
        jF.setTitle("Test of TableKey class");
        jF.setSize(520,540);
        jF.setResizable(true);
        jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jF.add(t);
        jF.pack();
        jF.setLocationRelativeTo(null);
        jF.setVisible(true);
        */   
    } // end main(String[])
} // end class Runner
