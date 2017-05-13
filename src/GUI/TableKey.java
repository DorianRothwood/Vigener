/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Vigener.KeyTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Michael Roth
 */
public class TableKey extends JPanel {
    
    private String tableKey = Vigener.KeyTable.getKey(true);
    private boolean hasKey = false;
    private int yKey = 0;
    private int xKey = -1;
    private boolean manual = true;
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        g.setColor(Color.white);
        g.fillRect(0, 0, 540, 540);
        g.setColor(new Color(0,204,255));
        g.fillRect(20, 0, 520, 20);
        g.setColor(new Color(255,255,0));
        g.fillRect(0, 20, 20, 520);
        
        if(hasKey && manual) {
            g.setColor(new Color(0,213,0));
            g.fillRect(0, (yKey+1)*20, 20, 20);
            g.setColor(new Color(255,255,150));
            g.fillRect(20, (yKey+1)*20, 520, 20);
        } // end if()
        if((xKey != -1) && manual) {
            g.setColor(new Color(128,128,255));
            g.fillRect((xKey+1)*20, 0, 20, 20);
            g.setColor(new Color(203,235,255));
            g.fillRect((xKey+1)*20, 20, 20, 520);
            g.setColor(new Color(255,100,100));
            g.fillRect((xKey+1)*20, (yKey+1)*20, 20, 20);
        } // end if()
        
        
        g.setColor(Color.black);
        for(int i = 0; i < 27; i++) {
            g.drawLine(540/27*(i+1), 0, 540/27*(i+1), 540);
            g.drawLine(0, 540/27*(i+1), 540, 540/27*(i+1));
        } // end for()
        
        g.drawLine(0,0,540,0);
        g.drawLine(0,0,0,540);
        g.drawLine(540,0,540,540);
        g.drawLine(0,540,540,540);
        
        if(tableKey != null) updateKeys(g, tableKey);
        else updateKeys(g);
    } // end method paintComponent(Graphics)
    
    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    } // end method getMaximumSize()
    
    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    } // end method getMinimumSize()
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(541,541);
    } // end method getPrefferedSize()
    
    public void updateKeys(Graphics g) {
        g.setFont(new Font("TimesRoman",Font.PLAIN,12));
        for(int i = 0; i < 26; i++) {
            char c = (char) ('A'+i);
            g.drawString(Character.toString(c), 26 + 20*i, 16);
            g.drawString(Character.toString(c), 6, 34 + 20*i);
        } // end for()
        
        char[][] ch = KeyTable.getTable(KeyTable.getTableKey(true));
        for(int y = 0;y < 26; y++) {
            for(int x = 0; x < 26; x++) {
                g.drawString(Character.toString(ch[y][x]), 26+20*x, 34+20*y);
            }
            
        } // end for
    } // end method updateKeys(Graphics)
    
    public void updateKeys(Graphics g, String key) {
        String k = KeyTable.getKey(key, true);
        
        g.setFont(new Font("TimesRoman",Font.PLAIN,12));
        for(int i = 0; i < 26; i++) {
            char c = k.charAt(i);
            g.drawString(Character.toString(c), 26 + 20*i, 16);
            g.drawString(Character.toString(c), 6, 34 + 20*i);
        } // end for()
        
        char[][] ch = KeyTable.getTable(KeyTable.getTableKey(key, true));
        for(int y = 0;y < 26; y++) {
            for(int x = 0; x < 26; x++) {
                g.drawString(Character.toString(ch[y][x]), 26+20*x, 35+20*y);
            }
            
        } // end for
    } // end method updateKeys(Graphics)
    
    public void setKey(String key) {
        this.tableKey = Vigener.KeyTable.getKey(key,true);
        repaint();
    } // end setter method setKey(String)
    public void setXKey(int i) {
        this.xKey = i;
        repaint();
    } // end setter method setXKey(int)
    public void setYKey(int i) {
        this.yKey = i;
        repaint();
    } // end setter method setYKey(int)
    public void setHasKey(boolean h) {
        this.hasKey = h;
        repaint();
    } // end setter method setHasKey(boolean)
    public String getTableKey() {
        return this.tableKey;
    } // end getter method getTableKey()
    public void setManual(boolean m) {
        this.manual = m;
        repaint();
    } // end setter method setManual(boolean)
} // end class TableKey
